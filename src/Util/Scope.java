package Util;
import java.util.HashMap;
import Util.error.Error;
import AST.TypeNode;
import Util.error.SemanticError;

public class Scope {
    public Scope _Parent=null;
    public HashMap<String,VarSymbol> Vars=new HashMap<>();
    public HashMap<String,FuncSymbol> Funcs=new HashMap<>();
    public HashMap<String,Type> Types=new HashMap<>();
    public Scope(Scope _p) {
        this._Parent=_p;
    }
    public boolean has_Type(String id,boolean up,position pos) {
        if(Types.containsKey(id)) return true;
        if(!up||_Parent==null) return false;
        return _Parent.has_Type(id,up,pos);
    }
    public void New_Type(String id,Type type,position pos) {
        if(this.has_Type(id,true,pos)) throw new SemanticError("Same names of Types",pos);
        Types.put(id,type);
    }
    public void New_Function(String id,FuncSymbol func,position pos) {
        if(Funcs.containsKey(id)) throw new SemanticError("Same names of Functions",pos);
        if(this.has_Type(id,true,pos)) throw new SemanticError("Same names of func and type",pos);
        Funcs.put(id,func);
    }
    public void New_Var(String id,VarSymbol var,position pos) {
        if(this.has_Type(id,true,pos)) throw new SemanticError("Same names of var and type",pos);
        if(Vars.containsKey(id)) throw new SemanticError("Same names of vars",pos);
        Vars.put(id,var);
    }
    public Type Get_Type(String id, boolean up, position pos) {
        if (Types.containsKey(id)) return Types.get(id);
        else if (up && _Parent != null) return _Parent.Get_Type(id, true, pos);
        else throw new SemanticError("Missing types!", pos);
    }
    public Type Get_Type(TypeNode type) {
        if (type.dim == 0) return Types.get(type.typename);
        return new ArrayType(Types.get(type.typename), type.dim);
    }
    public FuncSymbol Get_Func(String id,boolean up,position pos) {
        if(Funcs.containsKey(id)) return Funcs.get(id);
        if(!up||_Parent==null) throw new SemanticError("Wrong Function",pos);
        return _Parent.Get_Func(id,up,pos);
    }
    public VarSymbol Get_Var(String id,boolean up,position pos) {
        if(Vars.containsKey(id)) return Vars.get(id);
        if(!up||_Parent==null) throw new SemanticError("Wrong Variable",pos);
        return _Parent.Get_Var(id,up,pos);
    }
}
