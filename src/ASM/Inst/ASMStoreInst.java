package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.ASMAddress;
import ASM.Operand.VirtualReg;

public class ASMStoreInst extends ASMInst {
    public enum Op{
        sw, sb
    }
    public VirtualReg rs;
    public ASMAddress addr;
    public Op tp;
    public ASMStoreInst(VirtualReg rs, ASMAddress addr, ASMStoreInst.Op tp, ASMBasicBlock bel){
        super(bel);
        this.rs = rs;
        this.addr = addr;
        this.tp = tp;
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rs.toString()+", "+addr.toString();
    }
}
