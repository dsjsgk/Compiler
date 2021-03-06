package FrontEnd;

import AST.*;
import Util.*;
import Util.error.SemanticError;

import javax.net.ssl.SSLException;
import java.util.ArrayList;
public class SemanticChecker implements ASTvisitor {
    public Scope global,cur;
    public int Circuit = 0;
    public ClassType inClass=null;
    public Type _return_type=null,_cur_type=null;
    public ArrayList<Type> _lambda_return_type=new ArrayList<>();
    public int flag_lambda=0;
    public SemanticChecker(Scope _global) {
        global=_global;
    }
    @Override
    public void visit(ProgramNode tmp) {
        tmp.thisscope = cur;
        cur=global;
        FuncSymbol Main = global.Get_Func("main",false,tmp.pos);
        if(Main.paras.size()>0) throw new SemanticError("main function has parameters!",tmp.pos);
        if(!Main.type.is_int()) throw new SemanticError("main function is not int type!",tmp.pos);
        tmp.program.forEach(x->x.accept(this));
    }

    @Override
    public void visit(ClassDefNode tmp) {
        tmp.thisscope = cur;
        cur=new Scope(cur);
        inClass=(ClassType) global.Types.get(tmp.Classname);
        inClass.vars.forEach((key,val)->cur.New_Var(key,val,tmp.pos));
        inClass.funcs.forEach((key,val)->cur.New_Function(key,val,tmp.pos));

        if(tmp.Constructor!=null) {
            if(!tmp.Constructor.Name.equals(tmp.Classname)) throw new SemanticError("Wrong Constructor Name!",tmp.pos);
            tmp.Constructor.accept(this);
        }//

        tmp.Funcs.forEach(x->x.accept(this));
        cur=cur._Parent;
        inClass=null;

    }

    @Override
    public void visit(ThisExprNode tmp) {
        tmp.thisscope = cur;
        if(inClass==null) {
            throw new SemanticError("Wrong use of this",tmp.pos);
        }
        else {
            tmp.type = inClass;
        }
    }

    @Override
    public void visit(FuncDefNode tmp) {
        tmp.thisscope = cur;
        cur=new Scope(cur);
        tmp.Paralist.forEach(x->cur.New_Var(x.Identifier,new VarSymbol(x.Identifier,global.Get_Type(x.type)),x.pos));
        _return_type=null;
        _cur_type=null;
        if(tmp.return_type==null) _cur_type=new LiteralType("void");
        else _cur_type=global.Get_Type(tmp.return_type);
        tmp.body.accept(this);
        if(tmp.Name.equals("main")) {
            if(_return_type!=null&&!_return_type.equal(_cur_type)) throw new SemanticError("Wrong Main Func return type",tmp.pos);
        }
        else {
            if(_cur_type.is_void()) {
                if (_return_type != null) throw new SemanticError("Expected No Return Val", tmp.pos);
            }
            else if(!_cur_type.equal(_return_type)) throw new SemanticError("Wrong Return type", tmp.pos);
        }
        _cur_type=_return_type=null;
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
        tmp.thisscope = cur;
        for (SinglevarDefStatementNode x : tmp.list) {
            x.accept(this);
        }
    }

    @Override
    public void visit(ReturnStatementNode tmp) {
        tmp.thisscope = cur;
        if(flag_lambda>0) {
            Type res;
            if(tmp.Val == null) res = new LiteralType("null");
            else {
                tmp.Val.accept(this);
                res = tmp.Val.type;
            }
            if(res instanceof FuncSymbol) throw new SemanticError("Wrong return type of lambda",tmp.pos);
            if(_lambda_return_type.get(flag_lambda-1) instanceof FuncSymbol) {
                _lambda_return_type.set(flag_lambda-1, res);
            }
            else if (!_lambda_return_type.get(flag_lambda-1).equal(res)) throw new SemanticError("Wrong return type of lambda",tmp.pos);
            return;
        }
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
        tmp.thisscope = cur;
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
        tmp.thisscope = cur;
        for (StatementNode x : tmp.Stmts) {
            if(x instanceof SuiteStatementNode) {
                cur=new Scope(cur);
                x.accept(this);
                cur=cur._Parent;
            }
            else x.accept(this);
        }
    }

