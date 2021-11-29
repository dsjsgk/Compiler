package MIR;

public class BoolConst extends Const{
    public boolean val;
    public BoolConst(boolean val,BaseType tp) {super(tp);this.val=val;}
    @Override public String toString() {return Boolean.toString(val);}
}
