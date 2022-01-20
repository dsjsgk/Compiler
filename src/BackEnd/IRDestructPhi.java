package BackEnd;

import MIR.*;

import java.util.ArrayList;

public class IRDestructPhi extends IRPass {
    public IRDestructPhi(IRModule Mod) {
        super(Mod);
    }
    public void DoThisMod() {
        thisModule.Funcs.forEach((str,irFunc)->{DoThisFunc(irFunc);});
    }
    public void DoThisFunc(IRFunction thisFunc) {
        BasicBlock ptrr = thisFunc.entry;
        ArrayList<BasicBlock> List = new ArrayList<>();
        while(ptrr!=null){
            List.add(ptrr);//System.out.println("fuck");
            ptrr._Init();
            ptrr = ptrr.nxt_block;
        }
        //ptr = thisFunc.entry;

        for(BasicBlock ptr : List) {
            ArrayList<PhiInst> PhiList = new ArrayList<>();
            Inst InstPtr = ptr.begin_Inst;
            while(InstPtr!=null) {
                if(InstPtr instanceof PhiInst) PhiList.add((PhiInst) InstPtr);
                InstPtr = InstPtr.Nxt;
            }
            if(PhiList.size()==0) continue;
            ArrayList<BasicBlock> nwpre = new ArrayList<>(ptr.predecessors);
            for(BasicBlock Pre:nwpre) {
                BasicBlock Mid = new BasicBlock(Pre.func,"MiddleBlock");
                Mid.addBack(new BranchInst(ptr,null,null,Mid));
                if(((BranchInst)Pre.end_Inst).b1==ptr) {
                    ((BranchInst)Pre.end_Inst).b1 = Mid;
                }
                if(((BranchInst)Pre.end_Inst).b2==ptr) {
                    ((BranchInst)Pre.end_Inst).b2 = Mid;
                }
                Mid.predecessors.add(Pre);Mid.successors.add(ptr);
                Pre.successors.remove(ptr);
                Pre.successors.add(Mid);
                ptr.predecessors.remove(Pre);
                ptr.predecessors.add(Mid);
                Pre.func.addBlockAfter(Pre,Mid);
                for(PhiInst phiInst:PhiList) {
                    for(int i=0;i<phiInst.list_block.size();++i) {
                        if(phiInst.list_block.get(i)==Pre) {
                            Mid.addInstBefore(Mid.end_Inst,new MoveInst(phiInst.res,phiInst.list_val.get(i),Mid));
                        }
                    }
                }
            }
            PhiList.forEach(phiInst -> {phiInst.Delete();});
            ptr = ptr.nxt_block;
        }
    }
}
