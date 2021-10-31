package AST;
import Util.position;
import java.util.ArrayList;
public class FuncExprNode extends ExprNode{
    public ExprNode funcname;
    public ArrayList<ExprNode> paras = new ArrayList<>();
    public FuncExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor){visitor.visit(this);};
}
