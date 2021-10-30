package AST;
import Util.position;
public abstract class ASTNode {
    public position pos;
    public ASTNode(position p) {
        pos=p;
    }
    abstract public void accept(ASTvisitor visitor);
}
