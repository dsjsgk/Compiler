package AST;

public interface ASTvisitor {
    void visit(ProgramNode tmp);
    void visit(ArrayExprNode tmp);
    void visit(ASTNode tmp);
    void visit(BinaryExprNode tmp);
    void visit(BreakStatementNode tmp);
    void visit(ClassDefNode tmp);
    void visit(ContinueStatementNode tmp);
    void visit(DEFNode tmp);
    void visit(ExprListNode tmp);
    void visit(ExprStatementNode tmp);
    void visit(ForStatementNode tmp);
    void visit(FuncExprNode tmp);
    void visit(FuncDefNode tmp);
    void visit(IfStatementNode tmp);
    void visit(LambdaExprNode tmp);
    void visit(MemberExprNode tmp);
    void visit(NewExprNode tmp);
    void visit(PrefixExprNode tmp);
    void visit(PrimaryExprNode tmp);
    void visit(ReturnStatementNode tmp);
    void visit(SinglevarDefStatementNode tmp);
    void visit(StatementNode tmp);
    void visit(SuffixExprNode tmp);
    void visit(SuiteStatementNode tmp);
    void visit(TypeNode tmp);
    void visit(UnaryExprNode tmp);
    void visit(varDefStatementNode tmp);
    void visit(WhileStatementNode tmp);
    void visit(VarExprNode tmp);
}
