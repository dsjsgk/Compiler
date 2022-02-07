package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.VirtualReg;

public class ASMJInst extends ASMInst {
    public ASMBasicBlock goal;
    public ASMJInst(ASMBasicBlock goal,ASMBasicBlock bel) {
        super(bel);
        this.goal = goal;
//        goal.prec.add(bel);
//        bel.succ.add(bel);
    }
    @Override
    public String toString(){
        return "j\t"+goal.toString();
    }
    @Override
    public void replaceRd(VirtualReg a, VirtualReg b) {
//        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
//        if(rs1 == a) rs1 = b;if(rs2 == a) rs2 = b;
    }
}
