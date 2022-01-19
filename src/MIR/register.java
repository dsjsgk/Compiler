package MIR;

abstract public class register extends operand{
    public String id;
    public Inst def_Inst;
    public boolean temp;
    public static int num=0;
    public int No;
    public register (Inst def_Inst,String id,BaseType tp) {
        super(tp);
        this.id = id;
        this.def_Inst = def_Inst;
        temp = true;
        No = num++;
    }
    public register (Inst def_Inst,String id,BaseType tp,boolean temp) {
        super(tp);
        this.id = id;
        this.def_Inst = def_Inst;
        this.temp = temp;
        No = num++;
    }
    @Override public String toString(){return null;}
}
