package AST;
import Util.position;
public class TypeNode extends ASTNode{
    public String typename;
    public int dim=0;
    public TypeNode(String id,int dim,position p){
        super(p);
        typename=id;
        this.dim=dim;
    }
    @Override
    public void accept(ASTvisitor visitor) {visitor.visit(this);}
}
