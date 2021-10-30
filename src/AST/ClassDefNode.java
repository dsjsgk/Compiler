package AST;
import Util.position;
import java.util.ArrayList;
public class ClassDefNode extends DEFNode{
    public String Classname;
    public ArrayList<SinglevarDefStatementNode> Vars = new ArrayList<SinglevarDefStatementNode>();
    public ArrayList<FuncDefNode> Funcs = new ArrayList<FuncDefNode>();
    public FuncDefNode Constructor;
    public ClassDefNode(position p) {super(p);}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}