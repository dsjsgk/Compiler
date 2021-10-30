package AST;
import Util.position;
public class VarExprNode extends ExprNode{
    public String Name;
    public VarExprNode(position p) {
        super(p);
    }
    @Override public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
