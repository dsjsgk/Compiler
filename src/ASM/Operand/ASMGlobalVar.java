package ASM.Operand;

public class ASMGlobalVar extends ASMOperand{
    public enum Type{
        _string, _int, _bool, _void
    }
    public String Identifier;
    public String Val1;
    public int Val2;
    public Type tp;
    public ASMGlobalVar(String Identifier){
        this.Identifier = Identifier;
    }
    @Override
    public String toString(){
        if(tp==Type._string) {
            return ".asciz\t\"" + Val1.replace("\\", "\\\\")
                    .replace("\n", "\\n")
                    .replace("\"", "\\\"") + "\"";
        }
        else if(tp==Type._int) {
            return ".word\t"+Integer.toUnsignedLong(Val2)
                    + " ".repeat(24 - Integer.toUnsignedString(Val2).length()) + "# " + Val2;
        }
        else {
            assert tp== Type._bool;
            return ".byte\t" + Val2 + " ".repeat(23) + "# " + (Val2 == 1);
        }
    }
}
