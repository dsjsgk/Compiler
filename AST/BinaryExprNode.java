package AST;
import Util.position;
public class BinaryExprNode extends ExprNode{
    public ExprNode a,b;
    public String op;
    public BinaryExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
