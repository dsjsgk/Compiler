package ASM;

import MIR.PhiInst;

public class ASMBasicBlock extends ASMBase{
    public String Identifier;
    public ASMFunction thisFunc;
    public ASMBasicBlock pre_Block,nxt_Block;
    public ASMInst Inst_begin,Inst_end;
    public ASMBasicBlock(String Identifier,ASMFunction thisFunc) {
        this.Identifier = Identifier;
        this.thisFunc = thisFunc;
    }
    public void addBack(ASMInst nwInst) {
        if(Inst_begin==null) {
            Inst_begin = nwInst;
            Inst_end = nwInst;
        }
        else {
            Inst_end.Nxt = nwInst;
            nwInst.Pre = Inst_end;
            Inst_end = nwInst;
        }
    }
    public void addFront(ASMInst nwInst) {
        if(Inst_begin==null) {
            Inst_begin = nwInst;
            Inst_end = nwInst;
        }
        else {
            Inst_begin.Pre = nwInst;
            nwInst.Nxt = Inst_begin;
            Inst_begin = nwInst;
        }
    }
    @Override
    public String toString(){
        return Identifier;
    }
}
