package MIR;
import java.util.ArrayList;
//import java.util.;
public class PhiInst extends Inst{
//    public BaseType tp;
    public register res;
    public ArrayList<BasicBlock> list_block;
    public ArrayList<operand> list_val;
    public PhiInst(register res,ArrayList<BasicBlock> list_block,ArrayList<operand> list_val,BasicBlock bel) {
        super(bel);
        this.res=res;
        this.list_block = list_block;
        this.list_val = list_val;
    }
    @Override public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(res.toString()+" = phi "+res.tp.toString());
        if(list_block.isEmpty()) {
            return ans.toString();
        }
        for(int i=0;i<list_block.size();++i) {
            BasicBlock tmp1 = list_block.get(i);
            operand tmp2 = list_val.get(i);
            if(i!=0) ans.append(", ");
            ans.append("[ "+tmp2.toString()+", "+tmp1.toString()+"]");
        }
        return ans.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