    @Override
    public void visit(BreakStatementNode tmp) {
        tmp.thisscope = cur;
        if(Circuit==0) throw new SemanticError("Break outside Circuit",tmp.pos);
    }

    @Override
    public void visit(ExprStatementNode tmp) {
        tmp.thisscope = cur;
        if(tmp.expr!=null)
        tmp.expr.accept(this);
    }

    @Override
    public void visit(ForStatementNode tmp) {
        tmp.thisscope = cur;
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
        tmp.thisscope = cur;
        tmp.type=new LiteralType(tmp.tp.typename);
    }

    @Override
    public void visit(IfStatementNode tmp) {
        tmp.thisscope = cur;
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
        tmp.thisscope = cur;
        tmp.a.accept(this);
        tmp.type=tmp.a.type;
        if(!tmp.type.is_int()) throw new SemanticError("type of A++ is not int", tmp.pos);
        if(!tmp.a.assign) throw new SemanticError("Var is not Left Val",tmp.pos);

    }

    @Override
    public void visit(PrefixExprNode tmp) {
        tmp.thisscope = cur;
        tmp.a.accept(this);
        tmp.type=tmp.a.type;
        if(!tmp.type.is_int()) throw new SemanticError("type of ++A is not int",tmp.pos);
        if(!tmp.a.assign) throw new SemanticError("Var is not Left Val",tmp.pos);
        tmp.assign=true;

    }

    @Override
    public void visit(MemberExprNode tmp) {
        tmp.thisscope = cur;
        tmp.P.accept(this);
        if(tmp.P.type.is_string()&&tmp.is_a_function) {
                if(tmp.S.equals("length")){
                    //System.out.println(1);
                    FuncSymbol res = new FuncSymbol("size");
                    res.type = new LiteralType("int");
                    tmp.type=res;
                    return ;
                }
                if(tmp.S.equals("substring")){
                    FuncSymbol res = new FuncSymbol("substring");
                    res.type = new LiteralType("string");
                    res.paras.add(new VarSymbol("left",new LiteralType("int")));
                    res.paras.add(new VarSymbol("right",new LiteralType("int")));
                    tmp.type = res;
                    return ;
                }
                if(tmp.S.equals("parseInt")) {
                    FuncSymbol res = new FuncSymbol("parseInt");
                    res.type = new LiteralType("int");
                    tmp.type=res;
                    return ;
                }
                if(tmp.S.equals("ord")) {
                    FuncSymbol res = new FuncSymbol("ord");
                    res.type = new LiteralType("int");
                    res.paras.add(new VarSymbol("pos",new LiteralType("int")));
                    tmp.type=res;
                    return ;
                }
        }
        if(tmp.P.type instanceof ArrayType) {
                if(tmp.S.equals("size")) {
                    FuncSymbol res = new FuncSymbol("size");
                    res.type = new LiteralType("int");
                    tmp.type=res;
                    return ;
                }
        }
        if(tmp.P.type instanceof ClassType) {
            ClassType thisClass = (ClassType) tmp.P.type;
            if(tmp.is_a_function) {
                if(true) {
                    if (thisClass.funcs.containsKey(tmp.S)) {
                        tmp.type = thisClass.funcs.get(tmp.S);
                    }
                    else throw new SemanticError("Wrong Function in Class",tmp.pos);
                }
            }
            else {
                if(true) {
                    if(thisClass.vars.containsKey(tmp.S)) {
                        tmp.type = thisClass.vars.get(tmp.S).type;
                        tmp.assign = true;
                    }
                    else throw new SemanticError("Wrong Var in Class",tmp.pos);
                }
            }
        }
        else throw new SemanticError("Undefined Class or Inside Functions",tmp.pos);
    }

