package AST;
import Util.position;
import Util.Type;
public abstract class ExprNode extends ASTNode{
    public Type type;
    public boolean assign = false;
    public ExprNode(position p) {super(p);}
}
