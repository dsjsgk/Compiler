package AST;
import Util.position;
import java.util.ArrayList;
public class ExprListNode extends ExprNode{
    public ArrayList<ExprNode> List = new ArrayList<ExprNode>();
    public ExprListNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
