package MIR;

public class IntType extends BaseType{
    public int size;
    public IntType(int size) {this.size=size;}
    @Override public String toString(){if(size==4)return "i32";else return "i1";}
    @Override public int size(){return size;}
}

a = 1
if (cond) {
    a = 2
} else {
    a = 3
}
b = a

%1 = 1
if (cond) {
    %2 = 2
} else {
    %3 = 3
}
a4 = phi(from which branch, a2, a3)
b = a4