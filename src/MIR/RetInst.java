package MIR;

public class RetInst extends Inst{
    public BaseType tp;
    public operand val;
    public RetInst(BaseType tp,operand val,BasicBlock bel) {
        super(bel);
        this.tp=tp;
        this.val=val;
    }
    @Override public String toString () {
        if(tp instanceof NullType||tp instanceof VoidType) return "ret void";
        return "ret "+ tp.toString()+" "+val.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
