package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.IntImm;
import ASM.Operand.VirtualReg;

public class ASMLiInst extends ASMInst {
    public VirtualReg rd;
    public IntImm imm;
    public ASMLiInst(VirtualReg rd, IntImm imm, ASMBasicBlock bel) {
        super(bel);
        this.rd = rd;
        this.imm = imm;
    }
    @Override
    public String toString(){
        return "li\t"+rd.toString()+", "+imm.toString();
    }
}
