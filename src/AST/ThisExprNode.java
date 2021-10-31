package AST;
import Util.position;
public class ThisExprNode extends ExprNode{
    public ThisExprNode(position p) {super(p);}
    @Override public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
