package ASM.Inst;

import ASM.ASMBase;
import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.VirtualReg;

public class ASMRetInst extends ASMInst {
    public ASMRetInst(ASMBasicBlock bel) {
        super(bel);
    }
    @Override
    public String toString () {
        return "ret";
    }
    public void replaceRd(VirtualReg a, VirtualReg b) {
//        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
//        if(rs == a) rs = b;if(addr.Base == a) addr.Base = b;
    }
}
