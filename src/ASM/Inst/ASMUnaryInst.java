package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.VirtualReg;

public class ASMUnaryInst extends ASMInst {
    public enum Op{seqz,snez,altz,sgtz}
    //=0 !=0 <0 >0
    public VirtualReg rd;
    public VirtualReg rs;
    public Op tp;
    public ASMUnaryInst(VirtualReg rd, VirtualReg rs, Op tp, ASMBasicBlock block) {
        super(block);
        this.rd = rd;this.rs = rs;this.tp = tp;
        if(rs!=null) _rs.add(rs);
//        if(rs2!=null) _rs.add(rs2);
        if(rd!=null) _rd.add(rd);
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rd.toString()+", "+rs.toString();
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
        if(rs == a) rs = b;
    }
}
