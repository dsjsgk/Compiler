package BackEnd;

import AST.ASTvisitor;

import AST.*;
import MIR.*;
import Util.*;
import Util.error.SemanticError;

import javax.net.ssl.SSLException;
import java.util.ArrayList;
public class IRPrinter implements IRvisitor {
    @Override
    public void visit(BasicBlock tmp){
        println(block)
    }
    @Override
    public void visit(IRModule tmp){

    }
    @Override
    public void visit(IRFunction tmp){

    }
    @Override
    public void visit(AllocaInst tmp){
        
    }

    public void visit(BitCastInst tmp);
    public void visit(BranchInst tmp);
    public void visit(CallFuncInst tmp);
    public void visit(CmpInst tmp);
    public void visit(GetElementPtrInst tmp);
    public void visit(LoadInst tmp);
    public void visit(MoveInst tmp);
    public void visit(PhiInst tmp);
    public void visit(RetInst tmp);
    public void visit(StoreInst tmp);
    public void visit(BinaryInst tmp);
}
