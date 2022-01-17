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
    }
    @Override public String toString () {
        String ans;
        ans=res.toString() + " = " + "getelementptr ";
        ans=ans+")";
        return ans;
    }
}
