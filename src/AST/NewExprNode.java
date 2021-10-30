package AST;
import Util.position;
import java.util.ArrayList;
public class NewExprNode extends ExprNode{
    public ArrayList<ExprNode> Exprlist = new ArrayList<>();
    public TypeNode tp;
    public NewExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
