package Parser;// Generated from C:/Users/86185/IdeaProjects/Compiler/src\Mxstar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxstarParser}.
 */
public interface MxstarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxstarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxstarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxstarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#classDeclarationStmt}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclarationStmt(MxstarParser.ClassDeclarationStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#classDeclarationStmt}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclarationStmt(MxstarParser.ClassDeclarationStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#constructorDef}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDef(MxstarParser.ConstructorDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#constructorDef}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDef(MxstarParser.ConstructorDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(MxstarParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(MxstarParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#singleParameter}.
	 * @param ctx the parse tree
	 */
	void enterSingleParameter(MxstarParser.SingleParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#singleParameter}.
	 * @param ctx the parse tree
	 */
	void exitSingleParameter(MxstarParser.SingleParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#functionParameterDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameterDef(MxstarParser.FunctionParameterDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#functionParameterDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameterDef(MxstarParser.FunctionParameterDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxstarParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxstarParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MxstarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MxstarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suitestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSuitestmt(MxstarParser.SuitestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suitestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSuitestmt(MxstarParser.SuitestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarstmt(MxstarParser.VarstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarstmt(MxstarParser.VarstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(MxstarParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(MxstarParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnstmt(MxstarParser.ReturnstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnstmt(MxstarParser.ReturnstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprstmt(MxstarParser.ExprstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprstmt(MxstarParser.ExprstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(MxstarParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(MxstarParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(MxstarParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(MxstarParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakstmt(MxstarParser.BreakstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakstmt(MxstarParser.BreakstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinuestmt(MxstarParser.ContinuestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinuestmt(MxstarParser.ContinuestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#prefixop}.
	 * @param ctx the parse tree
	 */
	void enterPrefixop(MxstarParser.PrefixopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#prefixop}.
	 * @param ctx the parse tree
	 */
	void exitPrefixop(MxstarParser.PrefixopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#suffixop}.
	 * @param ctx the parse tree
	 */
	void enterSuffixop(MxstarParser.SuffixopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#suffixop}.
	 * @param ctx the parse tree
	 */
	void exitSuffixop(MxstarParser.SuffixopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void enterUnaryop(MxstarParser.UnaryopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void exitUnaryop(MxstarParser.UnaryopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code errorcreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterErrorcreator(MxstarParser.ErrorcreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code errorcreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitErrorcreator(MxstarParser.ErrorcreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arraycreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterArraycreator(MxstarParser.ArraycreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arraycreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitArraycreator(MxstarParser.ArraycreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classcreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterClasscreator(MxstarParser.ClasscreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classcreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitClasscreator(MxstarParser.ClasscreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basiccreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterBasiccreator(MxstarParser.BasiccreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basiccreator}
	 * labeled alternative in {@link MxstarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitBasiccreator(MxstarParser.BasiccreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryexpr(MxstarParser.UnaryexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryexpr(MxstarParser.UnaryexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncexpr(MxstarParser.FuncexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncexpr(MxstarParser.FuncexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixexpr(MxstarParser.PrefixexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixexpr(MxstarParser.PrefixexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralexpr(MxstarParser.LiteralexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralexpr(MxstarParser.LiteralexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewexpr(MxstarParser.NewexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewexpr(MxstarParser.NewexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarexpr(MxstarParser.VarexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarexpr(MxstarParser.VarexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixexpr(MxstarParser.SuffixexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixexpr(MxstarParser.SuffixexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaexpr(MxstarParser.LambdaexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaexpr(MxstarParser.LambdaexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryexpr(MxstarParser.BinaryexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryexpr(MxstarParser.BinaryexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubexpr(MxstarParser.SubexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubexpr(MxstarParser.SubexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrexpr(MxstarParser.ArrexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrexpr(MxstarParser.ArrexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterClassexpr(MxstarParser.ClassexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitClassexpr(MxstarParser.ClassexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MxstarParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MxstarParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#varDeclarationStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationStmt(MxstarParser.VarDeclarationStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#varDeclarationStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationStmt(MxstarParser.VarDeclarationStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#singlevarDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSinglevarDeclaration(MxstarParser.SinglevarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#singlevarDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSinglevarDeclaration(MxstarParser.SinglevarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxstarParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxstarParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(MxstarParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(MxstarParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(MxstarParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(MxstarParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MxstarParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MxstarParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MxstarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MxstarParser.LiteralContext ctx);
}