package MIR;

public class AllocaInst extends Inst{
    public register res;
    public BaseType tp;
    public AllocaInst(BaseType tp,register res,BasicBlock bel) {
        super(bel);
        this.tp = tp;
        this.res = res;
    }
    @Override public String toString () {
        return res.toString() + " = " + "alloca "+tp.toString();
    }
}
