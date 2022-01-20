package ASM.Operand;

public class IntImm extends ASMOperand{
    int Val;
    public IntImm(int Val) {
        this.Val = Val;
    }
    @Override
    public String toString(){
        return Integer.toString(Val);
    }
}
