package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.VirtualReg;

public class ASMMvInst extends ASMInst {
    VirtualReg rd,rs;
    public ASMMvInst(VirtualReg rd, VirtualReg rs, ASMBasicBlock bel) {
        super(bel);
        this.rd = rd;
        this.rs = rs;
    }
    @Override
    public String toString (){
        return  "mv\t"+rd.toString()+", "+rs.toString();
    }
}
