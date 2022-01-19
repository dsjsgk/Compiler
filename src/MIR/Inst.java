package MIR;

public abstract class Inst extends Basis{
    public Inst Pre,Nxt;
    public BasicBlock bel;
    public Inst(BasicBlock bel) {
        Pre = null;
        Nxt = null;
        this.bel = bel;
    }
    abstract public String toString();
    abstract public void accept(IRvisitor tmp);
}
