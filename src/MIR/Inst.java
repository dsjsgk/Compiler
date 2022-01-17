package MIR;

abstract class Inst extends Basis{
    Inst Pre,Nxt;
    BasicBlock bel;
    public Inst(BasicBlock bel) {
        Pre = null;
        Nxt = null;
        this.bel = bel;
    }
    abstract public String toString();

}
