package AST;
import Util.position;
public class ArrayExprNode extends ExprNode{
    public ExprNode Index,Array;
    public ArrayExprNode(position p) {super(p);this.assign=true;}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
