package ASM;

import ASM.ASMBase;
import ASM.ASMBasicBlock;
import ASM.Operand.VirtualReg;

import java.util.ArrayList;

public abstract class ASMInst extends ASMBase {
    public ASMBasicBlock bel;
    public ASMInst Nxt,Pre;
    public ArrayList<VirtualReg> _rs = new ArrayList<>(),_rd = new ArrayList<>();
    public ASMInst(ASMBasicBlock bel){
        this.bel = bel;
    }
    abstract public void replaceRd(VirtualReg a,VirtualReg b);
    abstract public void replaceRs(VirtualReg a,VirtualReg b);
    public void Replace_RS(VirtualReg a,VirtualReg b) {
        while(_rs.contains(a)) {_rs.remove(a);_rs.add(b);}
    }
    public void Replace_RD(VirtualReg a,VirtualReg b) {
        while(_rd.contains(a)) {_rd.remove(a);_rd.add(b);}
    }
}
