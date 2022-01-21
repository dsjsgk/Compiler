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
//        if(rs1!=null) _rs.add(rs1);
//        if(rs2!=null) _rs.add(rs2);
        if(rd!=null) _rd.add(rd);
    }
    @Override
    public String toString (){
        return "la\t"+rd.toString()+", "+Val.Identifier;
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
//        if(rs1 == a) rs1 = b;if(rs2 == a) rs2 = b;
    }
}
