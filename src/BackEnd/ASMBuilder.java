package BackEnd;

import ASM.ASMBasicBlock;
import ASM.ASMFunction;
import ASM.ASMModule;
import ASM.Inst.*;
import ASM.Operand.*;
import ASM.StackFrame;
import MIR.*;
import Util.ArrayType;
import Util.ClassType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ASMBuilder implements IRvisitor {
    public ASMModule thisASMModule;
    public IRModule thisIRModule;
//    public IRModule thisIRModule;
    public ASMFunction curFunc;
    public ASMBasicBlock curBlock;
    public HashMap<operand,VirtualReg> RegsMap = new HashMap<>();
    public VirtualReg ret_addr = null;
    public ASMBuilder(IRModule x) {
        thisIRModule = x;
        thisASMModule = new ASMModule();
    }
    public boolean check(int tmp) {
        if(tmp>=(1<<11)&&tmp<=(-(1<<11))+1) return false;
        return true;
    }
    public VirtualReg getVirtualReg(operand tmp) {
        if(tmp instanceof IntConst) {
            if(((IntConst) tmp).val==0) {
                return PhysicalReg.getv("zero");
            }
            if(!check(((IntConst) tmp).val)) {
                VirtualReg reg = new VirtualReg("const.int");
                curBlock.addBack(new ASMBinaryInst(reg,PhysicalReg.getv("zero"),null,new IntImm(((IntConst) tmp).val),ASMBinaryInst.Op.addi,curBlock));
                return reg;
            }
            else {
                VirtualReg reg = new VirtualReg("const.int");
                curBlock.addBack(new ASMLiInst(reg,new IntImm(((IntConst) tmp).val),curBlock));
                return reg;
            }
        }
        else if(tmp instanceof BoolConst) {
            if(((BoolConst) tmp).val) {
                return PhysicalReg.getv("zero");
            }
            else {
                VirtualReg reg = new VirtualReg("const.bool");

                curBlock.addBack(new ASMBinaryInst(reg,PhysicalReg.getv("zero"),null,new IntImm(1),ASMBinaryInst.Op.addi,curBlock));
                return reg;
            }
        }
        else if(tmp instanceof NullConst) {
            return PhysicalReg.getv("zero");
        }
        else if(tmp instanceof GlobalReg) {
            assert false;
            return null;
        }
        else {
            assert tmp instanceof LocalReg;
            if(RegsMap.containsKey(tmp)) return RegsMap.get(tmp);
            else {
                VirtualReg nw = new VirtualReg(((LocalReg) tmp).id+RegsMap.size());
                RegsMap.put(tmp,nw);
                return nw;
            }
        }
    }
    public ASMOperand getASMOperand(operand tmp) {
        if(tmp instanceof IntConst) {
            if(check(((IntConst) tmp).val))
            return new IntImm(((IntConst) tmp).val);
            else return getVirtualReg(tmp);
        }
        else if(tmp instanceof BoolConst) {
            if(((BoolConst) tmp).val) return new IntImm(1);
            else return new IntImm(0);
        }
        else if(tmp instanceof NullConst) {
            return PhysicalReg.getv("zero");
        }
        else if(tmp instanceof GlobalReg) {
            assert false;
            return null;
        }
        else {
            assert tmp instanceof LocalReg;
            return getVirtualReg(tmp);
        }
    }
    @Override
    public void visit(BasicBlock tmp){
        curBlock = curFunc.BlockMap.get(tmp);
        Inst ptr = tmp.begin_Inst;
        while(ptr!=null) {
            ptr.accept(this);
            ptr = ptr.Nxt;
        }
    }
    @Override
    public void visit(IRModule tmp){
        //Add Global Var
        for(GlobalReg reg : tmp.GlobalRegs.values()) {
            String name = reg.id;
            BaseType tp= ((PointerType)reg.tp).tp;
            if(tp instanceof IntType) {
                thisASMModule.GlobalVars.put(name,new ASMGlobalVar(name));
                if(reg.val instanceof IntConst) {
                    thisASMModule.GlobalVars.get(name).Val2 = ((IntConst) reg.val).val;
                    thisASMModule.GlobalVars.get(name).tp = ASMGlobalVar.Type._int;
                }
                else if(reg.val instanceof BoolConst) {
                    thisASMModule.GlobalVars.get(name).Val2 = ((BoolConst) reg.val).val?1:0;
                    thisASMModule.GlobalVars.get(name).tp = ASMGlobalVar.Type._bool;
                }
                else assert false;
            }
            else if(tp instanceof IRArrayType) {
                thisASMModule.GlobalVars.put(name,new ASMGlobalVar(name));
                thisASMModule.GlobalVars.get(name).Val1 = ((StringConst)reg.val).val;
                thisASMModule.GlobalVars.get(name).tp = ASMGlobalVar.Type._string;
            }
            else if(tp instanceof PointerType) {
                thisASMModule.GlobalVars.put(name,new ASMGlobalVar(name));
                thisASMModule.GlobalVars.get(name).Val2 = 0;
                thisASMModule.GlobalVars.get(name).tp = ASMGlobalVar.Type._int;
            }
            else assert false;
        }
        for(IRFunction irfunc:tmp.Funcs.values()){
            ASMFunction nw = new ASMFunction(thisASMModule,irfunc);
            thisASMModule.Funcs.put(nw.Identifier,nw);
        }
        for(IRFunction sysfunc:tmp.Sys_Funcs.values()) {
            ASMFunction nw = new ASMFunction(thisASMModule,sysfunc);
            thisASMModule.Sys_Funcs.put(nw.Identifier,nw);
        }
        for(IRFunction sysfunc:tmp.Funcs.values()) {
            sysfunc.accept(this);
        }
    }
    @Override
    public void visit(IRFunction tmp){
//        System.out.println(tmp.id);
        curFunc = thisASMModule.Funcs.get(tmp.id);
        curBlock = curFunc.entry;
        curFunc.stk = new StackFrame(curFunc);
        ret_addr = new VirtualReg("_ra");
        curBlock.addBack(new ASMMvInst(ret_addr,PhysicalReg.getv("ra"),curBlock));
        for(int i=0;i<Integer.min(8,tmp.paras_list.size());++i) {
            VirtualReg thispara = getVirtualReg(tmp.paras_list.get(i));
            curBlock.addBack(new ASMMvInst(thispara,PhysicalReg.getv("a"+i),curBlock));
        }
        for(int i=8;i<tmp.paras_list.size();++i) {
            VirtualReg thispara = getVirtualReg(tmp.paras_list.get(i));
            ASMAddress thispara$addr = new ASMAddress(PhysicalReg.getv("sp"),new IntImm(0));
            curFunc.stk.ParameterAddr.add(thispara$addr);
            curBlock.addBack(new ASMLoadInst(thispara,thispara$addr, ASMLoadInst.Op.lw,curBlock));
        }
        BasicBlock ptr = tmp.entry;
        while(ptr!=null) {
            ptr.accept(this);
            ptr = ptr.nxt_block;
        }
    }
    @Override
    public void visit(AllocaInst tmp){
        ArrayList<operand> paras = new ArrayList<>();
        paras.add(new IntConst(tmp.tp.size(),new IntType(32)));
        CallFuncInst mallocInst = new CallFuncInst(thisIRModule.Sys_Funcs.get("mx_malloc"),tmp.res,paras,null);
        mallocInst.accept(this);
    }
    @Override
    public void visit(BitCastInst tmp){
        VirtualReg rd = getVirtualReg(tmp.res);
        VirtualReg rs = getVirtualReg(tmp.obj);
        curBlock.addBack(new ASMMvInst(rd,rs,curBlock));
    }
    @Override
    public void visit(BranchInst tmp){
        if(tmp.b2==null) {
            assert tmp.cond ==null;
            curBlock.addBack(new ASMJInst(curFunc.BlockMap.get(tmp.b1),curBlock));
        }
        else{
            assert tmp.cond!=null;
            curBlock.addBack(new ASMBranchInst(getVirtualReg(tmp.cond),null,curFunc.BlockMap.get(tmp.b1), ASMBranchInst.Op.bnez,curBlock));
            curBlock.addBack(new ASMJInst(curFunc.BlockMap.get(tmp.b2),curBlock));
        }
    }
    @Override
    public void visit(CallFuncInst tmp){

        ASMFunction thisFunc;
        if(thisASMModule.Sys_Funcs.containsKey(tmp.func.id)) {
            thisFunc = thisASMModule.Sys_Funcs.get(tmp.func.id);
        }
        else {
            assert thisASMModule.Funcs.containsKey(tmp.func.id);
            thisFunc = thisASMModule.Funcs.get(tmp.func.id);
        }
        for(int i=0;i<Integer.min(8,tmp.paras_list.size());++i) {
            curBlock.addBack(new ASMMvInst(PhysicalReg.getv("a"+i),getVirtualReg(tmp.paras_list.get(i)),curBlock));
        }
        StackFrame stk = curFunc.stk;
        if(!stk.CalleeAddr.containsKey(thisFunc)) {
            ArrayList<ASMAddress> para_list = new ArrayList<>();
            for (int i = 8; i < tmp.paras_list.size(); ++i) {
                para_list.add(new ASMAddress(PhysicalReg.getv("sp"),new IntImm(0)));
            }
            stk.CalleeAddr.put(thisFunc,para_list);
        }
        for (int i = 8; i < tmp.paras_list.size(); ++i) {
            curBlock.addBack(new ASMStoreInst(getVirtualReg(tmp.paras_list.get(i)),stk.CalleeAddr.get(thisFunc).get(i-8), ASMStoreInst.Op.sw,curBlock));
        }
        curBlock.addBack(new ASMCallInst(thisFunc,curBlock));
        if(!(tmp.func.functp.ret_tp instanceof VoidType)&&!(tmp.func.functp.ret_tp instanceof NullType)){
            curBlock.addBack(new ASMMvInst(getVirtualReg(tmp.res),PhysicalReg.getv("a0"),curBlock));
        }
    }
    @Override
    public void visit(CmpInst tmp){
        VirtualReg rd = getVirtualReg(tmp.ans);
        VirtualReg rs1 = getVirtualReg(tmp.lhs);
        VirtualReg rs2 = getVirtualReg(tmp.rhs);
        VirtualReg temp = new VirtualReg("TemporaryForCmp");
        switch (tmp.op)
        {
            case sle -> {

                curBlock.addBack(new ASMBinaryInst(temp,rs2,rs1,null, ASMBinaryInst.Op.slt,curBlock));
                curBlock.addBack(new ASMBinaryInst(rd,temp,null,new IntImm(1) ,ASMBinaryInst.Op.xori,curBlock));
            }
            case slt -> {

                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.slt,curBlock));
//                curBlock.addBack(new ASMBinaryInst(rd,temp,null,new IntImm(1) ,ASMBinaryInst.Op.xori,curBlock));
            }
            case sgt -> {
//                System.out.println("fuck");
                curBlock.addBack(new ASMBinaryInst(rd,rs2,rs1,null, ASMBinaryInst.Op.slt,curBlock));
//                curBlock.addBack(new ASMBinaryInst(rd,temp,null,new IntImm(1) ,ASMBinaryInst.Op.xori,curBlock));
            }
            case sge -> {
                curBlock.addBack(new ASMBinaryInst(temp,rs1,rs2,null, ASMBinaryInst.Op.slt,curBlock));
                curBlock.addBack(new ASMBinaryInst(rd,temp,null,new IntImm(1) ,ASMBinaryInst.Op.xori,curBlock));
            }
            case ne -> {
                curBlock.addBack(new ASMBinaryInst(temp,rs1,rs2,null, ASMBinaryInst.Op.sub,curBlock));
                curBlock.addBack(new ASMUnaryInst(rd,temp, ASMUnaryInst.Op.snez,curBlock));
            }
            case eq -> {
                curBlock.addBack(new ASMBinaryInst(temp,rs1,rs2,null, ASMBinaryInst.Op.sub,curBlock));
                curBlock.addBack(new ASMUnaryInst(rd,temp, ASMUnaryInst.Op.seqz,curBlock));
            }
            default -> {
                assert false;
            }
        }
    }
    @Override
    public void visit(GetElementPtrInst tmp){
        VirtualReg ans = getVirtualReg(tmp.res);
        if(tmp.addr instanceof GlobalReg) {
            curBlock.addBack(new ASMLaInst(ans,thisASMModule.GlobalVars.get(((GlobalReg) tmp.addr).id),curBlock));
            return ;
        }
        VirtualReg ptr = getVirtualReg(tmp.addr);
        if(tmp.index.size()>1){
            //class
            int index0 = ((IntConst)tmp.index.get(0)).val;
            int index1 = ((IntConst)tmp.index.get(1)).val;
            if(index0!=0) {
                assert false;
            }
            BaseType thisClass = ((PointerType)tmp.addr.tp).tp;
            if(thisClass instanceof IRClassType) {
                thisClass = thisIRModule.ClassMap.get(((IRClassType) thisClass).id);
//                System.out.println(((IRClassType) thisClass).id);
//                System.out.println(((IRClassType) thisClass).member_list.size());
                int offset=0 ;
                for(int i=0;i<index1;++i) {
//                    System.out.println("Size: "+((IRClassType) thisClass).member_list.size());
//                    System.out.println(i);
                    offset += ((IRClassType) thisClass).member_list.get(i).size();
                }
                curBlock.addBack(new ASMBinaryInst(ans,ptr,null,new IntImm(offset), ASMBinaryInst.Op.addi,curBlock));
            }
            else {
                assert false;
            }
        }
        else {
            VirtualReg temp = getVirtualReg(tmp.index.get(0));
            VirtualReg Mid = new VirtualReg("temporary");
            curBlock.addBack(new ASMBinaryInst(Mid,temp,null,new IntImm(2), ASMBinaryInst.Op.slli,curBlock));
            curBlock.addBack(new ASMBinaryInst(ans,ptr,Mid,null, ASMBinaryInst.Op.add,curBlock));
        }
    }
    @Override
    public void visit(LoadInst tmp){
        if(tmp.addr instanceof GlobalReg)
        {
            VirtualReg rd = getVirtualReg(tmp.res);
            ASMGlobalVar thisVar = thisASMModule.GlobalVars.get(((GlobalReg) tmp.addr).id);
            VirtualReg temp = new VirtualReg("temporaryForLoad");
            curBlock.addBack(new ASMLaInst(temp,thisVar,curBlock));
            if ((tmp.tp instanceof IntType) && ((IntType) tmp.tp).size <= 8) {
                curBlock.addBack(new ASMLoadInst(rd,new ASMAddress(temp,new IntImm(0)), ASMLoadInst.Op.lb, curBlock));
            } else {
                curBlock.addBack(new ASMLoadInst(rd,new ASMAddress(temp,new IntImm(0)), ASMLoadInst.Op.lw, curBlock));
            }
        }
        else {
            VirtualReg rd = getVirtualReg(tmp.res);
            VirtualReg addr_base = getVirtualReg(tmp.addr);
            ASMAddress addr = new ASMAddress(addr_base, new IntImm(0));
            if ((tmp.tp instanceof IntType) && ((IntType) tmp.tp).size <= 8) {
                curBlock.addBack(new ASMLoadInst(rd, addr, ASMLoadInst.Op.lb, curBlock));
            } else {
                curBlock.addBack(new ASMLoadInst(rd, addr, ASMLoadInst.Op.lw, curBlock));
            }
        }
    }
    @Override
    public void visit(MoveInst tmp){
        VirtualReg res = getVirtualReg(tmp.res);
        ASMOperand Val = getASMOperand(tmp.tmp);
        if(Val instanceof IntImm){
            curBlock.addBack(new ASMBinaryInst(res,PhysicalReg.getv("zero"),null,(IntImm) Val, ASMBinaryInst.Op.addi,curBlock));
        }
        else {
            curBlock.addBack(new ASMMvInst(res,(VirtualReg) Val,curBlock));
            assert !(Val instanceof VirtualReg);
        }
    }
    @Override
    public void visit(PhiInst tmp){
        assert false;
    }
    @Override
    public void visit(RetInst tmp){
        //return val
        if(tmp.val!=null&&!(tmp.tp instanceof NullType)&&!(tmp.tp instanceof VoidType)) {
            curBlock.addBack(new ASMMvInst(PhysicalReg.getv("a0"),getVirtualReg(tmp.val),curBlock));
        }
        //return
        curBlock.addBack(new ASMMvInst(PhysicalReg.getv("ra"),ret_addr,curBlock));
        curBlock.addBack(new ASMRetInst(curBlock));
    }
    @Override
    public void visit(StoreInst tmp){
        if(tmp.addr instanceof GlobalReg) {
            VirtualReg Val = getVirtualReg(tmp.val);
            ASMGlobalVar thisVar = thisASMModule.GlobalVars.get(((GlobalReg) tmp.addr).id);
            VirtualReg temp = new VirtualReg("temporaryForStore");
            curBlock.addBack(new ASMLaInst(temp,thisVar,curBlock));
            if ((tmp.val.tp instanceof IntType) && ((IntType) tmp.val.tp).size <= 8) {
                curBlock.addBack(new ASMStoreInst(Val,new ASMAddress(temp,new IntImm(0)), ASMStoreInst.Op.sb, curBlock));
            } else {
                curBlock.addBack(new ASMStoreInst(Val,new ASMAddress(temp,new IntImm(0)), ASMStoreInst.Op.sw, curBlock));
            }
        }
        else{
            VirtualReg Val = getVirtualReg(tmp.val);
            VirtualReg addr_base = getVirtualReg(tmp.addr);
            ASMAddress addr = new ASMAddress(addr_base, new IntImm(0));
            if ((tmp.val.tp instanceof IntType) && ((IntType) tmp.val.tp).size <= 8) {
                curBlock.addBack(new ASMStoreInst(Val, addr, ASMStoreInst.Op.sb, curBlock));
            } else {
                curBlock.addBack(new ASMStoreInst(Val, addr, ASMStoreInst.Op.sw, curBlock));
            }
        }
    }
    @Override
    public void visit(BinaryInst tmp){
        VirtualReg rs1 = getVirtualReg(tmp.lhs);
        VirtualReg rs2 = getVirtualReg(tmp.rhs);
        VirtualReg rd = getVirtualReg(tmp.res);
        switch (tmp.op){
            case add->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.add,curBlock));
            }
            case sub->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.sub,curBlock));
            }
            case mul->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.mul,curBlock));
            }
            case sdiv->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.div,curBlock));
            }
            case srem->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.rem,curBlock));
            }
            case ashr->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.sra,curBlock));
            }
            case shl->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.sll,curBlock));
            }
            case and->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.and,curBlock));
            }
            case xor->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.xor,curBlock));
            }
            case or->{
                curBlock.addBack(new ASMBinaryInst(rd,rs1,rs2,null, ASMBinaryInst.Op.or,curBlock));
            }
        }
    }
}
