package MIR;

public class StringType extends BaseType{
    int size;
    public StringType(int size) {this.size = size;}
    @Override public String toString() {return "i8*";}
    @Override public int size(){return size;}
    @Override public operand defaultval() {
        return null;
    }
}
