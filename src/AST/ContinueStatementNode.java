package AST;
import Util.position;
public class ContinueStatementNode extends StatementNode {
    public ContinueStatementNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }
}