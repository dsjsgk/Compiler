package MIR;

public class LoadInst extends Inst{
    public BaseType tp;
    public register res;
    public operand addr;
    public LoadInst(BaseType tp,register res,operand addr,BasicBlock bel) {
        super(bel);
        this.addr = addr;
        this.res = res;
        this.tp = tp;
    }
    @Override public String toString() {
        return res.toString() + " = load "+ tp.toString() + ", " + addr.tp.toString() + " " +addr.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
