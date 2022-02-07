package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.VirtualReg;

public class ASMMvInst extends ASMInst {
    public VirtualReg rd,rs;
    public ASMMvInst(VirtualReg rd, VirtualReg rs, ASMBasicBlock bel) {
        super(bel);
        this.rd = rd;
        this.rs = rs;
        if(rs!=null) _rs.add(rs);
//        if(rs2!=null) _rs.add(rs2);
        if(rd!=null) _rd.add(rd);
    }
    @Override
    public String toString (){
        return  "mv\t"+rd.toString()+", "+rs.toString();
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
        if(rs == a) rs = b;//if(rs2 == a) rs2 = b;
    }
}
