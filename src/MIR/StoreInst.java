package MIR;

public class StoreInst extends Inst{
//    public BaseType tp;
    public operand val;
    public operand addr;
    public StoreInst(operand addr,operand val,BasicBlock bel) {
        super(bel);
        this.addr = addr;
//        this.res = res;
        this.val = val;
    }
    @Override public String toString() {
        return "store " + val.tp.toString() + " " +val.toString() + ", "+addr.tp.toString() + " "+addr.toString();
    }
}
