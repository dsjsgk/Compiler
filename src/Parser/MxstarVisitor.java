package Parser;// Generated from C:/Users/86185/IdeaProjects/Compiler/src\Mxstar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxstarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxstarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxstarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxstarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#classDeclarationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclarationStmt(MxstarParser.ClassDeclarationStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#constructorDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDef(MxstarParser.ConstructorDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(MxstarParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#singleParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParameter(MxstarParser.SingleParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#functionParameterDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameterDef(MxstarParser.FunctionParameterDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxstarParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MxstarParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suitestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuitestmt(MxstarParser.SuitestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarstmt(MxstarParser.VarstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(MxstarParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstmt(MxstarParser.ReturnstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprstmt(MxstarParser.ExprstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(MxstarParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(MxstarParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstmt(MxstarParser.BreakstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MxstarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuestmt(MxstarParser.ContinuestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#prefixop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixop(MxstarParser.PrefixopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#suffixop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixop(MxstarParser.SuffixopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#unaryop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryop(MxstarParser.UnaryopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexpr(MxstarParser.UnaryexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncexpr(MxstarParser.FuncexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixexpr(MxstarParser.PrefixexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralexpr(MxstarParser.LiteralexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewexpr(MxstarParser.NewexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarexpr(MxstarParser.VarexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixexpr(MxstarParser.SuffixexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaexpr(MxstarParser.LambdaexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryexpr(MxstarParser.BinaryexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpr(MxstarParser.SubexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrexpr(MxstarParser.ArrexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classexpr}
	 * labeled alternative in {@link MxstarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassexpr(MxstarParser.ClassexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MxstarParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#varDeclarationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationStmt(MxstarParser.VarDeclarationStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#singlevarDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglevarDeclaration(MxstarParser.SinglevarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxstarParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(MxstarParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(MxstarParser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MxstarParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MxstarParser.LiteralContext ctx);
}