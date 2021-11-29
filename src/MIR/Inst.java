package MIR;

abstract class Inst {
    Inst Pre,Nxt;
    public Inst() {
        Pre = null;
        Nxt = null;
    }
    abstract public String toString();

}
