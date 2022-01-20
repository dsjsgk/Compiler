package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;

public class ASMJInst extends ASMInst {
    public ASMBasicBlock goal;
    public ASMJInst(ASMBasicBlock goal,ASMBasicBlock bel) {
        super(bel);
        this.goal = goal;
    }
    @Override
    public String toString(){
        return "j\t"+goal.toString();
    }
}
