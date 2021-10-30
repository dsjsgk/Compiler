package AST;
import Util.position;
import java.util.ArrayList;
public class ForStatementNode extends StatementNode {
    public StatementNode mainbody;
    public ExprNode init,condition,incr;
    public ArrayList<SinglevarDefStatementNode> initDef;
    public ForStatementNode(position p) {
        super(p);
        this.condition=this.incr=this.condition=this.init=null;
        initDef=new ArrayList<SinglevarDefStatementNode>();
    }
    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }
}
