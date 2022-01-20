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
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rs1.toString()+", "+((rs2!=null)?rs2.toString()+", ":"")+goal.toString();
    }
}
