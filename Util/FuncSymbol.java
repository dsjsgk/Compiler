package Util;
import java.util.ArrayList;
public class FuncSymbol extends Type{
    public Type type = null;
    public String identifier;
    public ArrayList<VarSymbol> paras = new ArrayList<>();
    public boolean isinClass=false;
    public FuncSymbol(String id) {this.identifier=id;}
}
