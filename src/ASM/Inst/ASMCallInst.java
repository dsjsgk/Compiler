package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMFunction;
import ASM.ASMInst;

public class ASMCallInst extends ASMInst {
    public ASMFunction thisFunc;
    public ASMCallInst(ASMFunction thisFunc, ASMBasicBlock bel) {
        super(bel);
        this.thisFunc = thisFunc;
    }
    @Override
    public String toString() {
        return "call\t"+thisFunc.toString();
    }
}
