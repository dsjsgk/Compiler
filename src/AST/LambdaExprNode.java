package AST;
import Util.position;
import java.util.ArrayList;
public class LambdaExprNode extends ExprNode{
    public varDefStatementNode ParaDef;
    public ExprListNode Funcall;
    public StatementNode body;
    public LambdaExprNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
