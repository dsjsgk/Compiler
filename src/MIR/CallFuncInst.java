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
        StringBuilder ans = new StringBuilder();

        if(this.res!=null&&!(this.res.tp instanceof VoidType)&&!(this.res.tp instanceof NullType)) {
            ans.append(res.toString());
            ans.append(" = ");//System.out.println(res.toString());
        }
        ans.append("call ").append(func.functp.ret_tp.toString()).append(" ").append(func.toString()).append("(");
        for(int i=0;i<paras_list.size();++i) {
            ans.append(func.functp.para_tp.get(i).toString());
            ans.append(" ");
            ans.append(paras_list.get(i).toString());
//            ans=ans+paras_list.get(i).toString();
            if(i!=paras_list.size()-1) ans.append(", ");
        }
        ans.append(")");
        return ans.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
