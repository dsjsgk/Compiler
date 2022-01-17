package MIR;

abstract public class register extends operand{
    public String id;
    public Inst def_Inst;
    public register (Inst def_Inst,String id,BaseType tp) {
        super(tp);
        this.id = id;
        this.def_Inst = def_Inst;
    }
//    @Override public String toString(){return "%"+id;}
}
