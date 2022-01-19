package MIR;

public class CmpInst extends Inst{
    public enum CmpType{
        eq, //equal
        ne, //not equal
        sgt, //greater
        sge, //greater_equal
        slt, //smaller
        sle //smaller_equal
    }
    public operand lhs,rhs;
    public CmpType op;
    public register ans;
    public BaseType tp;
    public CmpInst(CmpType op,operand op1,operand op2,register ans,BaseType tp,BasicBlock bel) {
        super(bel);
        lhs = op1;
        rhs = op2;
        this. tp = tp;
        this.ans=ans;
        this.op = op;
    }
    @Override public String toString(){
        return ans.toString() + " = icmp " + op.name()+" "+tp.toString()+" "+lhs.toString()+", "+rhs.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
