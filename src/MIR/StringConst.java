package MIR;

public class StringConst extends Const{
    public String val;
    public StringConst(String val,BaseType tp) {super(tp);this.val=val;}
    @Override public String toString() {return val;}
}
