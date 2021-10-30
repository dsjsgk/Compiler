package Util;

public class ArrayType extends Type{
    public Type type;
    public int dim=0;
    public ArrayType(Type tp,int dim){
        this.dim=dim;this.type=tp;
    }
    @Override
    public boolean equal(Type tp) {
        if(tp.is_null()) return true;
        else return ((tp instanceof ArrayType )&&( ((ArrayType) tp).dim==this.dim )&&(type.equal(((ArrayType) tp).type)));
    }
}
