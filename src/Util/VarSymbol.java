package Util;

public class VarSymbol {
    public String identifier;
    public Type type;
    public boolean is_Global_var = false;
    public boolean is_Class_var = false;
    public boolean is_Main_var = false;
    public VarSymbol(String identifier,Type tp) {
        this.identifier=identifier;
        this.type=tp;
    }
    public VarSymbol(String identifier) {
        this.identifier=identifier;
    }
}
