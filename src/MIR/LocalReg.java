package MIR;

public class LocalReg extends register{
    //    public String id;
//    public operand val;
    public LocalReg(String id,BaseType tp) {
        super(null,id,tp);
    }
    @Override public String toString(){return "%"+id;}
}
