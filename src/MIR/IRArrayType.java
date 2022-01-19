package MIR;

public class IRArrayType extends BaseType {
    private BaseType tp;
    private int sz;
    public IRArrayType(int size,BaseType tp){
        this.tp = tp;
        this.sz = size;
    }
    @Override public String toString() {
        return "[" + this.sz + " x "+tp.toString()+"]";
    }
    @Override public int size() {
        return sz;
    }
    @Override public operand defaultval() {
        return null;
    }
}