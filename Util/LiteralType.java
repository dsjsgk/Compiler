package Util;

public class LiteralType extends Type{
    public String identifier;
    public LiteralType(String identifier) {
        this.identifier=identifier;
    }
    @Override
    public boolean equal(Type tp) {
        if(this.is_null()) return (tp.is_null()||(tp instanceof ArrayType )||(tp instanceof ClassType));
        return ((tp instanceof LiteralType)&&(identifier.equals(((LiteralType)tp).identifier)));
    }
    @Override public boolean is_boolean() {return identifier.equals("bool");}
    @Override public boolean is_int() {return identifier.equals("int");}
    @Override public boolean is_string() {return identifier.equals("string");}
    @Override public boolean is_void () {return identifier.equals("void");}
    @Override public boolean is_null (){return identifier.equals("null");}
}
