package AST;
import Util.Scope;
import Util.position;
public abstract class ASTNode {
    public position pos;
    public Scope thisscope;
    public ASTNode(position p) {
        pos=p;
    }
    abstract public void accept(ASTvisitor visitor);
}
