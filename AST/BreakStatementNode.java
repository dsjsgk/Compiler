package AST;
import Util.position;
public class BreakStatementNode extends StatementNode {
    public BreakStatementNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
