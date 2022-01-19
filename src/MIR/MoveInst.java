package MIR;

public class MoveInst extends Inst{
//    public BaseType tp;
    public register res;
    public operand tmp;
    public MoveInst(register res,operand tmp,BasicBlock bel) {
        super(bel);
//        this.addr = addr;
        this.res = res;
        this.tmp = tmp;
    }
    @Override public String toString() {
        return "move " + res.toString()+ " "+tmp.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
