package ASM.Operand;

public class ASMAddress extends ASMOperand{
    IntImm offset;
    VirtualReg Base;
    public ASMAddress(VirtualReg Base,IntImm offset) {
        this.offset = offset;
        this.Base = Base;
    }
    @Override
    public String toString() {
        return offset.toString()+"("+Base.toString()+")";
    }
}
