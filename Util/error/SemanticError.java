package Util.error;
import Util.position;
public class SemanticError extends Error{
    public SemanticError(String detail,position pos) {
        super("SemanticError: "+detail,pos);
    }
}