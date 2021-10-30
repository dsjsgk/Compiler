package AST;
import Util.position;
public class UnaryExprNode extends ExprNode{
    public ExprNode a;
    public String op;
    public UnaryExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
