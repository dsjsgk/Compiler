package MIR;

class BinaryInst extends Inst{
    public enum OpType{
        add, sub, mul, sdiv, srem, shl, ashr, and, or, xor
    }
    public operand lhs,rhs;
    public OpType op;
    public BinaryInst(OpType op,operand op1,operand op2) {
        lhs = op1;
        rhs = op2;
        this.op = op;
    }
    @Override public String toString(){
        
    }
}
