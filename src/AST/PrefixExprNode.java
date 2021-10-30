package AST;
import Util.position;
public class PrefixExprNode extends ExprNode{
    public ExprNode a;
    public String op;
    public PrefixExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}