package ASM;

import ASM.ASMBase;
import ASM.ASMBasicBlock;
public abstract class ASMInst extends ASMBase {
    public ASMBasicBlock bel;
    public ASMInst Nxt,Pre;
    public ASMInst(ASMBasicBlock bel){
        this.bel = bel;
    }
}
