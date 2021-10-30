package Util.error;
import Util.position;
public class internalError extends Error{
    public internalError(String detail, position pos) {
        super("internalError: "+detail,pos);
    }
}
