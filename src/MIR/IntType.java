package MIR;

public class IntType extends BaseType{
    public int size;
    public IntType(int size) {this.size=size;}
    @Override public String toString(){if(size==4)return "i32";else return "i1";}
    @Override public int size(){return (size+7)/8;}
    @Override public operand defaultval(){
        if(size>1) return new IntConst(0,new IntType(32));
        else return new BoolConst(false,new IntType(1));
    }
}