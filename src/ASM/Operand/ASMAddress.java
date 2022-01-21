package ASM.Operand;

public class ASMAddress extends ASMOperand{
    public IntImm offset;
    public VirtualReg Base;
    public ASMAddress(VirtualReg Base,IntImm offset) {
        this.offset = offset;
        this.Base = Base;
    }
    @Override
    public String toString() {
        return offset.toString()+"("+Base.toString()+")";
    }
}
