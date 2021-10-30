package AST;
import Util.position;
public class SuffixExprNode extends ExprNode{
    public ExprNode a;
    public String op;
    public SuffixExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}