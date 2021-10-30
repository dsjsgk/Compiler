package Util.error;
import Util.position;
public abstract class Error extends RuntimeException{
    private position pos;
    private String detail;
    public Error(String detail,position pos) {
        this.detail=detail;
        this.pos=pos;
    }
    public String toString() {
        return detail+": "+pos.toString();
    }
}