    @Override
    public void visit(LambdaExprNode tmp) {
        tmp.thisscope = cur;
        if(tmp.Funcall==null||tmp.ParaDef==null) {
            if(tmp.Funcall==null&&tmp.ParaDef==null) ;
            else throw new SemanticError("Wrong Lambda paras",tmp.pos);
        }
        else if(tmp.Funcall.List.size()!=tmp.ParaDef.list.size()) {
            throw new SemanticError("Wrong Lambda paras",tmp.pos);
        }
        cur = new Scope(cur);
        if(tmp.Funcall!=null)
        for(int i=0;i<tmp.Funcall.List.size();++i) {
            tmp.ParaDef.list.get(i).accept(this);
            tmp.Funcall.List.get(i).accept(this);
            if(!tmp.Funcall.List.get(i).type.equal(global.Get_Type(tmp.ParaDef.list.get(i).type))) throw new SemanticError("Wrong paras",tmp.pos);
            //cur.New_Var(tmp.ParaDef.list.get(i).Identifier,new VarSymbol(tmp.ParaDef.list.get(i).Identifier,tmp.Funcall.List.get(i).type), tmp.pos);
        }
        flag_lambda++;
        _lambda_return_type.add(new FuncSymbol("null"));
        tmp.body.accept(this);
        flag_lambda--;
        tmp.type = _lambda_return_type.get(flag_lambda);
        _lambda_return_type.remove(flag_lambda);
        cur = cur._Parent;

    }

    @Override
    public void visit(BinaryExprNode tmp) {
        tmp.thisscope = cur;
        tmp.a.accept(this);
        tmp.b.accept(this);
//        System.out.println(tmp.pos.toString());
//        System.out.println(tmp.b instanceof FuncExprNode);
        if(tmp.op.equals("+")) {
            if(tmp.a.type.is_int()&&tmp.b.type.is_int()) {
                tmp.type=new LiteralType("int");
            }
            else if(tmp.a.type.is_string()&&tmp.b.type.is_string()) {
                tmp.type=new LiteralType("string");
            }
            else throw new SemanticError("different types of +",tmp.pos);
            return ;
        }
        if(tmp.op.equals("-")||tmp.op.equals("*")||tmp.op.equals("%")||tmp.op.equals("<<")||tmp.op.equals(">>")||tmp.op.equals("/")||tmp.op.equals("&")||tmp.op.equals("|")||tmp.op.equals("^")) {
            if(tmp.a.type.is_int()&&tmp.b.type.is_int()) tmp.type=new LiteralType("int");
            else throw new SemanticError("Calculus Expr Error",tmp.pos);
            return ;
        }
        if(tmp.op.equals("&&")||tmp.op.equals("||")) {
            if(tmp.a.type.is_boolean()&&tmp.b.type.is_boolean()) tmp.type=new LiteralType("bool");
            else throw new SemanticError("BinaryLogicExprError",tmp.pos);
            return ;
        }
        if(tmp.op.equals("<")||tmp.op.equals("<=")||tmp.op.equals(">")||tmp.op.equals(">=")) {
            if((tmp.a.type.is_int()&&tmp.b.type.is_int())||(tmp.a.type.is_string()&&tmp.b.type.is_string())) tmp.type = new LiteralType("bool");
            else throw new SemanticError("Comparason Expr Error",tmp.pos);
            return ;
        }
        if(tmp.op.equals("==")||tmp.op.equals("!=")) {
            if(tmp.a.type.equal(tmp.b.type)) tmp.type = new LiteralType("bool");
            else throw new SemanticError("Equal Expr Error",tmp.pos);
            return ;
        }
        if(tmp.op.equals("=")) {
            if(!tmp.a.assign) throw new SemanticError("Assign is not Permitted",tmp.pos);
            if(!tmp.a.type.equal(tmp.b.type)) throw new SemanticError("Assign one type to another type",tmp.pos);
            tmp.type = tmp.a.type;
            tmp.assign = true;
            return ;
        }
        throw new SemanticError("Op cant be identified",tmp.pos);
        //tmp.thisscope = cur;
    }

