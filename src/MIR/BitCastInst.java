package MIR;

public class BitCastInst extends Inst{
    public register res;
    public BaseType tp;
    public operand obj;
    public BitCastInst(BaseType tp,register res,operand obj,BasicBlock bel) {
        super(bel);
        this.tp = tp;
        this.res = res;
        this.obj = obj;
    }
    @Override public String toString () {
        return res.toString() + " = " + "bitcast "+obj.tp.toString()+" "+obj.toString() +tp.toString();
    }
}
