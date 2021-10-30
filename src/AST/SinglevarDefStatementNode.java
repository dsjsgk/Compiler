package AST;
import Util.position;
public class SinglevarDefStatementNode extends StatementNode {
    public TypeNode type;
    public String Identifier;
    public ExprNode expr;
    public SinglevarDefStatementNode(TypeNode type,String Identifier,ExprNode expr,position p) {
        super(p);
        this.expr=expr;
        this.Identifier=Identifier;
        this.type=type;
    }
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
