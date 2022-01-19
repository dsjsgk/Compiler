package MIR;

public class VoidType extends BaseType{
    //    int size;
    public VoidType() {}
    @Override public String toString() {return "void";}
    @Override public int size(){return 0;}
    @Override
    public operand defaultval() {
        return null;
    }
}
