package MIR;

class CmpInst extends Inst{
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
    public CmpInst(CmpType op,operand op1,operand op2) {
        lhs = op1;
        rhs = op2;
        this.op = op;
    }
    @Override public String toString(){
        return
    }
}
