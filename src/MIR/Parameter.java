package MIR;

public class Parameter extends LocalReg{
    public IRFunction func;
    public Parameter (BaseType tp,String name) {
        super(name,tp);
    }
    @Override public String toString() {
        return super.toString();
    }
}
