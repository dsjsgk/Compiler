package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.VirtualReg;

public class ASMBranchInst extends ASMInst {
    public enum Op{
        beq, bne, blt, bge, ble, bgt,
        beqz, bnez, bltz, bgez, blez, bgtz
    }
    public VirtualReg rs1;
    public VirtualReg rs2;
    public ASMBasicBlock goal;
    public Op tp;
    public ASMBranchInst(VirtualReg rs1,VirtualReg rs2,ASMBasicBlock goal,Op tp,ASMBasicBlock bel) {
        super(bel);
        this.rs1 = rs1;this.rs2 = rs2;
        this.goal = goal;
        this.tp = tp;
        if(rs1!=null) _rs.add(rs1);
        if(rs2!=null) _rs.add(rs2);
//        if(rd!=null) _rd.add(rd);
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rs1.toString()+", "+((rs2!=null)?rs2.toString()+", ":"")+goal.toString();
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
//        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
        if(rs1 == a) rs1 = b;if(rs2 == a) rs2 = b;
    }
}
