package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.IntImm;
import ASM.Operand.VirtualReg;

public class ASMBinaryInst extends ASMInst {
    public enum Op{
        add, sub, mul, div, rem, sll, sra, and, or, xor, slt, addi, slli, srai, andi, ori, xori, slti
    }
    public VirtualReg rd,rs1,rs2;
    public IntImm imm;
    public Op tp;
    public ASMBinaryInst(VirtualReg rd, VirtualReg rs1, VirtualReg rs2, IntImm imm, Op tp, ASMBasicBlock block){
        super(block);
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
        this.tp = tp;
    }
    @Override
    public String toString(){
        if(rs2==null&&imm!=null) {
            return tp.name()+"\t"+rd.toString()+", "+rs1.toString()+", "+imm.toString();
        }
        else {
            assert rs2!=null;
            return tp.name()+"\t"+rd.toString()+", "+rs1.toString()+", "+rs2.toString();
        }
    }
}
