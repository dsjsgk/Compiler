package MIR;

public class BranchInst extends Inst{
    public operand cond;
    public BasicBlock b1,b2;
    public BranchInst (BasicBlock b1,BasicBlock b2,operand cond,BasicBlock bel) {
        super(bel);
        this.b1 = b1;
        this.b2 = b2;
        this.cond = cond;
    }
    @Override public String toString() {
        return cond==null?("br i1 "+cond.toString()+", label "+b1.toString()+", label"+b2.toString()):("br label "+b1.toString());
    }
}
