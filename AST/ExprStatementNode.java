package AST;
import Util.position;
public class ExprStatementNode extends StatementNode {
    public ExprNode expr;
    public ExprStatementNode(ExprNode expr,position p) {
        super(p);
        this.expr=expr;
    }
    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }
}
