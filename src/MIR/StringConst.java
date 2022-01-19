package MIR;

public class StringConst extends Const{
    public String val;
    public StringConst(String val,BaseType tp) {super(tp);this.val=val;}
    @Override public String toString() {return "c\"" + val.replace("\\", "\\5C").replace("\n", "\\0A").replace("\"", "\\22").replace("\0", "\\00") + "\"";}
}
