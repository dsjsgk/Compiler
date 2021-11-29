package MIR;

public abstract class operand {
    public BaseType tp;
    public operand(BaseType tp) {
        this.tp = tp;
    }
    public abstract String toString();
}