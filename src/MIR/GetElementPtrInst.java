package MIR;

import java.util.ArrayList;

public class GetElementPtrInst extends Inst{
    public register res;
    public operand addr;
    public ArrayList<operand> index;
    public GetElementPtrInst(operand addr,register res,ArrayList<operand> index,BasicBlock bel) {
        super(bel);
        this.res=res;
        this.addr = addr;
        this.index = index;
//        System.out.println(res.toString());
//        System.out.println(index.get(0).toString());
    }
    @Override public String toString () {
        StringBuilder ans = new StringBuilder();
        ans.append(res.toString() + " = " + "getelementptr ");
        ans.append(((PointerType)addr.tp).tp.toString()+", "+addr.tp.toString()+" "+addr.toString());
        for(operand tmp:index) {
            ans.append(", "+tmp.tp.toString()+" "+tmp.toString());
        }
        return ans.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
