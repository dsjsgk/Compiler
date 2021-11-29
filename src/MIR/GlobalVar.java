package MIR;

public class GlobalVar extends operand{
    public String id;
    public GlobalVar(String id,BaseType tp) {
        super(tp);
        this.id=id;
    }
    @Override public String toString(){return "@"+id;}
}
