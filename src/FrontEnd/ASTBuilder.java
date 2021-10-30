package FrontEnd;

import AST.*;
import Parser.MxstarBaseVisitor;
import Parser.MxstarParser;
import Util.error.SemanticError;
import Util.error.SyntaxError;
import Util.position;

import java.util.ArrayList;

public class ASTBuilder extends MxstarBaseVisitor<ASTNode> {
    @Override public ASTNode visitProgram(MxstarParser.ProgramContext ctx) {
        ProgramNode rt = new ProgramNode(new position(ctx));
        boolean Main = false;
        for(int i=0;i<ctx.children.size();++i) {
            if(ctx.children.get(i) instanceof MxstarParser.ClassDeclarationStmtContext) {
                ClassDefNode ch = (ClassDefNode) visit(ctx.children.get(i));
                rt.program.add(ch);
                continue;
            }
            if(ctx.children.get(i) instanceof MxstarParser.VarDeclarationStmtContext) {
                varDefStatementNode ch = (varDefStatementNode) visit(ctx.children.get(i));
                rt.program.add(ch);
                continue;
            }
            if(ctx.children.get(i) instanceof MxstarParser.FunctionDefContext) {
                FuncDefNode ch = (FuncDefNode) visit(ctx.children.get(i));
                rt.program.add(ch);
                continue;
            }
        }
        return rt;
    }
    @Override public ASTNode visitClassDeclarationStmt(MxstarParser.ClassDeclarationStmtContext ctx) {
        ClassDefNode cur = new ClassDefNode(new position(ctx));
        cur.Classname=ctx.Identifier().getText();
        for(int i=0;i<ctx.children.size();++i) {
            if(ctx.children.get(i) instanceof MxstarParser.VarDeclarationStmtContext) {
                varDefStatementNode tmp = (varDefStatementNode) visit(ctx.children.get(i));
                cur.Vars.addAll(tmp.list);
                continue;
            }
            if(ctx.children.get(i) instanceof MxstarParser.FunctionDefContext) {
                FuncDefNode tmp = (FuncDefNode) visit(ctx.children.get(i));
                cur.Funcs.add(tmp);
                continue;
            }
            if(ctx.children.get(i) instanceof MxstarParser.ConstructorDefContext) {
                cur.Constructor = (FuncDefNode) visit(ctx.children.get(i));
                continue;
            }
        }
        return cur;
    }
    @Override public ASTNode visitConstructorDef(MxstarParser.ConstructorDefContext ctx){
        FuncDefNode cur= new FuncDefNode(new position(ctx));
        cur.Name = ctx.Identifier().getText();
        cur.return_type=null;
        cur.body = (SuiteStatementNode) visit(ctx.suite());
        return cur;
    }
    @Override public ASTNode visitFunctionDef(MxstarParser.FunctionDefContext ctx) {
        FuncDefNode cur = new FuncDefNode(new position(ctx));
        cur.body = (SuiteStatementNode) visit(ctx.suite());
        cur.Name = ctx.Identifier().getText();
        if(ctx.returnType()!=null)
        cur.return_type = (TypeNode) visit(ctx.returnType());
        else cur.return_type = null;
        if(ctx.functionParameterDef()!=null)
        cur.Paralist.addAll(((varDefStatementNode) visit(ctx.functionParameterDef())).list);
        else cur.Paralist = null;
        return cur;
    }
    @Override public ASTNode visitFunctionParameterDef(MxstarParser.FunctionParameterDefContext ctx) {
        varDefStatementNode cur = new varDefStatementNode(new position(ctx));
        for(int i=0;i<ctx.children.size();++i) {
            if(ctx.children.get(i) instanceof MxstarParser.SingleParameterContext) {
                cur.list.add((SinglevarDefStatementNode) visit(ctx.children.get(i)));
                continue;
            }
        }
        return cur;
    }
    @Override public ASTNode visitSingleParameter(MxstarParser.SingleParameterContext ctx) {
        TypeNode tmp = (TypeNode) visit(ctx.varType());
        SinglevarDefStatementNode cur = new SinglevarDefStatementNode(tmp,ctx.Identifier().getText(),null,new position(ctx));
        return cur;
    }
    @Override public ASTNode visitSuite(MxstarParser.SuiteContext ctx) {
        SuiteStatementNode cur = new SuiteStatementNode(new position(ctx));
        for(int i=0;i<ctx.children.size();++i) {
            if(ctx.children.get(i) instanceof MxstarParser.StatementContext) {
                StatementNode tmp = (StatementNode) visit(ctx.children.get(i));
                cur.Stmts.add(tmp);
                continue;
            }
        }
        return cur;
    }
    @Override public ASTNode visitExpressionList(MxstarParser.ExpressionListContext ctx) {
        ExprListNode cur = new ExprListNode(new position(ctx));
        for(int i=0;i<ctx.children.size();++i) {
            if(ctx.children.get(i) instanceof MxstarParser.ExpressionContext) {
                ExprNode tmp = (ExprNode) visit(ctx.children.get(i));
                cur.List.add(tmp);
                continue;
            }
        }
        return cur;
    }
    @Override public ASTNode visitVarDeclaration(MxstarParser.VarDeclarationContext ctx) {
        varDefStatementNode cur = new varDefStatementNode(new position(ctx));
        TypeNode tp = (TypeNode) visit(ctx.varType());
        for(int i=0;i<ctx.children.size();++i) {
            if(ctx.children.get(i) instanceof MxstarParser.SinglevarDeclarationContext) {
                SinglevarDefStatementNode tmp = (SinglevarDefStatementNode) visit(ctx.children.get(i));
                tmp.type = tp;
                cur.list.add(tmp);
                continue;
            }
        }
        return cur;
    }
    @Override public ASTNode visitVarDeclarationStmt(MxstarParser.VarDeclarationStmtContext ctx) {
        return (varDefStatementNode) visit(ctx.varDeclaration());
    }
    @Override public ASTNode visitSinglevarDeclaration(MxstarParser.SinglevarDeclarationContext ctx) {
        SinglevarDefStatementNode cur = new SinglevarDefStatementNode(null,ctx.Identifier().getText(),ctx.expression()==null?null:(ExprNode) visit(ctx.expression()),new position(ctx));
        return cur;
    }
    @Override public ASTNode visitSuitestmt(MxstarParser.SuitestmtContext ctx) {
        return (SuiteStatementNode) visit(ctx.suite());
    }
    @Override public ASTNode visitVarstmt(MxstarParser.VarstmtContext ctx) {
        return (varDefStatementNode) visit(ctx.varDeclarationStmt());
    }
    @Override public ASTNode visitIfstmt(MxstarParser.IfstmtContext ctx) {
        IfStatementNode cur = new IfStatementNode((ExprNode)visit(ctx.expression()),(StatementNode)visit(ctx.trueStmt),(StatementNode)visit(ctx.falseStmt),new position(ctx));
        return cur;
    }
    @Override public ASTNode visitReturnstmt(MxstarParser.ReturnstmtContext ctx) {
        ReturnStatementNode cur = new ReturnStatementNode(ctx.expression()==null?null:(ExprNode)visit(ctx.expression()),new position(ctx));
        return cur;
    }
    @Override public ASTNode visitExprstmt(MxstarParser.ExprstmtContext ctx) {
        ExprStatementNode cur = new ExprStatementNode(ctx.expression()==null?null:(ExprNode)visit(ctx.expression()),new position(ctx));
        return cur;
    }
    @Override public ASTNode visitForstmt(MxstarParser.ForstmtContext ctx) {
        ForStatementNode cur = new ForStatementNode(new position(ctx));
        cur.condition=ctx.s1==null?null:(ExprNode)visit(ctx.s1);
        cur.init=ctx.x1==null?null:(ExprNode) visit(ctx.x1);
        cur.incr=ctx.s2==null?null:(ExprNode) visit(ctx.s2);
        if(ctx.x0!=null) {
            varDefStatementNode nw = (varDefStatementNode) visit(ctx.x0);
            cur.initDef.addAll(nw.list);
        }
        cur.mainbody = (StatementNode) visit(ctx.statement());
        return cur;
    }
    @Override public ASTNode visitWhilestmt(MxstarParser.WhilestmtContext ctx) {
        return new WhileStatementNode((ExprNode)visit(ctx.expression()),(StatementNode)visit(ctx.statement()),new position(ctx));
    }
    @Override public ASTNode visitBreakstmt(MxstarParser.BreakstmtContext ctx) {
        return new BreakStatementNode(new position(ctx));
    }
    @Override public ASTNode visitContinuestmt(MxstarParser.ContinuestmtContext ctx) {
        return new ContinueStatementNode(new position(ctx));
    }
    @Override public ASTNode visitUnaryexpr(MxstarParser.UnaryexprContext ctx) {
        UnaryExprNode cur = new UnaryExprNode(new position(ctx));
        cur.a = (ExprNode) visit(ctx.expression());
        cur.op=ctx.unaryop().toString();
        return cur;
    }
    @Override public ASTNode visitFuncexpr(MxstarParser.FuncexprContext ctx) {
        FuncExprNode cur = new FuncExprNode(new position(ctx));
        cur.funcname = (ExprNode) visit(ctx.expression());
        cur.paras = (ExprListNode) visit(ctx.expressionList());
        if(cur.funcname instanceof MemberExprNode) {
            cur.funcname.assign=false;
            ((MemberExprNode) cur.funcname).is_a_function = true;
        }
        return cur;
    }
    @Override public ASTNode visitPrefixexpr(MxstarParser.PrefixexprContext ctx) {
        PrefixExprNode cur = new PrefixExprNode(new position(ctx));
        cur.op = cur.op;
        cur.a = (ExprNode) visit(ctx.expression());
        return cur;
    }
    @Override public ASTNode visitSubexpr(MxstarParser.SubexprContext ctx) {
        return visit(ctx.expression());
    }
    @Override public ASTNode visitErrorcreator(MxstarParser.ErrorcreatorContext ctx) {
        throw new SyntaxError("Wrong New expr",new position(ctx));
    }
    @Override public ASTNode visitArraycreator(MxstarParser.ArraycreatorContext ctx) {
        NewExprNode cur = new NewExprNode(new position(ctx));
        ctx.expression().forEach(x->cur.Exprlist.add((ExprNode) visit(x)));
        cur.tp = (TypeNode) visit(ctx.builtinType());
        cur.tp.dim = (ctx.children.size()-ctx.expression().size()-1)/2;
        return cur;
    }
    @Override public ASTNode visitBasiccreator(MxstarParser.BasiccreatorContext ctx) {
        NewExprNode cur = new NewExprNode(new position(ctx));
        cur.tp = (TypeNode) visit(ctx.builtinType());
        return cur;
    }
    @Override public ASTNode visitClasscreator(MxstarParser.ClasscreatorContext ctx) {
        NewExprNode cur = new NewExprNode(new position(ctx));
        cur.tp = (TypeNode)visit(ctx.builtinType());
        cur.tp.dim=0;
        return cur;
    }
    @Override public ASTNode visitNewexpr(MxstarParser.NewexprContext ctx) {
        return visit(ctx.creator());
    }
    @Override public ASTNode visitSuffixexpr(MxstarParser.SuffixexprContext ctx) {
        SuffixExprNode cur = new SuffixExprNode(new position(ctx));
        cur.op = cur.op;
        cur.a = (ExprNode) visit(ctx.expression());
        return cur;
    }
    @Override public ASTNode visitLambdaexpr(MxstarParser.LambdaexprContext ctx) {
        LambdaExprNode cur = new LambdaExprNode(new position(ctx));
        if(ctx.functionParameterDef()!=null)
            cur.ParaDef = (varDefStatementNode) visit(ctx.functionParameterDef());
        if(ctx.expressionList()!=null)
            cur.Funcall = (ExprListNode) visit(ctx.expressionList());
        cur.body = (SuiteStatementNode) visit(ctx.suite());
        return cur;
    }
    @Override public ASTNode visitBinaryexpr(MxstarParser.BinaryexprContext ctx) {
        BinaryExprNode cur=new BinaryExprNode(new position(ctx));
        cur.op=ctx.op.getText();
        cur.a=(ExprNode) visit(ctx.a);
        cur.b=(ExprNode) visit(ctx.b);
        return cur;
    }
    @Override public ASTNode visitArrexpr(MxstarParser.ArrexprContext ctx) {
        ArrayExprNode cur = new ArrayExprNode(new position(ctx));
        cur.Index = (ExprNode) visit(ctx.out);
        cur.Array = (ExprNode) visit(ctx.in);
        return cur;
    }
    @Override public ASTNode visitClassexpr(MxstarParser.ClassexprContext ctx) {
        MemberExprNode cur = new MemberExprNode(new position(ctx));
        cur.P=(ExprNode) visit(ctx.in);
        cur.S=(ExprNode) visit(ctx.out);
        return cur;
    }
    @Override public ASTNode visitReturnType(MxstarParser.ReturnTypeContext ctx) {
        if(ctx.varType()!=null) {return (TypeNode)visit(ctx.varType());}
        else return new TypeNode(ctx.Void().getText(),0,new position(ctx));
    }
    @Override public ASTNode visitVarType(MxstarParser.VarTypeContext ctx) {
        TypeNode tp = new TypeNode(ctx.builtinType().toString(), (ctx.getChildCount() - 1) / 2,new position(ctx));
        return tp;
    }
    @Override public ASTNode visitBuiltinType(MxstarParser.BuiltinTypeContext ctx) {
        TypeNode tp = new TypeNode(ctx.toString(), 0,new position(ctx));
        return tp;
    }
    @Override public ASTNode visitLiteralexpr(MxstarParser.LiteralexprContext ctx) {
        return visit(ctx.literal());
    }
    @Override public ASTNode visitLiteral(MxstarParser.LiteralContext ctx) {
        PrimaryExprNode cur = new PrimaryExprNode(new position(ctx));
        cur.Val=ctx.toString();
        if(ctx.DecimalInteger()!=null) {
            cur.tp=new TypeNode("Int",0,new position(ctx));
        }
        if(ctx.True()!=null||ctx.False()!=null) {
            cur.tp=new TypeNode("Bool",0,new position(ctx));
        }
        if(ctx.StringConstant()!=null) {
            cur.tp=new TypeNode("String",0,new position(ctx));
        }
        if(ctx.Null()!=null) {
            cur.tp=new TypeNode("Null",0,new position(ctx));
        }return cur;
    }
    @Override public ASTNode visitVarexpr(MxstarParser.VarexprContext ctx) {
        VarExprNode cur = new VarExprNode(new position(ctx));
        cur.Name=ctx.Identifier().getText();
        return cur;
    }
}




