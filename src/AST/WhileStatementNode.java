package AST;
import Util.position;
public class WhileStatementNode extends StatementNode {
    public StatementNode mainbody;
    public ExprNode condition;
    public WhileStatementNode(ExprNode condition,StatementNode mainbody,position p) {
        super(p);
        this.condition=condition;
        this.mainbody=mainbody;
    }
    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }
}
