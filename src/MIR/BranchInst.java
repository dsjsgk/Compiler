package MIR;

public class BranchInst extends Inst{
    public operand cond;
    public BasicBlock b1,b2;
    public BranchInst (BasicBlock b1,BasicBlock b2,operand cond) {
        this.b1 = b1;
        this.b2 = b2;
        this.cond = cond;
    }
    @Override public String toString() {

    }
}
