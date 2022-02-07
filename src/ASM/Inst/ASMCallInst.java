package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMFunction;
import ASM.ASMInst;
import ASM.Operand.PhysicalReg;
import ASM.Operand.VirtualReg;

public class ASMCallInst extends ASMInst {
    public ASMFunction thisFunc;
    public ASMCallInst(ASMFunction thisFunc, ASMBasicBlock bel) {
        super(bel);
        this.thisFunc = thisFunc;
        for(int i=0;i<32;++i) {
            if(PhysicalReg.Type.get(i).equals(PhysicalReg.type.caller)) {
                _rd.add(PhysicalReg.getv(PhysicalReg.Name.get(i)));
            }
        }
    }
    @Override
    public String toString() {
        return "call\t"+thisFunc.toString();
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
