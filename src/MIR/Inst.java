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
    public void Delete(){
        if(Nxt!=null){
            Nxt.Pre = Pre;
            if(Pre==null) {
                bel.begin_Inst = Nxt;
            }
        }
        if(Pre!=null) {
            Pre.Nxt = Nxt;
            if(Nxt==null) {
                bel.end_Inst = Pre;
            }
        }
    }
}
