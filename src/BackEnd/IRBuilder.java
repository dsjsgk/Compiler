package BackEnd;

import AST.*;
import Util.*;
import Util.error.SemanticError;

import javax.net.ssl.SSLException;
import java.util.ArrayList;
public class IRBuilder implements ASTvisitor {
    public Scope global,cur;
    public int Circuit = 0;
    public ClassType inClass=null;
    public Type _return_type=null,_cur_type=null;
    public ArrayList<Type> _lambda_return_type=new ArrayList<>();
    public int flag_lambda=0;
    public IRBuilder(Scope _global) {
        global=_global;
    }
    @Override
    public void visit(ProgramNode tmp) {
        tmp.program.forEach(x->x.accept(this));
    }

    @Override
    public void visit(ClassDefNode tmp) {
        tmp.Funcs.forEach(x->x.accept(this));
    }

    @Override
    public void visit(ThisExprNode tmp) {
        if(inClass==null) {
            throw new SemanticError("Wrong use of this",tmp.pos);
        }
        else {
            tmp.type = inClass;
        }
    }

    @Override
    public void visit(FuncDefNode tmp) {

        cur=new Scope(cur);
        tmp.Paralist.forEach(x->cur.New_Var(x.Identifier,new VarSymbol(x.Identifier,global.Get_Type(x.type)),x.pos));

        cur=cur._Parent;
    }

    @Override
    public void visit(DEFNode tmp) {
        return ;
    }

    @Override
    public void visit(TypeNode tmp) {
        return ;
    }

    @Override
    public void visit(ContinueStatementNode tmp) {
        if(Circuit==0) throw new SemanticError("Continue outside Circuit",tmp.pos);
    }

    @Override
    public void visit(varDefStatementNode tmp) {
        for (SinglevarDefStatementNode x : tmp.list) {
            x.accept(this);
        }
    }

    @Override
    public void visit(ReturnStatementNode tmp) {
        if(tmp.Val==null) {
            if(!_cur_type.is_void()) throw new SemanticError("Expected Return Val but get NULL",tmp.pos);
        }
        else {
            tmp.Val.accept(this);
            _return_type = tmp.Val.type;
            if(!_cur_type.equal(_return_type)) throw new SemanticError("Wrong Return Type",tmp.pos);
        }
    }

    @Override
    public void visit(WhileStatementNode tmp) {
        tmp.condition.accept(this);
        if(!tmp.condition.type.is_boolean()) throw new SemanticError("Wrong condition Types",tmp.pos);
        Circuit++;
        cur=new Scope(cur);
        tmp.mainbody.accept(this);
        cur=cur._Parent;
        Circuit--;
    }

    @Override
    public void visit(SuiteStatementNode tmp) {
    }

    @Override
    public void visit(BreakStatementNode tmp) {
        if(Circuit==0) throw new SemanticError("Break outside Circuit",tmp.pos);
    }

    @Override
    public void visit(ExprStatementNode tmp) {
        if(tmp.expr!=null)
            tmp.expr.accept(this);
    }

    @Override
    public void visit(ForStatementNode tmp) {
        if(tmp.init!=null) {
            tmp.init.accept(this);
        }
        if(tmp.initDef!=null) {
            tmp.initDef.forEach(x->x.accept(this));
        }
        if(tmp.condition!=null) {
            tmp.condition.accept(this);
            if(!tmp.condition.type.is_boolean()) throw new SemanticError("For Condition is not a boolean type",tmp.condition.pos);
        }
        if(tmp.incr!=null) tmp.incr.accept(this);
        cur = new Scope(cur);
        ++Circuit;
        tmp.mainbody.accept(this);
        cur = cur._Parent;
        --Circuit;
    }

    @Override
    public void visit(PrimaryExprNode tmp) {
        tmp.type=new LiteralType(tmp.tp.typename);
    }

    @Override
    public void visit(IfStatementNode tmp) {
        tmp.condition.accept(this);
        if(!tmp.condition.type.is_boolean()) throw new SemanticError("Wrong Ifstmt condition type" , tmp.pos);
        cur = new Scope(cur);
        tmp.thenStmt.accept(this);
        cur = cur._Parent;
        if(tmp.elseStmt!=null) {
            cur = new Scope(cur);
            tmp.elseStmt.accept(this);
            cur = cur._Parent;
        }
    }

    @Override
    public void visit(SuffixExprNode tmp) {
        tmp.a.accept(this);
    }

    @Override
    public void visit(PrefixExprNode tmp) {
        tmp.a.accept(this);
    }

    @Override
    public void visit(MemberExprNode tmp) {
    }

    @Override
    public void visit(LambdaExprNode tmp) {

    }

    @Override
    public void visit(BinaryExprNode tmp) {
    }

    @Override
    public void visit(UnaryExprNode tmp) {
    }

    @Override
    public void visit(StatementNode tmp) {
        return ;
    }

    @Override
    public void visit(ArrayExprNode tmp) {
    }

    @Override
    public void visit(FuncExprNode tmp) {
    }

    @Override
    public void visit(NewExprNode tmp) {
        tmp.type=global.Get_Type(tmp.tp);
        for (ExprNode x : tmp.Exprlist) {
            x.accept(this);
            if(!x.type.is_int()) throw new SemanticError("Index is not a integer",tmp.pos);
        }
    }

    @Override
    public void visit(ASTNode tmp) {
        return ;
    }

    @Override
    public void visit(ExprListNode tmp) {
        return ;
    }

    @Override
    public void visit(SinglevarDefStatementNode tmp) {
    }

    @Override
    public void visit(VarExprNode tmp) {
        tmp.type = cur.Get_Var(tmp.Name,true,tmp.pos).type;

    }
}