    @Override
    public void visit(UnaryExprNode tmp) {
        tmp.thisscope = cur;
        tmp.a.accept(this);
        if(tmp.op.equals("-")||tmp.op.equals("+")||tmp.op.equals("~")) {
            if(tmp.a.type.is_int()) tmp.type=new LiteralType("int");
            else throw new SemanticError("Wrong Unary Expr",tmp.pos);
            return ;
        }
        if(tmp.op.equals("!")) {
            if(tmp.a.type.is_boolean()) tmp.type = new LiteralType("bool");
            else throw new SemanticError("Wrong Unary Expr",tmp.pos);
            return ;
        }
        throw new SemanticError("Op cant be identified",tmp.pos);
//        tmp.thisscope = cur;
    }

    @Override
    public void visit(StatementNode tmp) {
        return ;
    }

    @Override
    public void visit(ArrayExprNode tmp) {
        tmp.thisscope = cur;
        tmp.Array.accept(this);
        tmp.Index.accept(this);
        if(!tmp.Index.type.is_int()) {
            throw new SemanticError("Index is not a integer",tmp.pos);
        }
        if(!(tmp.Array.type instanceof ArrayType)) throw new SemanticError("Wrong Array",tmp.pos);
        if(((ArrayType) tmp.Array.type).dim>1)tmp.type=new ArrayType(((ArrayType) tmp.Array.type).type,((ArrayType) tmp.Array.type).dim-1);
        else tmp.type = ((ArrayType) tmp.Array.type).type;
    }

    @Override
    public void visit(FuncExprNode tmp) {
        tmp.thisscope = cur;
        FuncSymbol whichFunc;
        if(tmp.funcname instanceof VarExprNode) {
            whichFunc = cur.Get_Func(((VarExprNode) tmp.funcname).Name,true,tmp.pos);
            tmp.funcname.type = whichFunc;
        }
        else {
            tmp.funcname.accept(this);
            if(tmp.funcname.type instanceof FuncSymbol) whichFunc = (FuncSymbol) tmp.funcname.type;
            else throw new SemanticError("Wrong Function Name",tmp.pos);
        }
        tmp.type=whichFunc.type;
        if(whichFunc.paras.size()!=tmp.paras.size()) {
            throw new SemanticError("Wrong paras number",tmp.pos);
        }
        for(int i=0;i<whichFunc.paras.size();++i) {
            tmp.paras.get(i).accept(this);
            if(!tmp.paras.get(i).type.equal(whichFunc.paras.get(i).type)) throw new SemanticError("Wrong Parameters Type",tmp.pos);
        }
//        tmp.thisscope = cur;
    }

    @Override
    public void visit(NewExprNode tmp) {
        tmp.thisscope = cur;
        tmp.type=global.Get_Type(tmp.tp);
        for (ExprNode x : tmp.Exprlist) {
            x.accept(this);
            if(!x.type.is_int()) throw new SemanticError("Index is not a integer",tmp.pos);
        }
//        tmp.thisscope = cur;
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
        tmp.thisscope = cur;
        Type temp = global.Get_Type(tmp.type);
        if(tmp.expr!=null) {
            tmp.expr.accept(this);
            if (!tmp.expr.type.is_null()) if (!temp.equal(tmp.expr.type)) {
                throw new SemanticError("Wrong Initialize", tmp.pos);
            }
        }
        if(temp.is_void()) throw new SemanticError("void var",tmp.pos);
        cur.New_Var(tmp.Identifier,new VarSymbol(tmp.Identifier,temp),tmp.pos);
//        tmp.thisscope = cur;
    }

    @Override
    public void visit(VarExprNode tmp) {
        tmp.thisscope = cur;
        tmp.var = cur.Get_Var(tmp.Name,true,tmp.pos);
        tmp.type = cur.Get_Var(tmp.Name,true,tmp.pos).type;
//        tmp.thisscope = cur;
    }
}
