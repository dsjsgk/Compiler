package AST;
import Util.VarSymbol;
import Util.position;
public class VarExprNode extends ExprNode{
    public String Name;
    public VarSymbol var;
    public VarExprNode(position p) {
        super(p);this.assign=true;
    }
    @Override public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
