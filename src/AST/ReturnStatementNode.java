package AST;
import Util.position;
public class ReturnStatementNode extends StatementNode {
    public ExprNode Val;
    public ReturnStatementNode(ExprNode Val,position p) {
        super(p);
        this.Val=Val;
    }
    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
