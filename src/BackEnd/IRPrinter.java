package BackEnd;

import AST.ASTvisitor;

import AST.*;
import MIR.*;
import Util.*;
import Util.error.SemanticError;
import javax.net.ssl.SSLException;
import java.util.ArrayList;
import java.io.File;

public class IRPrinter implements IRvisitor {
    public String indent = "";
    public String filename ;

    public IRPrinter(String filename) {
        this.filename = filename;
    }
    public void print(String a) {
        System.out.print(indent+a);
    }
    public void println(String a) {
        System.out.println(indent+a);
    }
    @Override
    public void visit(BasicBlock tmp){
        System.out.println(tmp.id+":");
        indent = "\t";
        //System.out.println(tmp.id+"________________");
        for(Inst i = tmp.begin_Inst;i!=null;i = i.Nxt) {
            //System.out.println(i.toString());
            i.accept(this);
        }
        indent = "";
    }
    @Override
    public void visit(IRModule tmp){
//        try {
//            File file = new File(fileName);
//            assert file.exists() || file.createNewFile();
//            outputStream = new FileOutputStream(fileName, false);
//            printWriter = new PrintWriter(outputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }

        indent = "";

        println("; ModuleID = 'test.cpp'");
        println("source_filename = \"test.cpp\"");
        println("");


        if (tmp.ClassMap.size() > 0) {
            assert false;
            for (IRClassType cls : tmp.ClassMap.values())
                println(cls.Contruction());
            println("");
        }

        if (tmp.GlobalRegs.size() > 0) {
            for (GlobalReg var : tmp.GlobalRegs.values())
                println(var.deftoString());
            println("");
        }

        if (tmp.Sys_Funcs.size() > 0) {
            for (IRFunction function : tmp.Sys_Funcs.values())
                println(function.declareToString());
            println("");
        }


        for (String name : tmp.Funcs.keySet()) {
            tmp.Funcs.get(name).accept(this);
            println("");
        }

//        try {
//            printWriter.close();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
    }
    @Override
    public void visit(IRFunction tmp){
        StringBuilder header = new StringBuilder("define ");
        header.append(tmp.functp.ret_tp.toString());
        header.append(" @").append(tmp.id);

        header.append("(");
        for (int i = 0; i < tmp.paras_list.size(); i++) {
            Parameter parameter = tmp.paras_list.get(i);
            header.append(parameter.tp.toString()).append(" ");
            header.append(parameter.toString());
            if (i != tmp.paras_list.size() - 1)
                header.append(", ");
        }
        header.append(")").append(" ");
        print(header.toString());
        println("{");

        for (BasicBlock block = tmp.entry; block != null; block = block.nxt_block) {
            //System.out.println(block.id);
            block.accept(this);

            if (block.id != null)
                println("");
        }

        println("}");
    }
    @Override
    public void visit(AllocaInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(BitCastInst tmp)
    {
        println(tmp.toString());
    }
    @Override
    public void visit(BranchInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(CallFuncInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(CmpInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(GetElementPtrInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(LoadInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(MoveInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(PhiInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(RetInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(StoreInst tmp){
        println(tmp.toString());
    }
    @Override
    public void visit(BinaryInst tmp){
        println(tmp.toString());
    }
}
