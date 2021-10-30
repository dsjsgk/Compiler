package AST;
import Util.position;
public class AssignExprNode extends ExprNode{
    public ExprNode a,b;
    public String op;
    public AssignExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
