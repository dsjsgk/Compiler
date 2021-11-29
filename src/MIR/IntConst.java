package MIR;

public class IntConst extends Const{
    public int val;
    public IntConst(int val,BaseType tp) {super(tp);this.val=val;}
    @Override public String toString() {return Integer.toString(val);}
}
