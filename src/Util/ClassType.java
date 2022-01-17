package Util;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassType extends Type{
    public String identifier;
    public HashMap<String,VarSymbol> vars = new HashMap<String,VarSymbol>();
    public HashMap<String,FuncSymbol> funcs = new HashMap<String, FuncSymbol>();
    public HashMap<String, Integer> mapping = new HashMap<String, Integer>();
    public FuncSymbol Constructor;
    public int num = 0;
    public ClassType(String id) {
        this.identifier=id;
    }
    @Override
    public boolean equal(Type tp) {
        if(tp.is_null()) return true;
        else return ((tp instanceof ClassType) && (identifier.equals(((ClassType) tp).identifier)));
    }
    public int getNumber(String name) {
        return mapping.get(name);
    }
}
