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
        return "";
    }
}
