package MIR;
import java.util.ArrayList;
public class FuncType extends BaseType{
    public BaseType ret_tp;
    public ArrayList<BaseType> para_tp;
    public FuncType(BaseType ret_tp,ArrayList<BaseType> para_tp) {
        this.ret_tp = ret_tp;
        this.para_tp = para_tp;
    }
    @Override public String toString(){return null;}
    @Override public int size() {
        return 0;
    }
    @Override public operand defaultval(){return null;}
}
