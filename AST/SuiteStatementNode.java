package AST;
import Util.position;
import java.util.ArrayList;
public class SuiteStatementNode extends StatementNode {
    public ArrayList<StatementNode> Stmts;
    public SuiteStatementNode(position p) {
        super(p);
        this.Stmts=new ArrayList<StatementNode>();
    }
    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }
}
