package ASM.Inst;

import ASM.ASMBasicBlock;
import ASM.ASMInst;
import ASM.Operand.ASMAddress;
import ASM.Operand.VirtualReg;

public class ASMStoreInst extends ASMInst {
    public enum Op{
        sw, sb
    }
    public VirtualReg rs;
    public ASMAddress addr;
    public Op tp;
    public ASMStoreInst(VirtualReg rs, ASMAddress addr, ASMStoreInst.Op tp, ASMBasicBlock bel){
        super(bel);
        this.rs = rs;
        this.addr = addr;
        this.tp = tp;
        if(rs!=null) _rs.add(rs);
//        if(rs2!=null) _rs.add(rs2);
        if(rs!=null) _rs.add(addr.Base);
    }
    @Override
    public String toString(){
        return tp.name()+"\t"+rs.toString()+", "+addr.toString();
    }
    @Override
    public void replaceRd(VirtualReg a,VirtualReg b) {
//        if(rd == a) rd = b;
    }
    @Override
    public void replaceRs(VirtualReg a,VirtualReg b) {
        if(rs == a) rs = b;if(addr.Base == a) addr.Base = b;
    }
}
