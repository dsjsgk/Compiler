package BackEnd;

import AST.ASTvisitor;

import AST.*;
import Util.*;
import Util.error.SemanticError;

import javax.net.ssl.SSLException;
import java.util.ArrayList;
public class IRPrinter implements ASTvisitor {
    public Scope global,cur;
    public int Circuit = 0;
    public ClassType inClass=null;
    public Type _return_type=null,_cur_type=null;
    public ArrayList<Type> _lambda_return_type=new ArrayList<>();
    public int flag_lambda=0;
    public IRPrinter(Scope _global) {
        global=_global;
    }
    @Override
    public void visit(ProgramNode tmp) {
//        tmp.program.forEach(x->x.accept(this));
    }

    @Override
    public void visit(ClassDefNode tmp) {
//        tmp.Funcs.forEach(x->x.accept(this));
    }

    @Override
    public void visit(ThisExprNode tmp) {
//        if(inClass==null) {
//            throw new SemanticError("Wrong use of this",tmp.pos);
//        }
//        else {
//            tmp.type = inClass;
//        }
    }

    @Override
    public void visit(FuncDefNode tmp) {
//
//        cur=new Scope(cur);
//        tmp.Paralist.forEach(x->cur.New_Var(x.Identifier,new VarSymbol(x.Identifier,global.Get_Type(x.type)),x.pos));
//
//        cur=cur._Parent;
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

    }

    @Override
    public void visit(ReturnStatementNode tmp) {

    }

    @Override
    public void visit(WhileStatementNode tmp) {

    }

    @Override
    public void visit(SuiteStatementNode tmp) {
    }

    @Override
    public void visit(BreakStatementNode tmp) {

    }

    @Override
    public void visit(ExprStatementNode tmp) {

    }

    @Override
    public void visit(ForStatementNode tmp) {

    }

    @Override
    public void visit(PrimaryExprNode tmp) {

    }

    @Override
    public void visit(IfStatementNode tmp) {

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
