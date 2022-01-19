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
//        if(addr.toString().equals("%it_37")&&val.toString().equals("%this_Array_begin_44")) {
//            assert false;
//        }
    }
    @Override public String toString() {
//        System.out.println("fuck "+addr.toString());
        //System.out.println(addr.toString());
        if(val instanceof NullConst) {
            return "store " + ((PointerType)addr.tp).tp.toString() + " " +val + ", "+addr.tp.toString() + " "+addr.toString();
        }
        else return "store " + val.tp.toString() + " " +val + ", "+addr.tp.toString() + " "+addr.toString();
    }
    @Override
    public void accept(IRvisitor tmp) {tmp.visit(this);}
}
