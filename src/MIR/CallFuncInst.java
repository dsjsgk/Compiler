package MIR;
import java.util.ArrayList;
public class CallFuncInst extends Inst{
    public register res;
    public IRFunction func;
    public ArrayList<operand> paras_list;
    public CallFuncInst(IRFunction func,register res,ArrayList<operand> paras_list,BasicBlock bel) {
        super(bel);
        this.res=res;
        this.func = func;
        this.paras_list = paras_list;
    }
    @Override public String toString () {
        String ans;
        ans=res.toString() + " = " + "call "+func.functp.toString()+" "+func.id+"(";
        for(int i=0;i<paras_list.size();++i) {
            ans=ans+paras_list.get(i).toString();
            if(i!=paras_list.size()-1) ans=ans+", ";
        }
        ans=ans+")";
        return ans;
    }
}
