//constrctor 有问题

package BackEnd;

import AST.*;
import Util.*;
import Util.error.SemanticError;

import javax.net.ssl.SSLException;
import java.awt.*;
import java.util.ArrayList;
import MIR.*;
import org.stringtemplate.v4.compiler.Bytecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IRBuilder implements ASTvisitor {
    public ClassType inClass=null;
    public BasicBlock curBlock;
    public IRFunction curFunc;
    public HashMap<ASTNode, operand> result;
    public HashMap<ASTNode, operand> address;
    public Stack<BasicBlock> break_Statement;
    public Stack<BasicBlock> continue_Statement;
    public IRModule Mod;
    public String Class_Name = null;
    public Scope global_scope;
    public String id_Func = null;
    public boolean is_in_Class = false;
    public HashMap<Type,BaseType> Type_to_IRType = new HashMap<>();
    public static BaseType void_ir = new NullType();
    public static BaseType bool_ir = new IntType(1);
    public static BaseType char_ir = new IntType(8);
    public static BaseType int_ir = new IntType(32);
    public static BaseType string_ir = new PointerType(char_ir);
    public static BaseType pointer_ir = new PointerType(char_ir);
    public boolean isreturned;
    public IRBuilder(Scope global_scope) {
        this.Mod = new IRModule();
        this.result = new HashMap<ASTNode,operand>();
        this.address = new HashMap<ASTNode,operand>();
        this.break_Statement = new Stack<BasicBlock>();
        this.continue_Statement = new Stack<BasicBlock>();
        this.global_scope = global_scope;
        for(Type type:global_scope.Types.values()) {
            if (type.is_void())
                Type_to_IRType.put(type, void_ir);
            else if (type.is_boolean())
                Type_to_IRType.put(type, bool_ir);
            else if (type.is_int())
                Type_to_IRType.put(type, int_ir);
            else if (type instanceof ClassType) {
                if (type.is_string())
                    Type_to_IRType.put(type, string_ir);
                else if(type instanceof ClassType)
                    Type_to_IRType.put(type, new IRClassType(((ClassType) type).identifier));
            }
        }
    }
    public BaseType trans_to_IRType(Type tp) {
        if(tp.is_null()) return new NullType();
        if(tp.is_int()) return int_ir;
        if(tp.is_string()) return string_ir;
        if(tp.is_boolean()) return bool_ir;
        if(tp.is_void()) return new NullType();
        if(tp instanceof ArrayType) {
            BaseType temp = trans_to_IRType(((ArrayType) tp).type);
            for(int i=0;i<((ArrayType) tp).dim;++i) temp = new PointerType(temp);
            return temp;
        }
        if(tp instanceof ClassType) {
//            System.out.println(((ClassType) tp).identifier);
//            ArrayList<BaseType> member = new ArrayList<>();
//            for(Map.Entry<String,VarSymbol> entry:((ClassType)tp).vars.entrySet()) {
//                VarSymbol tmp = entry.getValue();
//                member.add(trans_to_IRType(tmp.type));
////                System.out.println(tmp.identifier);
//            }
////            for(int i=0;i<((ClassType)tp).vars.size();++i) {
////                VarSymbol tmp = ((ClassType)tp).vars.get(i);
////                member.add(trans_to_IRType(tmp.type));
////            }
            BaseType temp = Type_to_IRType.get(tp);
            return new PointerType(temp);
        }
        else {
            assert false;
            return null;
        }
    }

    @Override
    public void visit(ProgramNode tmp) {
        //collect function
//        System.out.println(tmp.program.size());
        for(int i=0;i<tmp.program.size();++i) {
            ASTNode temp = tmp.program.get(i);
//            System.out.println("fuck");
            if(temp instanceof ClassDefNode) {

                ArrayList<BaseType> typelist = new ArrayList<>();

                for(int j=0;j<((ClassDefNode) temp).Vars.size();++j) {
                    Type Utiltp = global_scope.Get_Type(((ClassDefNode) temp).Vars.get(j).type);
                    typelist.add(trans_to_IRType(Utiltp));
                }
                IRClassType thisIRtp = new IRClassType(((ClassDefNode) temp).Classname,typelist);
                Mod.ClassMap.put(((ClassDefNode) temp).Classname,thisIRtp);
                if(((ClassDefNode) temp).Constructor!=null) {
                    ((ClassDefNode) temp).Constructor.return_type = null;
                    ((ClassDefNode) temp).Funcs.add(((ClassDefNode) temp).Constructor);
                }
                ((ClassDefNode) temp).Funcs.forEach(
                    funcnode -> {
//                        System.out.println(funcnode.Name);
                        FuncSymbol thisfunc = global_scope.Get_Func(((ClassDefNode) temp).Classname+"."+funcnode.Name, true, temp.pos);
//                        System.out.println(thisfunc.identifier);
                        ArrayList<Parameter> para_list = new ArrayList<>();
//                        System.out.println(global_scope.Types.containsKey(((ClassDefNode) temp).Classname));
                        para_list.add(new Parameter(trans_to_IRType(global_scope.Get_Type(((ClassDefNode) temp).Classname,true,temp.pos)),"this"));

                        thisfunc.paras.forEach(
                                thispara -> {
                                    para_list.add(new Parameter(trans_to_IRType(thispara.type), thispara.identifier));
                                }
                        );
//                        for(int j=0;j<thisfunc.paras.size();++j){
//                            VarSymbol thisVar = thisfunc.paras.get(j);
//
//                        }
                        IRFunction nwFunc =null;
                        if(!funcnode.Name.equals(((ClassDefNode) temp).Classname))
                        nwFunc = new IRFunction(((ClassDefNode) temp).Classname+"."+thisfunc.identifier, Mod, para_list, trans_to_IRType(thisfunc.type), false);
                        else
                        {
//                            System.out.println("fuck");
                            nwFunc = new IRFunction(((ClassDefNode) temp).Classname+"."+((ClassDefNode) temp).Classname, Mod, para_list,new NullType(), false);
                        }
                        curBlock = nwFunc.entry;
                        for (int j=0;j<para_list.size();++j) {
                            Parameter thispara = para_list.get(j);
                            register addrOfthispara = new LocalReg(thispara.id + "$addr", new PointerType(thispara.tp));
                            curBlock.addBack(new AllocaInst(thispara.tp, addrOfthispara, curBlock));
                            curBlock.addBack(new StoreInst(addrOfthispara, thispara, curBlock));
//                            assert thispara!=null;
                            if(j==0) nwFunc.thisptr = addrOfthispara;
                            else thisfunc.paras.get(j-1).address = addrOfthispara;
                            nwFunc.Table.put(thispara.id + "$addr",addrOfthispara);
                        }
                        Mod.addFunction(nwFunc);
                    }
                );
            }
            if(temp instanceof FuncDefNode) {
                FuncSymbol thisfunc = global_scope.Get_Func(((FuncDefNode) temp).Name,true,temp.pos);
                ArrayList<Parameter> para_list = new ArrayList<>();

                //System.out.println(thisfunc.identifier);
                thisfunc.paras.forEach(
                        thispara->{
                            para_list.add(new Parameter(trans_to_IRType(thispara.type),thispara.identifier));
                            //System.out.println(thispara.identifier);
                        }
                );
                IRFunction nwFunc = new IRFunction(thisfunc.identifier,Mod,para_list,trans_to_IRType(thisfunc.type),false);
                curBlock = nwFunc.entry;
                for (int j=0;j<para_list.size();++j) {
                    Parameter thispara = para_list.get(j);
                    register addrOfthispara = new LocalReg(thispara.id+"$addr",new PointerType(thispara.tp));
                    curBlock.addBack(new AllocaInst(thispara.tp,addrOfthispara,curBlock));
                    curBlock.addBack(new StoreInst(addrOfthispara,thispara,curBlock));
//                    System.out.println(thispara.toString());
                    assert thispara!=null;
                    //System.out.println(nwFunc.id);
                   // System.out.println(thispara.id+"$addr");
                    nwFunc.Table.put(thispara.id+"$addr",addrOfthispara);

                    thisfunc.paras.get(j).address = addrOfthispara;
                }
//                System.out.println(nwFunc.id);
                Mod.addFunction(nwFunc);
            }
        }
        //return ;
        IRFunction init = Mod.Funcs.get("_init_");
        curFunc = init;
        curBlock = init.entry;
        for(int i=0;i<tmp.program.size();++i) {
            if((tmp.program.get(i) instanceof varDefStatementNode)||(tmp.program.get(i) instanceof SinglevarDefStatementNode))
            tmp.program.get(i).accept(this);
        }
        curFunc.finish();
        curFunc = null;
        curBlock = null;
        for(int i=0;i<tmp.program.size();++i) {
            if(tmp.program.get(i) instanceof ClassDefNode)
                tmp.program.get(i).accept(this);
        }
        for(int i=0;i<tmp.program.size();++i) {
            if(tmp.program.get(i) instanceof FuncDefNode)
                tmp.program.get(i).accept(this);
        }
    }

    @Override
    public void visit(ClassDefNode tmp) {

        is_in_Class = true;
        Class_Name = tmp.Classname;
        //tmp.Vars.forEach(x->x.accept(this));
        tmp.Funcs.forEach(x->x.accept(this));
        Class_Name = null;
//        if(tmp.Constructor!=null) {
//            tmp.Constructor.accept(this);
//        }
        is_in_Class = false;
    }

    @Override
    public void visit(ThisExprNode tmp) {
        register addr = (register) curFunc.Table.get("this$addr");
        BaseType tp = ((PointerType) addr.tp).tp;
        register res = new LocalReg("this",tp);
        curBlock.addBack(new LoadInst(tp,res,addr,curBlock));
//        curFunc.Table.put(res.id,res);
        result.put(tmp,res);
        address.put(tmp,null);
    }

    @Override
    public void visit(FuncDefNode tmp) {
        id_Func = tmp.Name;
//        System.out.println(Mod.Funcs.containsKey(tmp.Name));
        IRFunction thisfunc;
        if(!is_in_Class) thisfunc = Mod.Funcs.get(tmp.Name);
        else thisfunc = Mod.Funcs.get(Class_Name+"."+tmp.Name);
        curFunc = thisfunc;

        curBlock = thisfunc.entry;
        isreturned = false;
        tmp.body.accept(this);

//        tmp.
        if(tmp.return_type!=null&&(!tmp.return_type.typename.equals("void"))&&!isreturned) {
//            assert curFunc.retval_addr!=null;
            //System.out.println("fuck");
            curBlock.addBack(new StoreInst(curFunc.retval_addr,new IntConst(0,new IntType(32)),curBlock));
        }
        isreturned = false;
        if(tmp.Name.equals("main")) {
            IRFunction init = Mod.Funcs.get("_init_");
            curFunc.entry.addFront(new CallFuncInst(init,null,new ArrayList<>(),init.entry));
        }
        curFunc.finish();
        curBlock = null;
        curFunc = null;
        id_Func = null;
    }

    @Override
    public void visit(DEFNode tmp) {
        return;
    }

    @Override
    public void visit(TypeNode tmp) {
        return;
    }

    @Override
    public void visit(ContinueStatementNode tmp) {
        curBlock.addBack(new BranchInst(continue_Statement.peek(),null,null,curBlock));
        BasicBlock nwBlock = new BasicBlock(curFunc,"aftercontinue");
        curFunc.addBlock(nwBlock);
        curBlock = nwBlock;
        return ;
    }

    @Override
    public void visit(varDefStatementNode tmp) {
        tmp.list.forEach(x->x.accept(this));
        return ;
    }

    @Override
    public void visit(ReturnStatementNode tmp) {
        isreturned = true;
        if(tmp.Val!=null) {
            tmp.Val.accept(this);
            operand res = result.get(tmp.Val);
//            assert(curFunc.retval_addr!=null);
//            System.out.println(curFunc.retval_addr);

            curBlock.addBack(new StoreInst(curFunc.retval_addr,res,curBlock));
            assert res!=null;
        }
        curBlock.addBack(new BranchInst(curFunc.ret,null,null,curBlock));
        BasicBlock nwBlock = new BasicBlock(curFunc,"afterreturn");
        curFunc.addBlock(nwBlock);
        curBlock = nwBlock;
    }

    @Override
    public void visit(WhileStatementNode tmp) {
        BasicBlock whilebody = new BasicBlock(curFunc,"whilebody");
        BasicBlock whilecond = new BasicBlock(curFunc,"whilecond");
        BasicBlock nxtblock = new BasicBlock(curFunc,"nxtBlock");
        curBlock.addBack(new BranchInst(whilecond,null,null,curBlock));
        curFunc.addBlock(whilecond);curBlock = whilecond;
        tmp.condition.accept(this);
        operand res = result.get(tmp.condition);
        curBlock.addBack(new BranchInst(whilebody,nxtblock,res,curBlock));
        curFunc.addBlock(whilebody);curBlock = whilebody;
        break_Statement.addElement(nxtblock);
        continue_Statement.addElement(whilecond);
        if(tmp.mainbody!=null)
        tmp.mainbody.accept(this);
        break_Statement.pop();
        continue_Statement.pop();
        curBlock.addBack(new BranchInst(whilecond,null,null,curBlock));

        curBlock = nxtblock;
        curFunc.addBlock(nxtblock);
        return ;
    }

    @Override
    public void visit(SuiteStatementNode tmp) {
        tmp.Stmts.forEach(x->x.accept(this));
        return ;
    }

    @Override
    public void visit(BreakStatementNode tmp) {
        curBlock.addBack(new BranchInst(break_Statement.peek(),null,null,curBlock));
        BasicBlock nwBlock = new BasicBlock(curFunc,"afterBreak");
        curFunc.addBlock(nwBlock);
        curBlock = nwBlock;
        return ;
    }

    @Override
    public void visit(ExprStatementNode tmp) {
//        tmp.
        if(tmp.expr!=null)
        tmp.expr.accept(this);
        return ;
    }

    @Override
    public void visit(ForStatementNode tmp) {
        BasicBlock _init = new BasicBlock(curFunc,"InitBlock");
        BasicBlock _cond = new BasicBlock(curFunc,"CondBlock");
        BasicBlock _incr = new BasicBlock(curFunc,"IncrBlock");
        BasicBlock _body = new BasicBlock(curFunc,"BodyBlock");
        BasicBlock _nxt = new BasicBlock(curFunc,"nxtBlock");
        curBlock.addBack(new BranchInst(_init,null,null,curBlock));
        curFunc.addBlock(_init);curBlock = _init;
        if(tmp.init!=null) {
            tmp.init.accept(this);
        }
        curBlock.addBack(new BranchInst(_cond,null,null,curBlock));
        curFunc.addBlock(_cond);curBlock = _cond;
        operand res = new BoolConst(true,new IntType(1));
        if(tmp.condition!=null) {
            tmp.condition.accept(this);
            res = result.get(tmp.condition);
        }
//        operand res = result.get(tmp.condition);
        curBlock.addBack(new BranchInst(_body,_nxt,res,curBlock));
        curFunc.addBlock(_body);curBlock = _body;
        break_Statement.addElement(_nxt);
        continue_Statement.addElement(_incr);
        if(tmp.mainbody!=null) {
            tmp.mainbody.accept(this);
        }
        break_Statement.pop();
        continue_Statement.pop();
        curBlock.addBack(new BranchInst(_incr,null,null,curBlock));
        curFunc.addBlock(_incr);curBlock = _incr;
        if(tmp.incr!=null) {
            tmp.incr.accept(this);
        }
        curBlock.addBack(new BranchInst(_cond,null,null,curBlock));

        curBlock = _nxt;
        curFunc.addBlock(_nxt);
        return;
    }

    @Override
    public void visit(PrimaryExprNode tmp) {
        if(tmp.tp.typename.equals("int")) {
            result.put(tmp,new IntConst(Integer.parseInt(tmp.Val),new IntType(32)));
            address.put(tmp,null);
        }
        else if(tmp.tp.typename.equals("bool")) {
            result.put(tmp,new BoolConst(Boolean.parseBoolean(tmp.Val),new IntType(1)));
            address.put(tmp,null);
        }
        else if(tmp.tp.typename.equals("null")) {
            result.put(tmp,new NullConst(new NullType()));
            address.put(tmp,null);
        }
        else if(tmp.tp.typename.equals("string")) {
            GlobalReg str = Mod.addStringConst(tmp.Val);
            ArrayList<operand> index = new ArrayList<>();
            index.add(new IntConst(0,new IntType(32)));
            index.add(new IntConst(0,new IntType(32)));
            register res = new LocalReg("StringConst",string_ir);
            curBlock.addBack(new GetElementPtrInst(str,res,index,curBlock));
            result.put(tmp,res);
            address.put(tmp,null);
        }
    }

    @Override
    public void visit(IfStatementNode tmp) {
        BasicBlock block1 = new BasicBlock(curFunc,"thenBlock");
        BasicBlock block2 = new BasicBlock(curFunc,"elseBlock");
        BasicBlock nxtblock = new BasicBlock(curFunc,"nxtBlock");
        assert tmp.condition!=null;
        tmp.condition.accept(this);

        operand res = result.get(tmp.condition);
//        System.out.println(res.toString());
        curBlock.addBack(new BranchInst(block1,block2,res,curBlock));
        curBlock = block1;curFunc.addBlock(block1);
        if(tmp.thenStmt!=null)
        tmp.thenStmt.accept(this);
        curBlock.addBack(new BranchInst(nxtblock,null,null,curBlock));
        curBlock = block2;curFunc.addBlock(block2);
        if(tmp.elseStmt!=null)
        tmp.elseStmt.accept(this);
        curBlock.addBack(new BranchInst(nxtblock,null,null,curBlock));
        curBlock = nxtblock;
        curFunc.addBlock(nxtblock);
        return;
    }

    @Override
    public void visit(SuffixExprNode tmp) {
//        System.out.println("fuck");
        tmp.a.accept(this);
        operand Son_res = result.get(tmp.a);
        operand Son_addr = address.get(tmp.a);
        operand res = new LocalReg("res",trans_to_IRType(tmp.type));
        if(tmp.op.equals("++")) {
//            System.out.println("Fuck");
            if(Son_res ==null) {
                throw new SemanticError("Strange operand of ++",tmp.pos);
            }
            else {
                curBlock.addBack(new BinaryInst(BinaryInst.OpType.add,Son_res,new IntConst(1,new IntType(32)),curBlock,(register) res));
                curBlock.addBack(new StoreInst(Son_addr,(register) res,curBlock));
                assert res!=null;
            }
        }
        else if(tmp.op.equals("--")){
            if(Son_res ==null) {
                throw new SemanticError("Strange operand of --",tmp.pos);
            }
            else {
                curBlock.addBack(new BinaryInst(BinaryInst.OpType.sub,Son_res,new IntConst(1,new IntType(32)),curBlock,(register) res));
                curBlock.addBack(new StoreInst(Son_addr,(register) res,curBlock));
                assert res!=null;
            }
        }
        else throw new SemanticError("Unknown Suffix Operator",tmp.pos);
        result.put(tmp,Son_res);
        address.put(tmp,null);
    }

    @Override
    public void visit(PrefixExprNode tmp) {
//        System.out.println("FUCK");
        tmp.a.accept(this);
        operand Son_res = result.get(tmp.a);
        operand Son_addr = address.get(tmp.a);
        operand res = new LocalReg("res",trans_to_IRType(tmp.type));
//        operand res_addr = new LocalReg()
        if(tmp.op.equals("++")) {
            if(Son_addr == null) {
                throw new SemanticError("Strange operand of ++",tmp.pos);
            }
            else {
                curBlock.addBack(new BinaryInst(BinaryInst.OpType.add,Son_res,new IntConst(1,new IntType(32)),curBlock,(register) res));
                curBlock.addBack(new StoreInst(Son_addr,(register) res,curBlock));
                assert res!=null;
            }
        }
        else if(tmp.op.equals("--")){
            if(Son_res ==null) {
                throw new SemanticError("Strange operand of --",tmp.pos);
            }
            else {
                curBlock.addBack(new BinaryInst(BinaryInst.OpType.sub,Son_res,new IntConst(1,new IntType(32)),curBlock,(register) res));
                curBlock.addBack(new StoreInst(Son_addr,(register) res,curBlock));
                assert res!=null;
            }
        }
        else throw new SemanticError("Unknown Suffix Operator",tmp.pos);
        result.put(tmp,res);
        address.put(tmp,null);
    }

    @Override
    public void visit(MemberExprNode tmp) {
        tmp.P.accept(this);
        if(global_scope.Funcs.containsKey(tmp.S)) {
            return ;
        }
        operand ptr = result.get(tmp.P);
        assert tmp.P.type instanceof ClassType;
        ClassType tp = (ClassType) tmp.P.type;
        ArrayList<operand> index = new ArrayList<>();
        index.add(new IntConst(0,new IntType(32)));
        index.add(new IntConst(tp.mapping.get(tmp.S),new IntType(32)));
        register temp = new LocalReg("Member$addr",new PointerType(trans_to_IRType(tmp.type)));
        register res = new LocalReg("Member",trans_to_IRType(tmp.type));
        curBlock.addBack(new GetElementPtrInst(ptr,temp,index,curBlock));
        curBlock.addBack(new LoadInst(trans_to_IRType(tmp.type),res,temp,curBlock));
        result.put(tmp,res);
        address.put(tmp,temp);
    }

    @Override
    public void visit(LambdaExprNode tmp) {
        return ;
    }

    @Override
    public void visit(BinaryExprNode tmp) {
        boolean flag = tmp.op.equals("&&") || tmp.op.equals("||");
        if(flag) {
            tmp.a.accept(this);
            operand loperand = result.get(tmp.a);
            operand laddr = address.get(tmp.a);
            operand roperand = null;
            operand res = new LocalReg("result",trans_to_IRType(tmp.type));
            if(tmp.op.equals("||")) {
                if(loperand instanceof BoolConst) {
                    if(((BoolConst)  loperand).val) {
                        res = new BoolConst(true,new IntType(1));
                    }
                    else {
                        tmp.b.accept(this);
                        roperand = result.get(tmp.b);
                        res = roperand;
                    }
                }
                else {
                    BasicBlock Block1 = new BasicBlock(curFunc,"CalcBlock");
                    BasicBlock Block2 = new BasicBlock(curFunc,"MergeBlock");
                    BasicBlock former = curBlock;
                    curFunc.addBlock(Block1);
                    curFunc.addBlock(Block2);
                    curBlock.addBack(new BranchInst(Block2,Block1,loperand,curBlock));
                    curBlock = Block1;
                    tmp.b.accept(this);
                    roperand = result.get(tmp.b);
                    curBlock.addBack(new BranchInst(Block2,null,null,curBlock));
                    curBlock = Block2;
                    ArrayList<BasicBlock> Blocklist = new ArrayList<>();
                    ArrayList<operand> Vallist = new ArrayList<>();
                    Blocklist.add(former);Blocklist.add(Block1);
                    Vallist.add(new BoolConst(true,new IntType(1)));Vallist.add(roperand);
                    curBlock.addBack(new PhiInst((register) res,Blocklist,Vallist,curBlock));

                }
            }
            else if(tmp.op.equals("&&")) {
                if(loperand instanceof BoolConst) {
                    if(!((BoolConst)  loperand).val) {
                        res = new BoolConst(false,new IntType(1));
                    }
                    else {
                        tmp.b.accept(this);
                        roperand = result.get(tmp.b);
                        res = roperand;
                    }
                }
                else {
                    BasicBlock Block1 = new BasicBlock(curFunc,"CalcBlock");
                    BasicBlock Block2 = new BasicBlock(curFunc,"MergeBlock");
                    BasicBlock former = curBlock;
                    curFunc.addBlock(Block1);
                    curFunc.addBlock(Block2);
                    curBlock.addBack(new BranchInst(Block1,Block2,loperand,curBlock));
                    curBlock = Block1;
                    tmp.b.accept(this);
                    roperand = result.get(tmp.b);
                    curBlock.addBack(new BranchInst(Block2,null,null,curBlock));
                    curBlock = Block2;
                    ArrayList<BasicBlock> Blocklist = new ArrayList<>();
                    ArrayList<operand> Vallist = new ArrayList<>();
                    Blocklist.add(former);Blocklist.add(Block1);
                    Vallist.add(new BoolConst(false,new IntType(1)));Vallist.add(roperand);
                    curBlock.addBack(new PhiInst((register) res,Blocklist,Vallist,curBlock));
                }
            }
            else throw new SemanticError("InValid operator",tmp.pos);
            result.put(tmp,res);
            address.put(tmp,null);
        }
        else {
            tmp.a.accept(this);
            tmp.b.accept(this);//System.out.println(result.containsKey(tmp.b));
            operand loperand = result.get(tmp.a);
            operand laddr = address.get(tmp.a);

            operand roperand = result.get(tmp.b);
            operand res = new LocalReg("result",trans_to_IRType(tmp.type));

            operand res_addr = null;
            switch (tmp.op) {
                case "+":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()) {
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_str_add");
//                        System.out.println(((LocalReg)res).No);
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.add,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "-":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.sub,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "*":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.mul,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "/":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.sdiv,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "%":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.srem,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "<<":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.shl,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case ">>":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.ashr,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "<":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()) {
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_string_lt");
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.slt,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    break;
                }
                case "<=":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()) {
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_string_le");
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.sle,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    break;
                }
                case ">":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()) {
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_string_gt");
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.sgt,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    break;
                }
                case ">=":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()) {
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_string_ge");
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.sge,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    break;
                }
                case "==":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()){
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_string_eq");
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else if(tmp.a.type.is_int()&&tmp.b.type.is_int()) {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.eq,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    else if(tmp.a.type.is_boolean()&&tmp.b.type.is_boolean()) {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.eq,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    else if(tmp.a.type.is_null()&&tmp.b.type.is_null()) {
                        res = new BoolConst(true,new IntType(1));
                    }
                    else {
                        BaseType tp = loperand.tp;
                        if(!tmp.a.type.is_null()) tp = loperand.tp;
                        else if(!tmp.b.type.is_null()) tp = roperand.tp;
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.eq,loperand,roperand,(register) res,tp,curBlock));
                    }
                    break;
                }
                case "!=":{
                    if(tmp.a.type.is_string()&&tmp.b.type.is_string()){
                        IRFunction thisfunc = Mod.Sys_Funcs.get("mx_string_ne");
                        ArrayList<operand> paras = new ArrayList<>();
                        paras.add(loperand);
                        paras.add(roperand);
                        curBlock.addBack(new CallFuncInst(thisfunc,(register) res,paras,curBlock));
                    }
                    else if(tmp.a.type.is_int()&&tmp.b.type.is_int()) {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.ne,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    else if(tmp.a.type.is_boolean()&&tmp.b.type.is_boolean()) {
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.ne,loperand,roperand,(register) res,new IntType(32),curBlock));
                    }
                    else if(tmp.a.type.is_null()&&tmp.b.type.is_null()) {
                        res = new BoolConst(false,new IntType(1));
                    }
                    else {
                        BaseType tp = loperand.tp;
                        if(!tmp.a.type.is_null()) tp = loperand.tp;
                        else if(!tmp.b.type.is_null()) tp = roperand.tp;
                        curBlock.addBack(new CmpInst(CmpInst.CmpType.ne,loperand,roperand,(register) res,tp,curBlock));
                    }
                    break;
                }
                case "&":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.and,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "^":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.xor,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "|":{
                    curBlock.addBack(new BinaryInst(BinaryInst.OpType.or,loperand,roperand,curBlock,(register) res));
                    break;
                }
                case "=":{

                    res_addr = laddr;
                    res = roperand;//System.out.println(res_addr.toString());
                    curBlock.addBack(new StoreInst(res_addr,res,curBlock));
                    assert res!=null;
                    break;
                }
                default:
                {
                    throw new SemanticError("Invalid operator",tmp.pos);
//                    break;
                }
            }
            result.put(tmp,res);
            address.put(tmp,res_addr);
        }
    }

    @Override
    public void visit(UnaryExprNode tmp) {
        tmp.a.accept(this);
        operand Son_res = result.get(tmp.a);
        operand Son_addr = address.get(tmp.a);
        operand res = new LocalReg("res",trans_to_IRType(tmp.type));
        if(tmp.op.equals("+")) {
            curBlock.addBack(new BinaryInst(BinaryInst.OpType.add,Son_res,new IntConst(0,new IntType(32)),curBlock,(register) res));
//            curBlock.addBack(new StoreInst(Son_addr,(register) res,curBlock));
        }
        else if(tmp.op.equals("-")){
//            if(Son_res instanceof IntConst) {
//                throw new SemanticError("Strange operand of --",tmp.pos);
//            }
//            else {
            curBlock.addBack(new BinaryInst(BinaryInst.OpType.sub,new IntConst(0,new IntType(32)),Son_res,curBlock,(register) res));
//            curBlock.addBack(new StoreInst(Son_addr,(register) res,curBlock));
//            }
        }
        else if(tmp.op.equals("!")){
            curBlock.addBack(new BinaryInst(BinaryInst.OpType.xor,new BoolConst(true,new IntType(1)),Son_res,curBlock,(register) res));
        }
        else if(tmp.op.equals("~")){
            curBlock.addBack(new BinaryInst(BinaryInst.OpType.xor,new IntConst(-1,new IntType(32)),Son_res,curBlock,(register) res));
        }
        else throw new SemanticError("Unknown Unary Operator",tmp.pos);
        result.put(tmp,res);
        address.put(tmp,null);
        return ;
    }

    @Override
    public void visit(StatementNode tmp) {
        return ;
    }

    @Override
    public void visit(ArrayExprNode tmp) {
        tmp.Array.accept(this);
        tmp.Index.accept(this);
        register ptr = (register) result.get(tmp.Array);
        operand index = result.get(tmp.Index);
        BaseType tp = trans_to_IRType(tmp.type);
        register res$addr = new LocalReg("element$addr",new PointerType(tp));
        ArrayList<operand> Index = new ArrayList<>();
//        Index.add(new IntConst(0,new IntType(4)));
        Index.add(index);
        curBlock.addBack(new GetElementPtrInst(ptr,res$addr,Index,curBlock));
        register res = new LocalReg("element",tp);
        curBlock.addBack(new LoadInst(tp,res,res$addr,curBlock));
        result.put(tmp,res);
        address.put(tmp,res$addr);
    }

    @Override
    public void visit(FuncExprNode tmp) {
        if(tmp.funcname instanceof VarExprNode) {
            FuncSymbol thisfunc = (FuncSymbol) tmp.funcname.type;
            ArrayList<operand> paras = new ArrayList<>();
            IRFunction thisirfunc = null;
//            System.out.println(((VarExprNode) tmp.funcname).Name);
            if(Mod.Funcs.containsKey(((VarExprNode) tmp.funcname).Name))
            thisirfunc = Mod.Funcs.get(((VarExprNode) tmp.funcname).Name);
            else {
                //System.out.println(tmp.funcname);
                thisirfunc = Mod.Sys_Funcs.get("mx_"+((VarExprNode) tmp.funcname).Name);
            }
            if(is_in_Class&&thisirfunc==null) {
//                System.out.println(((VarExprNode) tmp.funcname).Name);
                thisirfunc = Mod.Funcs.get(Class_Name+"."+((VarExprNode) tmp.funcname).Name);
                register addr = (register) curFunc.Table.get("this$addr");
//                System.out.println(thisirfunc.id);
//                System
                BaseType tp = ((PointerType)addr.tp).tp;
                register thisptr = new LocalReg("this",tp);
                curBlock.addBack(new LoadInst(tp,thisptr,addr,curBlock));
                paras.add(thisptr);
            }
            tmp.paras.forEach(
                    x-> {
                        x.accept(this);
                        paras.add(result.get(x));
                    }

            );
            BaseType rettp = thisirfunc.functp.ret_tp;
            register res = new LocalReg("result",rettp);
            curBlock.addBack(new CallFuncInst(thisirfunc,res,paras,curBlock));
            result.put(tmp,res);
            address.put(tmp,null);
        }
        else if(tmp.funcname instanceof MemberExprNode){
            ((MemberExprNode) tmp.funcname).P.accept(this);
            operand ptr = result.get(((MemberExprNode) tmp.funcname).P);
            Type tp = ((MemberExprNode) tmp.funcname).P.type;
            if(tp instanceof ArrayType) {
//                System.out.println(tp.toString());
                if(!((MemberExprNode)tmp.funcname).S.equals("size")) assert false;
                register ArraySizePtr = new LocalReg("ArraySizePtr",new PointerType(int_ir));
                register ptr_int = new LocalReg("ptr_int",new PointerType(int_ir));
                register ArraySize = new LocalReg("ArraySize",int_ir);
                ArrayList<operand> index = new ArrayList<>();
                index.add(new IntConst(-1,int_ir));
                curBlock.addBack(new BitCastInst(new PointerType(int_ir),ptr_int,ptr,curBlock));
                curBlock.addBack(new GetElementPtrInst(ptr_int,ArraySizePtr,index,curBlock));
                //curBlock.addBack(new BitCastInst());
                curBlock.addBack(new LoadInst(int_ir,ArraySize,ArraySizePtr,curBlock));
                result.put(tmp,ArraySize);
                address.put(tmp,null);
            }
            else {
                IRFunction thisirfunc;
                if(tp.is_string()) thisirfunc = Mod.Sys_Funcs.get("mx_string_"+((MemberExprNode) tmp.funcname).S);
                else thisirfunc = Mod.Funcs.get(((ClassType)tp).identifier+"."+((MemberExprNode) tmp.funcname).S);
                //System.out.println(thisirfunc.id);
                ArrayList<operand> paras = new ArrayList<>();
                paras.add(ptr);
                BaseType ret_tp = thisirfunc.functp.ret_tp;
                register res = (ret_tp instanceof NullType)?null:new LocalReg("result",ret_tp);
                tmp.paras.forEach(
                        x -> {
                            x.accept(this);
                            paras.add(result.get(x));
                        }
                );
                curBlock.addBack(new CallFuncInst(thisirfunc,res,paras,curBlock));
                result.put(tmp,res);
                address.put(tmp,null);
            }
        }
    }
    public register GenArray (int step,ArrayList<operand> sizes,BaseType tp) {
        operand len = sizes.get(step);
        register mallocsize = new LocalReg("MallocSize",new IntType(32));
        register tmpsize = new LocalReg("tmpSize",new IntType(32));
        curBlock.addBack(new BinaryInst(BinaryInst.OpType.mul,new IntConst(((PointerType)tp).size(),new IntType(32)),len,curBlock,tmpsize));
        curBlock.addBack(new BinaryInst(BinaryInst.OpType.add,new IntConst(4,int_ir),tmpsize,curBlock,mallocsize));
        IRFunction malloc_func = Mod.Sys_Funcs.get("mx_malloc");
        ArrayList<operand> size = new ArrayList<>();
        size.add(mallocsize);
        register malloc_ptr = new LocalReg("MallocPtr",pointer_ir);
        curBlock.addBack(new CallFuncInst(malloc_func,malloc_ptr,size,curBlock));
        register malloc_ptr_int = new LocalReg("MallocPtrInt",new PointerType(int_ir));
        curBlock.addBack(new BitCastInst(new PointerType(int_ir),malloc_ptr_int,malloc_ptr,curBlock));
        curBlock.addBack(new StoreInst(malloc_ptr_int,len,curBlock));
        assert len!=null;
        register this_Array_begin = new LocalReg("this_Array_begin",tp);
        register this_Array_begin_int = new LocalReg("this_Array_begin_int",new PointerType(int_ir));
        ArrayList<operand> index = new ArrayList<>();index.add(new IntConst(1,int_ir));
        curBlock.addBack(new GetElementPtrInst(malloc_ptr_int,this_Array_begin_int,index,curBlock));
        curBlock.addBack(new BitCastInst(tp,this_Array_begin,this_Array_begin_int,curBlock));
        if(step<sizes.size()-1) {

            register this_Array_end = new LocalReg("this_Array_end",tp);
            ArrayList<operand> offset = new ArrayList<>();offset.add(len);
            curBlock.addBack(new GetElementPtrInst(this_Array_begin,this_Array_end,offset,curBlock));//System.out.println(len.toString());
            register it = new LocalReg("it",tp);
            register it_addr = new LocalReg("it_addr",new PointerType(tp));
            curFunc.entry.addFront(new AllocaInst(tp,it_addr,curFunc.entry));
            curBlock.addBack(new StoreInst(it_addr,this_Array_begin,curBlock));
            assert this_Array_begin!=null;
            BasicBlock cond = new BasicBlock(curFunc,"condBlock");
            BasicBlock body = new BasicBlock(curFunc,"bodyBlock");
            BasicBlock merge = new BasicBlock(curFunc,"mergeBlock");
            curBlock.addBack(new BranchInst(cond,null,null,curBlock));
            curBlock = cond;curFunc.addBlock(cond);
            curBlock.addBack(new LoadInst(tp,it,it_addr,curBlock));
            register res = new LocalReg("icmp_res",bool_ir);
            curBlock.addBack(new CmpInst(CmpInst.CmpType.ne,this_Array_end,it,res,tp,curBlock));
            curBlock.addBack(new BranchInst(body,merge,res,curBlock));
            curBlock = body;curFunc.addBlock(body);
            register nxtlevel = GenArray(step+1,sizes,((PointerType) tp).tp);
            curBlock.addBack(new StoreInst(it,nxtlevel,curBlock));
            assert nxtlevel!=null;
            offset = new ArrayList<>();offset.add(new IntConst(1,int_ir));
            register nxt_it = new LocalReg("nxt_it",tp);
            curBlock.addBack(new GetElementPtrInst(it,nxt_it,offset,curBlock));
            curBlock.addBack(new StoreInst(it_addr,nxt_it,curBlock));
            assert nxt_it!=null;
            curBlock.addBack(new BranchInst(cond,null,null,curBlock));
            curBlock = merge;curFunc.addBlock(merge);
        }
        return this_Array_begin;
    }
    @Override
    public void visit(NewExprNode tmp) {
        register res;
        if(tmp.type instanceof ArrayType) {
            ArrayList<operand> Size = new ArrayList<>();
            tmp.Exprlist.forEach(
                    x->{
                        x.accept(this);
                        Size.add(result.get(x));
                    }
            );
            res = GenArray(0,Size,trans_to_IRType(tmp.type));
        }
        else if(tmp.type instanceof ClassType) {
            IRFunction Malloc = Mod.Sys_Funcs.get("mx_malloc");
            ArrayList<operand> size = new ArrayList<>();
            register temp = new LocalReg("MallocPtr",pointer_ir);
            BaseType tp = Mod.ClassMap.get(((ClassType) tmp.type).identifier);
            size.add(new IntConst(((IRClassType)tp).CalcSize(),new IntType(32)));
            //System.out.println(((IRClassType)tp).CalcSize());
            curBlock.addBack(new CallFuncInst(Malloc,temp,size,curBlock));
            res = new LocalReg("class$addr", trans_to_IRType(tmp.type));
            curBlock.addBack(new BitCastInst(trans_to_IRType(tmp.type),res,temp,curBlock));

            if(Mod.Funcs.containsKey(((ClassType) tmp.type).identifier+"."+((ClassType) tmp.type).identifier)) {
                ArrayList<operand> paras = new ArrayList<>();
                paras.add(res);
                curBlock.addBack(new CallFuncInst(Mod.Funcs.get(((ClassType) tmp.type).identifier+"."+((ClassType) tmp.type).identifier),null,paras,curBlock));
//                assert false;
            }
        }
        else throw new SemanticError("Invalid Types of New Expr",tmp.pos);
        result.put(tmp,res);
        address.put(tmp,null);
    }

    @Override
    public void visit(ASTNode tmp) {
        return ;
    }

    @Override
    public void visit(ExprListNode tmp) {
//        tmp.List.forEach(x->x.accept(this));
        return ;
    }

    @Override
    public void visit(SinglevarDefStatementNode tmp) {
        Type tp = global_scope.Get_Type(tmp.type);
        BaseType tp_ir = trans_to_IRType(tp);
//        System.out.println(tmp.Identifier);
        if(id_Func != null) {
            LocalReg addr = new LocalReg(tmp.Identifier,new PointerType(tp_ir),false);
//            System.out.println(id_Func);
            curFunc.entry.addFront(new AllocaInst(tp_ir,addr,curFunc.entry));
            operand val;
            val = tp_ir.defaultval();
            if(tmp.expr!=null) {
                tmp.expr.accept(this);
                val = result.get(tmp.expr);
            }
            curBlock.addBack(new StoreInst(addr,val,curBlock));
            assert val!=null;
            VarSymbol _thisvar = tmp.thisscope.Get_Var(tmp.Identifier,true,tmp.pos);
            _thisvar.address = addr;
//            System.out.println(_thisvar.address!=null);
        }
        else if(!is_in_Class){
//            System.out.println(tmp.Identifier);
            GlobalReg addr = new GlobalReg(null,null,tmp.Identifier,new PointerType(tp_ir));
//            GlobalReg addr = new GlobalReg(null,null,tmp.Identifier,tp_ir);
            operand val;
            val = tp_ir.defaultval();
            if(tmp.expr!=null) {
                tmp.expr.accept(this);
                val = result.get(tmp.expr);
                if(!(val instanceof Const)) {
//                    System.out.println("fuck");
                    curBlock.addBack(new StoreInst(addr,val,curBlock));
                    assert val!=null;
                    val = tp_ir.defaultval();
                }
                else val = result.get(tmp.expr);
            }
//            curBlock.addBack(new StoreInst(addr,val,curBlock));
            addr.val = val;
            VarSymbol _thisvar = tmp.thisscope.Get_Var(tmp.Identifier,true,tmp.pos);
//                     = addr;
            _thisvar.address = addr;
            Mod.GlobalRegs.put(tmp.Identifier,addr);
        }
    }

    @Override
    public void visit(VarExprNode tmp) {
//        System.out.println("------------");
        VarSymbol temp = tmp.var;

//        System.out.println(temp.address);

        register res = new LocalReg("variable",trans_to_IRType(temp.type));
//        System.out.println("invoke"+tmp.Name);
        if(temp.address==null&&curFunc.Table.containsKey(tmp.Name+"$addr")) {
//            System.out.println(tmp.Name);
            temp.address = (register) curFunc.Table.get(tmp.Name + "$addr");
        }
        if(temp.address!=null) {
            result.put(tmp,res);
            address.put(tmp,temp.address);
            curBlock.addBack(new LoadInst(trans_to_IRType(temp.type),res, temp.address,curBlock));
        }
        else {

            register thisClassAddr = curFunc.thisptr;
//            System.out.println(tmp.Name);
            BaseType tp = ((PointerType)thisClassAddr.tp).tp;
            register temp1 = new LocalReg("this",tp);
            curBlock.addBack(new LoadInst(tp,temp1,thisClassAddr,curBlock));
            ArrayList<operand> index = new ArrayList<>();
            ClassType thisClass = (ClassType) global_scope.Get_Type(temp.ClassName,true,tmp.pos);
            index.add(new IntConst(0,new IntType(32)));
            index.add(new IntConst(thisClass.mapping.get(tmp.Name),new IntType(32)));
//            System.out.println(index);
            register temp2 = new LocalReg("variable$addr",new PointerType(trans_to_IRType(temp.type)));
//            System.out.println(trans_to_IRType(temp.type));
            curBlock.addBack(new GetElementPtrInst(temp1,temp2,index,curBlock));
            curBlock.addBack(new LoadInst(trans_to_IRType(temp.type),res,temp2,curBlock));
            result.put(tmp,res);
            address.put(tmp,temp2);
        }
        return ;
    }
}
