package MIR;

public class PointerType extends BaseType{
    public BaseType tp;
    public PointerType(BaseType tp) {this.tp=tp;}
    @Override public String toString() {
        return this.tp.toString() + "*";
    }
    @Override public int size() {
//        return 4;
        return 8;
    }
    @Override public operand defaultval(){
        return new NullConst(new NullType());
    }
}
