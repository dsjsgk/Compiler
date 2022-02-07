import ASM.Operand.PhysicalReg;
import AST.ProgramNode;
import BackEnd.*;
import FrontEnd.ASTBuilder;
import FrontEnd.SemanticChecker;
import FrontEnd.Init;
import MIR.IRModule;
import Util.MxErrorListener;
import Util.Scope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Parser.MxstarLexer;
import Parser.MxstarParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
       InputStream input = System.in;
//         String name = "test.mx";
//         FileInputStream input = new FileInputStream(name);
       boolean codegen  = true;
       if (args.length>0) {
           for (String arg:args) {
               if(arg.equals("-semantic")) codegen = false;
           }
       }
        try {
            ProgramNode rt;
            MxstarLexer lexer = new MxstarLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxstarParser parser = new MxstarParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            rt = (ProgramNode) astBuilder.visit(parseTreeRoot);
            Scope global = new Scope(null);
            new Init(global).visit(rt);
            global.Vars.clear();
            new SemanticChecker(global).visit(rt);
            PhysicalReg.Init();
//            new IRBuilder(global).visit(rt);
//            throw new RuntimeException();
           if(!codegen) return ;
            IRBuilder _IRBuilder = new IRBuilder(global);
            _IRBuilder.visit(rt);

            IRModule _IRModule = _IRBuilder.Mod;
//            (new IRPrinter("lab/output-O0.ll")).visit(_IRModule);
            IRDestructPhi _IRDestrucPhi = new IRDestructPhi(_IRModule);
            _IRDestrucPhi.DoThisMod();
            _IRModule = _IRDestrucPhi.thisModule;

            ASMBuilder _ASMBuilder = new ASMBuilder(_IRModule);
            _ASMBuilder.visit(_IRModule);
            GraphColoring _RegAllocator = new GraphColoring(_ASMBuilder.thisASMModule);
            _RegAllocator.RegAllocator();
            ASMPrinter _ASMPrinter = new ASMPrinter();
            _ASMPrinter.PrintMod(_ASMBuilder.thisASMModule);
        } catch (Error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}
