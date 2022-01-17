package MIR;

public class GlobalReg extends register{
//    public String id;
    public operand val;
    public GlobalReg(operand val,Inst def_Inst,String id,BaseType tp) {
        super(def_Inst,id,tp);
        this.val=val;
    }
    @Override public String toString(){return "@"+id;}
}
