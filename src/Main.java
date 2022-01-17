import AST.ProgramNode;
import BackEnd.IRBuilder;
import FrontEnd.ASTBuilder;
import FrontEnd.SemanticChecker;
import FrontEnd.Init;
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
        String name = "test.mx";
        //FileInputStream input = new FileInputStream(name);
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
            new IRBuilder(global).visit(rt);

        } catch (Error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}
