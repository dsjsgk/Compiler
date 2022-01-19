package MIR;

public class GlobalReg extends register{
//    public String id;
    public operand val;
    public GlobalReg(operand val,Inst def_Inst,String id,BaseType tp) {
        super(def_Inst,id,tp);
        this.val=val;
    }
    public GlobalReg(operand val,Inst def_Inst,String id,BaseType tp,boolean tmp) {
        super(def_Inst,id,tp,tmp);
        this.val=val;
    }
    @Override public String toString(){return "@"+id;}
    public String deftoString() {
        if(!(val instanceof Const)) assert false;
        StringBuilder ans = new StringBuilder();
        ans.append(this.toString()+" = ");
        if(val instanceof StringConst) {
            ans.append("private unnamed_addr constant "+((PointerType)tp).toStringBase()+" "+val.toString());
        }
        else ans.append("global "+((PointerType)tp).toStringBase()+" "+val.toString());
        return ans.toString();
    }//used for printer
}
