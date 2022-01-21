package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.ASMAddress;
import ASM.Operand.VirtualReg;

public class ASMLoadInst extends ASMInst {
    public enum Op{
        lw, lb
    }
    public VirtualReg rd;
    public ASMAddress addr;
    public Op tp;
    public ASMLoadInst(VirtualReg rd, ASMAddress addr, Op tp, ASMBasicBlock bel){
        super(bel);
        this.rd = rd;
        this.addr = addr;
        this.tp = tp;
//        if(rs1!=null) _rs.add(rs1);
//        if(rs2!=null) _rs.add(rs2);
        if(addr.Base!=null) _rs.add(addr.Base);
        if(rd!=null) _rd.add(rd);
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rd.toString()+", "+addr.toString();
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
        if(addr.Base == a) addr.Base = b;//if(rs2 == a) rs2 = b;
    }
}
