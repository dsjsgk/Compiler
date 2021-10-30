package AST;
import Util.position;
public class PrimaryExprNode extends ExprNode{
    public TypeNode tp;
    public String Val;
    public PrimaryExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}