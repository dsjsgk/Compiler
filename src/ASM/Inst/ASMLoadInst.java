package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.ASMAddress;
import ASM.Operand.VirtualReg;

public class ASMLoadInst extends ASMInst {
    public enum Op{
        lw, lb
    }
    public VirtualReg rd;
    public ASMAddress addr;
    public Op tp;
    public ASMLoadInst(VirtualReg rd, ASMAddress addr, Op tp, ASMBasicBlock bel){
        super(bel);
        this.rd = rd;
        this.addr = addr;
        this.tp = tp;
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rd.toString()+", "+addr.toString();
    }
}
