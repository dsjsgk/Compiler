package FrontEnd;

import AST.*;
import Util.*;
import Util.error.SemanticError;

public class Init implements ASTvisitor {
    public Scope global,cur;
    public String inClass=null;
    public int flag = 0;
    public Init(Scope sc) {
        global=sc;
        global.Types.put("string",new LiteralType("string"));
        global.Types.put("bool",new LiteralType("bool"));
        global.Types.put("void",new LiteralType("void"));
        global.Types.put("null",new LiteralType("null"));
        global.Types.put("int",new LiteralType("int"));
        FuncSymbol res = new FuncSymbol("print");
        res.type=new LiteralType("void");
        res.paras.add(new VarSymbol("str",new LiteralType("string")));
        global.Funcs.put("print",res);

        res = new FuncSymbol("println");
        res.type=new LiteralType("void");
        res.paras.add(new VarSymbol("str",new LiteralType("string")));
        global.Funcs.put("println",res);

        res = new FuncSymbol("printInt");
        res.type=new LiteralType("void");
        res.paras.add(new VarSymbol("n",new LiteralType("int")));
        global.Funcs.put("printInt",res);

        res = new FuncSymbol("getString");
        res.type=new LiteralType("string");
        global.Funcs.put("getString",res);

        res = new FuncSymbol("getInt");
        res.type=new LiteralType("int");
        global.Funcs.put("getInt",res);

        res = new FuncSymbol("toString");
        res.type=new LiteralType("string");
        res.paras.add(new VarSymbol("i",new LiteralType("int")));
        global.Funcs.put("toString",res);
    }

    @Override
    public void visit(TypeNode tmp) {

    }

    @Override
    public void visit(DEFNode tmp) {

    }

    @Override
    public void visit(ASTNode tmp) {

    }

    @Override
    public void visit(FuncDefNode tmp) {
        if(flag==0) return ;
        if(inClass==null) {
            FuncSymbol temp = new FuncSymbol(tmp.Name);
            temp.type=global.Get_Type(tmp.return_type);
            tmp.Paralist.forEach(x -> temp.paras.add(new VarSymbol(x.Identifier,global.Get_Type(x.type))));
            global.New_Function(tmp.Name,temp,tmp.pos);
        }
        else {
            FuncSymbol temp = new FuncSymbol(tmp.Name);
            temp.type=global.Get_Type(tmp.return_type);
            temp.isinClass=true;
            tmp.Paralist.forEach(x -> temp.paras.add(new VarSymbol(x.Identifier,global.Get_Type(x.type))));
            cur.New_Function(tmp.Name,temp,tmp.pos);
        }
    }

    @Override
    public void visit(NewExprNode tmp) {

    }

    @Override
    public void visit(ProgramNode tmp) {
        tmp.program.forEach(x->x.accept(this));
        cur=global;
        flag=1;
        tmp.program.forEach(x->x.accept(this));
    }

    @Override
    public void visit(ClassDefNode tmp) {
        if(flag==0) {
            ClassType temp = new ClassType(tmp.Classname);
            global.New_Type(tmp.Classname,temp,tmp.pos);
        }
        if(flag==1) {
            inClass=tmp.Classname;
            cur=new Scope(cur);
            if(tmp.Constructor!=null) {
                FuncSymbol ctr=new FuncSymbol(tmp.Classname);
                ctr.type=global.Get_Type(inClass,true,tmp.pos);
                ((ClassType)global.Types.get(inClass)).Constructor=ctr;
                if(tmp.Constructor.Paralist.size()!=0) {
                    throw new SemanticError("Wrong Constructor!",tmp.Constructor.pos);
                }
            }
            tmp.Vars.forEach(x->x.accept(this));
            tmp.Funcs.forEach(x->x.accept(this));
            ((ClassType)global.Types.get(inClass)).vars=cur.Vars;
            ((ClassType)global.Types.get(inClass)).funcs=cur.Funcs;
            cur= cur._Parent;
            inClass=null;
        }
    }

    @Override
    public void visit(ExprListNode tmp) {

    }

    @Override
    public void visit(FuncExprNode tmp) {

    }

    @Override
    public void visit(ArrayExprNode tmp) {

    }

    @Override
    public void visit(StatementNode tmp) {

    }

    @Override
    public void visit(UnaryExprNode tmp) {

    }

    @Override
    public void visit(AssignExprNode tmp) {

    }

    @Override
    public void visit(BinaryExprNode tmp) {

    }

    @Override
    public void visit(LambdaExprNode tmp) {

    }

    @Override
    public void visit(MemberExprNode tmp) {

    }

    @Override
    public void visit(PrefixExprNode tmp) {

    }

    @Override
    public void visit(SuffixExprNode tmp) {

    }

    @Override
    public void visit(IfStatementNode tmp) {

    }

    @Override
    public void visit(PrimaryExprNode tmp) {

    }

    @Override
    public void visit(ForStatementNode tmp) {

    }

    @Override
    public void visit(ExprStatementNode tmp) {

    }

    @Override
    public void visit(BreakStatementNode tmp) {

    }

    @Override
    public void visit(SuiteStatementNode tmp) {

    }

    @Override
    public void visit(WhileStatementNode tmp) {

    }

    @Override
    public void visit(ReturnStatementNode tmp) {

    }

    @Override
    public void visit(varDefStatementNode tmp) {

    }

    @Override
    public void visit(ContinueStatementNode tmp) {

    }

    @Override
    public void visit(SinglevarDefStatementNode tmp) {
        if(flag==0) return ;
        if(inClass==null) return ;
        VarSymbol temp = new VarSymbol(tmp.Identifier,global.Get_Type(tmp.type));
        temp.is_Class_var=true;
        cur.New_Var(tmp.Identifier,temp,tmp.pos);

    }
    @Override public void visit(VarExprNode tmp) {}
}
