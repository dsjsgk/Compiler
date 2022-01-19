package MIR;

public class BinaryInst extends Inst{
    public enum OpType{
        add, sub, mul, sdiv, srem, shl, ashr, and, or, xor
    }
    public operand lhs,rhs;
    public register res;
    public OpType op;
    public BinaryInst(OpType op,operand op1,operand op2,BasicBlock bel,register res) {
        super(bel);
        lhs = op1;
        rhs = op2;
        this.op = op;
        this.res = res;
    }
    @Override public String toString(){
        return res.toString() + " = "+op.name() + " " + res.tp.toString() + " "+lhs.toString()+ ", " +rhs.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
