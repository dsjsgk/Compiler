package MIR;

public class LocalReg extends register{
    //    public String id;
//    public operand val;
//    boolean temp = true;
    public LocalReg(String id,BaseType tp) {
        super(null,id,tp,true);
    }
    public LocalReg(String id,BaseType tp,boolean temp) {
        super(null,id,tp,temp);
    }
    @Override public String toString(){
//        if(!this.temp)return "%"+id;else
            return "%"+this.id+"_"+this.No;
    }
}
