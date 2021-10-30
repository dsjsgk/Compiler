package AST;
import Util.position;
public class IfStatementNode extends StatementNode {
    public StatementNode thenStmt,elseStmt;
    public ExprNode condition;
    public IfStatementNode(ExprNode condition,StatementNode thenStmt,StatementNode elseStmt,position p) {
        super(p);
        this.condition=condition;
        this.elseStmt=elseStmt;
        this.thenStmt=thenStmt;
    }
    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }
}
