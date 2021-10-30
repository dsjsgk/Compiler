package AST;
import Util.position;
public class MemberExprNode extends ExprNode{
    public ExprNode P,S;
    public boolean is_a_function = false;
    public MemberExprNode(position p) {super(p);this.assign=true;}
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
