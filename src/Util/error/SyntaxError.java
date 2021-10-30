package Util.error;
import Util.position;
public class SyntaxError extends Error{
    public SyntaxError(String detail,position pos) {
        super("SyntaxError: "+detail,pos);
    }
}
