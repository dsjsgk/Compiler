package AST;
import Util.position;
import java.util.ArrayList;
public class FuncDefNode extends DEFNode{
    public ArrayList<SinglevarDefStatementNode> Paralist = new ArrayList<SinglevarDefStatementNode>();
    public String Name;
    public TypeNode return_type;
    public StatementNode body;
    public FuncDefNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
