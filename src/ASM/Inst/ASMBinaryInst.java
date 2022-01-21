package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.IntImm;
import ASM.Operand.VirtualReg;

public class ASMBinaryInst extends ASMInst {
    public enum Op{
        add, sub, mul, div, rem, sll, sra, and, or, xor, slt, addi, slli, srai, andi, ori, xori, slti
    }
    private VirtualReg rd,rs1,rs2;

    public IntImm imm;
    public Op tp;
    public ASMBinaryInst(VirtualReg rd, VirtualReg rs1, VirtualReg rs2, IntImm imm, Op tp, ASMBasicBlock block){
        super(block);
        this.rd = rd;
//        if(rd==null) {
//            assert false;
//        }
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
        this.tp = tp;
        if(rs1!=null) _rs.add(rs1);
        if(rs2!=null) _rs.add(rs2);
        if(rd!=null) _rd.add(rd);

    }
    @Override
    public String toString(){
//        System.out.println(tp.name());
//        System.out.println(rd.toString());
//        System.out.println(rs1.toString());
        if(rs2==null&&imm!=null) {
            return tp.name()+"\t"+rd.toString()+", "+rs1.toString()+", "+imm.toString();
        }
        else {
            assert rs2!=null;
            return tp.name()+"\t"+rd.toString()+", "+rs1.toString()+", "+rs2.toString();
        }
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
//        if(b==null) {assert false;}
//        assert  b!=null;
//        System.out.println(b.toString());
        if(rd == a) rd = b;
//        System.out.println(b.toString());
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
        if(rs1 == a) rs1 = b;if(rs2 == a) rs2 = b;
    }
}
