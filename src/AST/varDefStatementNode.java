package AST;
import Util.position;
import java.util.ArrayList;
public class varDefStatementNode extends StatementNode{
    public ArrayList<SinglevarDefStatementNode> list=new ArrayList<SinglevarDefStatementNode>();
    public varDefStatementNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
