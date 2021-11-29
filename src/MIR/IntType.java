package MIR;

public class IntType extends BaseType{
    public int size;
    public IntType(int size) {this.size=size;}
    @Override public String toString(){return "i32";}
    @Override public int size(){return 4;}
}
