package MIR;

public class register extends operand{
    public String id;
    public register (String id,BaseType tp) {
        super(tp);
        this.id = id;
    }
    @Override public String toString(){return "%"+id;}
}
