package MIR;

public class NullType extends BaseType{
//    int size;
    public NullType() {}
    @Override public String toString() {return "void";}
    @Override public int size(){return 0;}
    @Override
    public operand defaultval() {
        return null;
    }

}
