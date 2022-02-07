package ASM;

import MIR.Inst;
import MIR.PhiInst;

import java.util.ArrayList;

public class ASMBasicBlock extends ASMBase{
    public String Identifier;
    public ASMFunction thisFunc;
    public ASMBasicBlock pre_Block,nxt_Block;
    public ASMInst Inst_begin,Inst_end;
    public ArrayList<ASMBasicBlock> succ = new ArrayList<>(),prec = new ArrayList<>();
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
    public void addBefore(ASMInst oldInst,ASMInst nwInst) {
        if(oldInst== Inst_begin) {
            Inst_begin = nwInst;
        }
        nwInst.Nxt = oldInst;
        nwInst.Pre = oldInst.Pre;
        if(oldInst.Pre!=null) {
            oldInst.Pre.Nxt = nwInst;
        }
        oldInst.Pre = nwInst;
    }
    public void addAfter(ASMInst oldInst,ASMInst nwInst) {
        if(oldInst== Inst_end) {
            Inst_end = nwInst;
        }
        nwInst.Nxt = oldInst.Nxt;
        nwInst.Pre = oldInst;
        if(oldInst.Nxt!=null) {
            oldInst.Nxt.Pre = nwInst;
        }
        oldInst.Nxt = nwInst;
    }
    public void remove(ASMInst tmp) {
        if(tmp==Inst_begin&&tmp==Inst_end) {
            Inst_begin = null;
            Inst_end = null;
            return ;
        }
        if(tmp==Inst_begin) {
            Inst_begin = tmp.Nxt;
            tmp.Nxt.Pre = null;
            return ;
        }
        if(tmp==Inst_end) {
            Inst_end = tmp.Pre;
            tmp.Pre.Nxt = null;
            return ;
        }
        tmp.Pre.Nxt = tmp.Nxt;
        tmp.Nxt.Pre = tmp.Pre;
        return ;
    }
    @Override
    public String toString(){
        return Identifier;
    }
}
