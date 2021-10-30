package AST;
import Util.position;
import java.util.ArrayList;
public class ProgramNode extends ASTNode{
    public ArrayList<ASTNode> program=new ArrayList<>();
    public ProgramNode(position p) {
        super(p);
    }
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
