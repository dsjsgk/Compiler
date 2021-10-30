package Util;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassType extends Type{
    public String identifier;
    public HashMap<String,VarSymbol> vars = new HashMap<String,VarSymbol>();
    public HashMap<String,FuncSymbol> funcs = new HashMap<String, FuncSymbol>();
    public FuncSymbol Constructor;
    public ClassType(String id) {
        this.identifier=id;
    }
    @Override
    public boolean equal(Type tp) {
        if(tp.is_null()) return true;
        else return ((tp instanceof ClassType) && (identifier.equals(((ClassType) tp).identifier)));
    }
}
