package BackEnd;

import ASM.ASMBasicBlock;
import ASM.ASMFunction;
import ASM.ASMInst;
import ASM.ASMModule;
import ASM.Inst.*;
import ASM.Operand.ASMAddress;
import ASM.Operand.IntImm;
import ASM.Operand.PhysicalReg;
import ASM.Operand.VirtualReg;
import MIR.Inst;
import org.antlr.v4.runtime.misc.Pair;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class GraphColoring {
    ASMModule thisMod;
    static int K = 27;
    public GraphColoring(ASMModule thisMod) {
        this.thisMod = thisMod;
    }
    HashMap<ASMBasicBlock, HashSet<VirtualReg> > live_in_reg = new HashMap<>(),live_out_reg = new HashMap<>(),block_def = new HashMap<>();
    HashSet<VirtualReg> simplifyWorklist = new HashSet<>();
    HashSet<ASMMvInst> worklistMoves = new HashSet<>();
    HashSet<VirtualReg> freezeWorklist = new HashSet<>();
    HashSet<VirtualReg> spillWorklist = new HashSet<>();

    HashSet<VirtualReg> precolored_reg = new HashSet<>();
    HashSet<VirtualReg> initial_reg = new HashSet<>();
    HashSet<VirtualReg> spilled_reg = new HashSet<>();
    HashSet<VirtualReg> coalesced_reg = new HashSet<>();
    HashSet<VirtualReg> colored_reg = new HashSet<>();
    Stack<VirtualReg> selectStack = new Stack<>();

    HashSet<ASMMvInst> coalescedMoves = new HashSet<>();
    HashSet<ASMMvInst> constrainedMoves = new HashSet<>();
    HashSet<ASMMvInst> frozenMoves = new HashSet<>();
//    HashSet<ASMMvInst> worklistMoves = new HashSet<>();
    HashSet<ASMMvInst> activeMoves = new HashSet<>();

    HashSet<Pair<VirtualReg,VirtualReg> > adjSet = new HashSet<>();
    HashMap<VirtualReg,HashSet<VirtualReg>> adjList = new HashMap<>();
    HashMap<VirtualReg,Integer> degree = new HashMap<>();
    HashMap<VirtualReg,HashSet<ASMMvInst> > moveList = new HashMap<>();
    HashMap<VirtualReg,VirtualReg> alias = new HashMap<>();
    HashMap<VirtualReg,PhysicalReg> color = new HashMap<>();


    public void livenessanalysis(ASMFunction thisFunc) {
        //对BasicBlock进行Liveness Analysis
        ASMBasicBlock curBlock = thisFunc.entry;
        while(curBlock!=null) {
            ASMInst curInst = curBlock.Inst_begin;
            HashSet<VirtualReg> BlockUse = new HashSet<>();
            HashSet<VirtualReg> BlockDef = new HashSet<>();
            while(curInst!=null) {
                curInst._rs.forEach(x->{
                    if(!BlockDef.contains(x)) {
                        BlockUse.add(x);
                    }
                });
                curInst._rd.forEach(x->{
                    BlockDef.add(x);
                });
                curInst = curInst.Nxt;
            }
            live_in_reg.put(curBlock,BlockUse);
            live_out_reg.put(curBlock,new HashSet<>());
            block_def.put(curBlock,BlockDef);
            curBlock = curBlock.nxt_Block;
        }
        //迭代求LiveinLiveout
        while(true) {
            boolean flag = true;
            curBlock = thisFunc.entry;
            while(curBlock!=null) {

                HashSet<VirtualReg> in = live_in_reg.get(curBlock);
                HashSet<VirtualReg> out = live_out_reg.get(curBlock);
                int _in = in.size();
                int _out = out.size();
                out.removeAll(block_def.get(curBlock));
                in.addAll(out);
                curBlock.succ.forEach(
                  x->{
                      out.addAll(live_in_reg.get(x));
                  }
                );
                if(_in!=in.size()||_out!=out.size()) flag = false;
                curBlock = curBlock.nxt_Block;
            }

            if(flag) break;
        }
    }
    public void Build(ASMFunction thisFunc) {
        ASMBasicBlock curBlock = thisFunc.entry;
        while(curBlock!=null) {
            HashSet<VirtualReg> live = live_out_reg.get(curBlock);
            ASMInst curInst = curBlock.Inst_end;
            while(curInst!=null) {
                if(curInst instanceof ASMMvInst) {
                    live.removeAll(curInst._rs);
                    //不在rs和rd之间连边
//                    curInst._rs.forEach(x->moveList.get(x).add((ASMMvInst) curInst));
                    for(VirtualReg temp:curInst._rs) {
                        moveList.get(temp).add((ASMMvInst) curInst);
                    }
                    for(VirtualReg temp:curInst._rd) {
                        moveList.get(temp).add((ASMMvInst) curInst);
                    }
                    worklistMoves.add((ASMMvInst) curInst);
                }
                live.addAll(curInst._rd);
                for(VirtualReg temp:curInst._rd) {
                    for(VirtualReg temp2:live) {
                        AddEdge(temp,temp2);
                    }
                }
                live.removeAll(curInst._rd);
                live.addAll(curInst._rs);
                curInst = curInst.Pre;
            }
            curBlock = curBlock.nxt_Block;
        }
    }
    public void AddEdge(VirtualReg u,VirtualReg v) {
        if(adjSet.contains(new Pair<>(u,v))||u==v) return ;
        adjSet.add(new Pair<>(u,v));
        adjSet.add(new Pair<>(v,u));
        if(!precolored_reg.contains(u)) {
            adjList.get(u).add(v);
            degree.replace(u,degree.get(u)+1);
        }
        if(!precolored_reg.contains(v)) {
            adjList.get(v).add(u);
            degree.replace(v,degree.get(v)+1);
        }
    }
    public void MakeWorklist() {
//        if(initial_reg==null) {
//        System.out.println(initial_reg.size());
        for(VirtualReg n:initial_reg) {

//            initial_reg.remove(n);
            if(degree.get(n)>=K) {
                spillWorklist.add(n);
            }
            else if(MoveRelated(n)) {
                freezeWorklist.add(n);
            }
            else simplifyWorklist.add(n);
        }
        initial_reg.clear();
    }
    public HashSet<VirtualReg> Adjacent(VirtualReg n) {
        HashSet<VirtualReg> temp = new HashSet<>(adjList.get(n));
        temp.removeAll(selectStack);
        temp.removeAll(coalesced_reg);
        return temp;
    }
    public HashSet<ASMMvInst> NodeMoves(VirtualReg n) {
        HashSet<ASMMvInst> temp = new HashSet<>(worklistMoves);
        temp.addAll(activeMoves);
        temp.retainAll(moveList.get(n));
        return temp;
    }
    public boolean MoveRelated(VirtualReg n) {
        return NodeMoves(n).size()>0;
    }
    public void Simplify() {
        VirtualReg n = simplifyWorklist.iterator().next();
//        {
            simplifyWorklist.remove(n);
            selectStack.push(n);
            for(VirtualReg tmp:Adjacent(n)) {
                DecrementDegree(tmp);
            }
//        }
    }
    public void DecrementDegree(VirtualReg tmp) {
        int d = degree.get(tmp);
        degree.replace(tmp,d-1);
        if(d==K) {
            //enable moves
            HashSet<VirtualReg> temp = Adjacent(tmp);
            temp.add(tmp);
            EnableMoves(temp);
            spillWorklist.remove(tmp);
            if(MoveRelated(tmp)) {
                freezeWorklist.add(tmp);
            }
            else simplifyWorklist.add(tmp);
        }
    }
    public void EnableMoves(HashSet<VirtualReg> tmp) {
        for(VirtualReg thisreg:tmp) {
            for(ASMMvInst thisInst:NodeMoves(thisreg)) {
                if(activeMoves.contains(thisInst)) {
                    activeMoves.remove(thisInst);
                    worklistMoves.add(thisInst);
                }
            }
        }
    }

    public void Coalesce() {
        if(worklistMoves.isEmpty()) return ;
        ASMMvInst m = worklistMoves.iterator().next();
        VirtualReg u = GetAlias(m.rd);
        VirtualReg v = GetAlias(m.rs);
        if(!precolored_reg.contains(u)) {
            VirtualReg t=u;
            u = v;
            v = t;
        }
        worklistMoves.remove(m);
        if(u==v) {
            m.bel.remove(m);
            coalescedMoves.add(m);
            AddWorkList(u);
        }
        else if(precolored_reg.contains(v)||adjSet.contains(new Pair<>(u,v))||isZero(u)||isZero(v)){
            constrainedMoves.add(m);
            AddWorkList(u);
            AddWorkList(v);
        }
        else {
            boolean flag1 = false,flag2 = false;
            HashSet<VirtualReg> tmp = new HashSet<>(Adjacent(u));
            tmp.addAll(Adjacent(v));
            flag1 = (!precolored_reg.contains(u))&&Conservative(tmp);
            flag2 = (precolored_reg.contains(u));
            for(VirtualReg t:Adjacent(v)) flag2&=OK(t,u);
            if(flag1||flag2) {
                m.bel.remove(m);
                coalescedMoves.add(m);
                Combine(u,v);
                AddWorkList(u);
            }
            else activeMoves.add(m);
        }

    }
    //Briggs
    public boolean Conservative(HashSet<VirtualReg> tmp) {
        int tot=0;
        for(VirtualReg temp:tmp) {
            if(degree.get(temp)>=K) tot++;
        }
        return tot<K;
    }
    //George
    public boolean OK(VirtualReg t,VirtualReg r) {
        return (degree.get(t)<K)||precolored_reg.contains(t)||adjSet.contains(new Pair<>(t,r));
    }
    public void Combine(VirtualReg u,VirtualReg v){
        if(freezeWorklist.contains(v)) {
            freezeWorklist.remove(v);
        }
        else spillWorklist.remove(v);
        coalesced_reg.add(v);
        alias.put(v,u);
        moveList.get(u).addAll(moveList.get(v));
        HashSet<VirtualReg> temp = new HashSet<VirtualReg>();
        temp.add(v);
        EnableMoves(temp);
        for(VirtualReg tmp:Adjacent(v)) {
            AddEdge(tmp,u);
            DecrementDegree(tmp);
        }
        if(degree.get(u)>=K&&freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }
    public void Freeze() {
        if(freezeWorklist.size()==0) return;
        VirtualReg u = freezeWorklist.iterator().next();
        freezeWorklist.remove(u);
        simplifyWorklist.add(u);
        FreezeMoves(u);
    }
    public void FreezeMoves(VirtualReg u) {
        for(ASMMvInst thisInst:NodeMoves(u)) {
            VirtualReg x = thisInst.rs;
            VirtualReg y = thisInst.rd;
            VirtualReg v;
            if(GetAlias(x)==GetAlias(u)) {
                v = GetAlias(x);
            }
            else v = GetAlias(y);
            activeMoves.remove(thisInst);
            frozenMoves.add(thisInst);
            if(NodeMoves(v).size()==0&&degree.get(v)<K) {
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }
    public void SelectSpill() {
       //need to improve
        VirtualReg res = null;
        int cur = -1;
        for(VirtualReg tmp:spillWorklist) {
            if(degree.get(tmp)>cur) {
                cur = degree.get(tmp);
                res = tmp;
            }
        }
        spillWorklist.remove(res);
        simplifyWorklist.add(res);
        FreezeMoves(res);
    }
//    boolean vis[1000];
    public void AssignColors() {
        while(selectStack.size()>0) {
            VirtualReg top = selectStack.pop();
            boolean [] vis = new boolean[32];
            for(int i=0;i<32;++i) vis[i] = false;
            for(VirtualReg tmp:adjList.get(top)) {
                if(colored_reg.contains(GetAlias(tmp))||precolored_reg.contains(GetAlias(tmp))) {
                    vis[GetAlias(tmp).Allocated_Reg.Num]=true;
                }
            }
            int ok=-1;
            for(int i=5;i<32;++i) if(!vis[i]) ok = i;
            if(ok==-1) {
                spilled_reg.add(top);
            }
            else {
                colored_reg.add(top);
                top.Allocated_Reg = PhysicalReg.getp(PhysicalReg.Name.get(ok));
//                System.out.println(top.Allocated_Reg.Identifier);
            }
        }
        for(VirtualReg tmp:coalesced_reg) {
            tmp.Allocated_Reg = GetAlias(tmp).Allocated_Reg;
        }
    }
    public void AddWorkList(VirtualReg u) {
        if(!precolored_reg.contains(u)&&!MoveRelated(u)&&degree.get(u)<K) {
            freezeWorklist.remove(u);
            simplifyWorklist.add(u);
        }
    }
    public boolean isZero(VirtualReg u) {
        if(u.Allocated_Reg==null) return false;
        if(u.Allocated_Reg.Identifier.equals("zero")) return true;
        else return false;
    }
    public VirtualReg GetAlias(VirtualReg tmp) {
        if(coalesced_reg.contains(tmp)) return GetAlias(alias.get(tmp));
        else return tmp;
    }
    public void DoThisFunc(ASMFunction thisFunc) {
//        thisFunc.stk.SpaceSize = 0;

        live_in_reg = new HashMap<>();
        live_out_reg = new HashMap<>();
        block_def = new HashMap<>();
        simplifyWorklist = new HashSet<>();
        worklistMoves = new HashSet<>();
        freezeWorklist = new HashSet<>();
        spillWorklist = new HashSet<>();

        precolored_reg = new HashSet<>();
        initial_reg = new HashSet<>();
        spilled_reg = new HashSet<>();
        coalesced_reg = new HashSet<>();
        colored_reg = new HashSet<>();
        selectStack = new Stack<>();

        coalescedMoves = new HashSet<>();
        constrainedMoves = new HashSet<>();
        frozenMoves = new HashSet<>();
        activeMoves = new HashSet<>();

        adjSet = new HashSet<>();
        adjList = new HashMap<>();
        degree = new HashMap<>();
        moveList = new HashMap<>();
        alias = new HashMap<>();
        color = new HashMap<>();//没用
        ASMBasicBlock curBlock = thisFunc.entry;
        while(curBlock!=null) {
            ASMInst curptr = curBlock.Inst_begin;
            while(curptr!=null) {
                curptr._rd.forEach(x->{
                    if(x.Allocated_Reg!=null) {
                        precolored_reg.add(x);
                    }
                    else initial_reg.add(x);
                });
                curptr._rs.forEach(x->{
                    if(x.Allocated_Reg!=null) {
                        precolored_reg.add(x);
                    }
                    else initial_reg.add(x);
                });
                curptr = curptr.Nxt;
            }
            curBlock = curBlock.nxt_Block;
        }
        for(VirtualReg x:precolored_reg) {
            degree.put(x,10000001);
            alias.put(x,null);
            moveList.put(x,new HashSet<>());
            adjList.put(x,new HashSet<>());
        }
        for(VirtualReg x:initial_reg) {
            degree.put(x,0);
            alias.put(x,null);
            moveList.put(x,new HashSet<>());
            adjList.put(x,new HashSet<>());
        }
        livenessanalysis(thisFunc);
        Build(thisFunc);
        MakeWorklist();
        while(true) {
            if(simplifyWorklist.size()!=0) Simplify();
            else if(worklistMoves.size()!=0) Coalesce();
            else if(freezeWorklist.size()!=0) Freeze();
            else if(spillWorklist.size()!=0) SelectSpill();
            else break;
        }
        AssignColors();
        if(spilled_reg.size()!=0) {
            RewriteProgram(spilled_reg,thisFunc);
            DoThisFunc(thisFunc);
        }
    }
    HashMap<VirtualReg,Integer> Imm_Map = new HashMap<>();
    public void RewriteProgram(HashSet<VirtualReg> NodeList,ASMFunction thisFunc) {
        for(VirtualReg thisReg:NodeList) {
            if(Imm_Map.containsKey(thisReg)){
                Imm_Map.put(thisReg,thisFunc.stk.SpaceSize);
                thisFunc.stk.SpaceSize+=4;
            }
        }
        ASMBasicBlock curBlock = thisFunc.entry;
        while(curBlock!=null) {
            ASMInst curInst = curBlock.Inst_begin;
            while(curInst != null) {
                for (VirtualReg r : curInst._rs) {
                    if(!NodeList.contains(r)) continue;
                    VirtualReg tempReg1 = new VirtualReg("temp1");
                    VirtualReg tempReg2 = new VirtualReg("temp2");
                    VirtualReg tempReg3 = new VirtualReg("temp3");
                    curInst.replaceRs(r,tempReg3);
                    curBlock.addBefore(curInst,new ASMLiInst(tempReg1,new IntImm(Imm_Map.get(r)),curBlock));
                    curBlock.addBefore(curInst,new ASMBinaryInst(tempReg2,tempReg1,PhysicalReg.getv("sp"),null,ASMBinaryInst.Op.add,curBlock));
                    curBlock.addBefore(curInst,new ASMLoadInst(tempReg3,new ASMAddress(tempReg2,new IntImm(0)), ASMLoadInst.Op.lw,curBlock));
                }
                for (VirtualReg r : curInst._rd) {
                    if(!NodeList.contains(r)) continue;
                    VirtualReg tempReg1 = new VirtualReg("temp1");
                    VirtualReg tempReg2 = new VirtualReg("temp2");
                    VirtualReg tempReg3 = new VirtualReg("temp3");
                    curInst.replaceRd(r,tempReg3);
                    curBlock.addAfter(curInst,new ASMStoreInst(tempReg3,new ASMAddress(tempReg2,new IntImm(0)), ASMStoreInst.Op.sw,curBlock));
                    curBlock.addAfter(curInst,new ASMBinaryInst(tempReg2,tempReg1,PhysicalReg.getv("sp"),null,ASMBinaryInst.Op.add,curBlock));
                    curBlock.addAfter(curInst,new ASMLiInst(tempReg1,new IntImm(Imm_Map.get(r)),curBlock));
                }
                curInst = curInst.Nxt;
            }
            curBlock = curBlock.nxt_Block;
        }
    }
    public void RegAllocator() {
        for(ASMFunction thisFunc:thisMod.Funcs.values()) {
            VirtualReg size1 = new VirtualReg("StackFrameSize1");
            VirtualReg size2 = new VirtualReg("StackFrameSize2");
            thisFunc.entry.addFront(new ASMBinaryInst(PhysicalReg.getv("sp"), PhysicalReg.getv("sp"),size1,null, ASMBinaryInst.Op.add, thisFunc.entry));
            ASMLiInst front = new ASMLiInst(size1,new IntImm(0),thisFunc.entry);
            ASMLiInst end = new ASMLiInst(size2,new IntImm(0),thisFunc.exit);
            thisFunc.entry.addFront(front);

            thisFunc.exit.addBefore(thisFunc.exit.Inst_end,end);
            thisFunc.exit.addBefore(thisFunc.exit.Inst_end,new ASMBinaryInst(PhysicalReg.getv("sp"), PhysicalReg.getv("sp"),size2,null, ASMBinaryInst.Op.add, thisFunc.exit));
            thisFunc.stk.SpaceSize = 0;
            thisFunc.stk.InitInit();
            DoThisFunc(thisFunc);
            thisFunc.stk.Init();
//            System.out.println(thisFunc.stk.SpaceSize);
            front.imm = new IntImm(-thisFunc.stk.SpaceSize);
            end.imm = new IntImm(thisFunc.stk.SpaceSize);
        }
    }
}
