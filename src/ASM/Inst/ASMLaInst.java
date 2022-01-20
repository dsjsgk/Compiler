package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.ASMGlobalVar;
import ASM.Operand.VirtualReg;

public class ASMLaInst extends ASMInst {
    public VirtualReg rd;
    public ASMGlobalVar Val;
    public ASMLaInst(VirtualReg rd, ASMGlobalVar Val, ASMBasicBlock bel) {
        super(bel);
        this.rd = rd;
        this.Val = Val;
    }
    @Override
    public String toString (){
        return "la\t"+rd.toString()+", "+Val.toString();
    }
}
