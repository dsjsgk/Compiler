package Parser;// Generated from C:/Users/86185/IdeaProjects/Compiler/src\Mxstar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxstarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, New=2, Class=3, Int=4, Bool=5, String=6, Null=7, Void=8, True=9, 
		False=10, If=11, Else=12, Return=13, Dot=14, LeftParen=15, RightParen=16, 
		LeftBracket=17, RightBracket=18, LeftBrace=19, RightBrace=20, Less=21, 
		LessEqual=22, Greater=23, GreaterEqual=24, LeftShift=25, RightShift=26, 
		Plus=27, SelfPlus=28, Minus=29, SelfMinus=30, Mul=31, Div=32, Mod=33, 
		And=34, Or=35, AndAnd=36, OrOr=37, Caret=38, Not=39, Tilde=40, Question=41, 
		Colon=42, Semi=43, Comma=44, Assign=45, Equal=46, NotEqual=47, Quote=48, 
		BackSlash=49, DbQuotation=50, For=51, While=52, Break=53, Continue=54, 
		LambdaStart=55, Identifier=56, DecimalInteger=57, StringConstant=58, Whitespace=59, 
		Newline=60, BlockComment=61, LineComment=62;
	public static final int
		RULE_program = 0, RULE_classDeclarationStmt = 1, RULE_constructorDef = 2, 
		RULE_functionDef = 3, RULE_singleParameter = 4, RULE_functionParameterDef = 5, 
		RULE_suite = 6, RULE_expressionList = 7, RULE_statement = 8, RULE_prefixop = 9, 
		RULE_suffixop = 10, RULE_unaryop = 11, RULE_expression = 12, RULE_varDeclaration = 13, 
		RULE_varDeclarationStmt = 14, RULE_singlevarDeclaration = 15, RULE_returnType = 16, 
		RULE_varType = 17, RULE_builtinType = 18, RULE_primary = 19, RULE_literal = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDeclarationStmt", "constructorDef", "functionDef", "singleParameter", 
			"functionParameterDef", "suite", "expressionList", "statement", "prefixop", 
			"suffixop", "unaryop", "expression", "varDeclaration", "varDeclarationStmt", 
			"singlevarDeclaration", "returnType", "varType", "builtinType", "primary", 
			"literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'->'", "'new'", "'class'", "'int'", "'bool'", "'string'", "'null'", 
			"'void'", "'true'", "'false'", "'if'", "'else'", "'return'", "'.'", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", 
			"'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", 
			"'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", 
			"'=='", "'!='", "'\"'", "'\\\\'", "'\\\"'", "'for'", "'while'", "'break'", 
			"'continue'", "'[&]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "New", "Class", "Int", "Bool", "String", "Null", "Void", 
			"True", "False", "If", "Else", "Return", "Dot", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "SelfPlus", 
			"Minus", "SelfMinus", "Mul", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Caret", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"Equal", "NotEqual", "Quote", "BackSlash", "DbQuotation", "For", "While", 
			"Break", "Continue", "LambdaStart", "Identifier", "DecimalInteger", "StringConstant", 
			"Whitespace", "Newline", "BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mxstar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxstarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<VarDeclarationStmtContext> varDeclarationStmt() {
			return getRuleContexts(VarDeclarationStmtContext.class);
		}
		public VarDeclarationStmtContext varDeclarationStmt(int i) {
			return getRuleContext(VarDeclarationStmtContext.class,i);
		}
		public List<ClassDeclarationStmtContext> classDeclarationStmt() {
			return getRuleContexts(ClassDeclarationStmtContext.class);
		}
		public ClassDeclarationStmtContext classDeclarationStmt(int i) {
			return getRuleContext(ClassDeclarationStmtContext.class,i);
		}
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Class) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(45);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(42);
					varDeclarationStmt();
					}
					break;
				case 2:
					{
					setState(43);
					classDeclarationStmt();
					}
					break;
				case 3:
					{
					setState(44);
					functionDef();
					}
					break;
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationStmtContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxstarParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(MxstarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxstarParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public List<ConstructorDefContext> constructorDef() {
			return getRuleContexts(ConstructorDefContext.class);
		}
		public ConstructorDefContext constructorDef(int i) {
			return getRuleContext(ConstructorDefContext.class,i);
		}
		public List<VarDeclarationStmtContext> varDeclarationStmt() {
			return getRuleContexts(VarDeclarationStmtContext.class);
		}
		public VarDeclarationStmtContext varDeclarationStmt(int i) {
			return getRuleContext(VarDeclarationStmtContext.class,i);
		}
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public ClassDeclarationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclarationStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterClassDeclarationStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitClassDeclarationStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitClassDeclarationStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationStmtContext classDeclarationStmt() throws RecognitionException {
		ClassDeclarationStmtContext _localctx = new ClassDeclarationStmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclarationStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(Class);
			setState(51);
			match(Identifier);
			setState(52);
			match(LeftBrace);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(53);
					constructorDef();
					}
					break;
				case 2:
					{
					setState(54);
					varDeclarationStmt();
					}
					break;
				case 3:
					{
					setState(55);
					functionDef();
					}
					break;
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(RightBrace);
			setState(62);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ConstructorDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterConstructorDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitConstructorDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitConstructorDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDefContext constructorDef() throws RecognitionException {
		ConstructorDefContext _localctx = new ConstructorDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructorDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(Identifier);
			setState(65);
			match(LeftParen);
			setState(66);
			match(RightParen);
			setState(67);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public FunctionParameterDefContext functionParameterDef() {
			return getRuleContext(FunctionParameterDefContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			returnType();
			setState(70);
			match(Identifier);
			setState(71);
			match(LeftParen);
			setState(72);
			functionParameterDef();
			setState(73);
			match(RightParen);
			setState(74);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleParameterContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public SingleParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSingleParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSingleParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSingleParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleParameterContext singleParameter() throws RecognitionException {
		SingleParameterContext _localctx = new SingleParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			varType();
			setState(77);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParameterDefContext extends ParserRuleContext {
		public List<SingleParameterContext> singleParameter() {
			return getRuleContexts(SingleParameterContext.class);
		}
		public SingleParameterContext singleParameter(int i) {
			return getRuleContext(SingleParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxstarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxstarParser.Comma, i);
		}
		public FunctionParameterDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameterDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterFunctionParameterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitFunctionParameterDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitFunctionParameterDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParameterDefContext functionParameterDef() throws RecognitionException {
		FunctionParameterDefContext _localctx = new FunctionParameterDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionParameterDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(79);
				singleParameter();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(80);
					match(Comma);
					setState(81);
					singleParameter();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxstarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxstarParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(LeftBrace);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << Return) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(90);
				statement();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxstarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxstarParser.Comma, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			expression(0);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(99);
				match(Comma);
				setState(100);
				expression(0);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprstmtContext extends StatementContext {
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterExprstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitExprstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitExprstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhilestmtContext extends StatementContext {
		public TerminalNode While() { return getToken(MxstarParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public WhilestmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForstmtContext extends StatementContext {
		public VarDeclarationContext x0;
		public ExpressionContext x1;
		public ExpressionContext s1;
		public ExpressionContext s2;
		public TerminalNode For() { return getToken(MxstarParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(MxstarParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxstarParser.Semi, i);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfstmtContext extends StatementContext {
		public StatementContext trueStmt;
		public StatementContext falseStmt;
		public TerminalNode If() { return getToken(MxstarParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxstarParser.Else, 0); }
		public IfstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnstmtContext extends StatementContext {
		public TerminalNode Return() { return getToken(MxstarParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterReturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitReturnstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitReturnstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakstmtContext extends StatementContext {
		public TerminalNode Break() { return getToken(MxstarParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public BreakstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterBreakstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitBreakstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitBreakstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuitestmtContext extends StatementContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public SuitestmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSuitestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSuitestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSuitestmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinuestmtContext extends StatementContext {
		public TerminalNode Continue() { return getToken(MxstarParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public ContinuestmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterContinuestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitContinuestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitContinuestmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarstmtContext extends StatementContext {
		public VarDeclarationStmtContext varDeclarationStmt() {
			return getRuleContext(VarDeclarationStmtContext.class,0);
		}
		public VarstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new SuitestmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				suite();
				}
				break;
			case 2:
				_localctx = new VarstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				varDeclarationStmt();
				}
				break;
			case 3:
				_localctx = new IfstmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(If);
				setState(109);
				match(LeftParen);
				setState(110);
				expression(0);
				setState(111);
				match(RightParen);
				setState(112);
				((IfstmtContext)_localctx).trueStmt = statement();
				setState(115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(113);
					match(Else);
					setState(114);
					((IfstmtContext)_localctx).falseStmt = statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ReturnstmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(Return);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
					{
					setState(118);
					expression(0);
					}
				}

				setState(121);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new ExprstmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
					{
					setState(122);
					expression(0);
					}
				}

				setState(125);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new ForstmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				match(For);
				setState(127);
				match(LeftParen);
				setState(130);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(128);
					((ForstmtContext)_localctx).x0 = varDeclaration();
					}
					break;
				case 2:
					{
					setState(129);
					((ForstmtContext)_localctx).x1 = expression(0);
					}
					break;
				}
				setState(132);
				match(Semi);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
					{
					setState(133);
					((ForstmtContext)_localctx).s1 = expression(0);
					}
				}

				setState(136);
				match(Semi);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
					{
					setState(137);
					((ForstmtContext)_localctx).s2 = expression(0);
					}
				}

				setState(140);
				match(RightParen);
				setState(141);
				statement();
				}
				break;
			case 7:
				_localctx = new WhilestmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(142);
				match(While);
				setState(143);
				match(LeftParen);
				setState(144);
				expression(0);
				setState(145);
				match(RightParen);
				setState(146);
				statement();
				setState(147);
				match(Semi);
				}
				break;
			case 8:
				_localctx = new BreakstmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				match(Break);
				setState(150);
				match(Semi);
				}
				break;
			case 9:
				_localctx = new ContinuestmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(151);
				match(Continue);
				setState(152);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixopContext extends ParserRuleContext {
		public TerminalNode SelfPlus() { return getToken(MxstarParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(MxstarParser.SelfMinus, 0); }
		public PrefixopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPrefixop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPrefixop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPrefixop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixopContext prefixop() throws RecognitionException {
		PrefixopContext _localctx = new PrefixopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_prefixop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==SelfPlus || _la==SelfMinus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuffixopContext extends ParserRuleContext {
		public TerminalNode SelfPlus() { return getToken(MxstarParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(MxstarParser.SelfMinus, 0); }
		public SuffixopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffixop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSuffixop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSuffixop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSuffixop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixopContext suffixop() throws RecognitionException {
		SuffixopContext _localctx = new SuffixopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_suffixop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_la = _input.LA(1);
			if ( !(_la==SelfPlus || _la==SelfMinus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryopContext extends ParserRuleContext {
		public TerminalNode Minus() { return getToken(MxstarParser.Minus, 0); }
		public TerminalNode Plus() { return getToken(MxstarParser.Plus, 0); }
		public TerminalNode Not() { return getToken(MxstarParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(MxstarParser.Tilde, 0); }
		public UnaryopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterUnaryop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitUnaryop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitUnaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryopContext unaryop() throws RecognitionException {
		UnaryopContext _localctx = new UnaryopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryexprContext extends ExpressionContext {
		public UnaryopContext unaryop() {
			return getRuleContext(UnaryopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterUnaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitUnaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitUnaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncexprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public FuncexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterFuncexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitFuncexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitFuncexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixexprContext extends ExpressionContext {
		public PrefixopContext prefixop() {
			return getRuleContext(PrefixopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPrefixexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPrefixexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPrefixexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralexprContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterLiteralexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitLiteralexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitLiteralexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewexprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode New() { return getToken(MxstarParser.New, 0); }
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxstarParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxstarParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxstarParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxstarParser.RightBracket, i);
		}
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public NewexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterNewexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitNewexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitNewexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarexprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public VarexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixexprContext extends ExpressionContext {
		public SuffixopContext suffixop() {
			return getRuleContext(SuffixopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SuffixexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSuffixexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSuffixexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSuffixexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaexprContext extends ExpressionContext {
		public TerminalNode LambdaStart() { return getToken(MxstarParser.LambdaStart, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public List<TerminalNode> LeftParen() { return getTokens(MxstarParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(MxstarParser.LeftParen, i);
		}
		public List<TerminalNode> RightParen() { return getTokens(MxstarParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(MxstarParser.RightParen, i);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionParameterDefContext functionParameterDef() {
			return getRuleContext(FunctionParameterDefContext.class,0);
		}
		public LambdaexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterLambdaexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitLambdaexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitLambdaexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryexprContext extends ExpressionContext {
		public ExpressionContext a;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxstarParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxstarParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxstarParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(MxstarParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MxstarParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(MxstarParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(MxstarParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(MxstarParser.Less, 0); }
		public TerminalNode LessEqual() { return getToken(MxstarParser.LessEqual, 0); }
		public TerminalNode Greater() { return getToken(MxstarParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(MxstarParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(MxstarParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(MxstarParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(MxstarParser.And, 0); }
		public TerminalNode Caret() { return getToken(MxstarParser.Caret, 0); }
		public TerminalNode Or() { return getToken(MxstarParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(MxstarParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(MxstarParser.OrOr, 0); }
		public TerminalNode Assign() { return getToken(MxstarParser.Assign, 0); }
		public BinaryexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterBinaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitBinaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitBinaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubexprContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public SubexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSubexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSubexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSubexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrexprContext extends ExpressionContext {
		public ExpressionContext in;
		public ExpressionContext out;
		public TerminalNode LeftBracket() { return getToken(MxstarParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxstarParser.RightBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterArrexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitArrexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitArrexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassexprContext extends ExpressionContext {
		public ExpressionContext in;
		public ExpressionContext out;
		public TerminalNode Dot() { return getToken(MxstarParser.Dot, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ClassexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterClassexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitClassexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitClassexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new SubexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(162);
				match(LeftParen);
				setState(163);
				expression(0);
				setState(164);
				match(RightParen);
				}
				break;
			case 2:
				{
				_localctx = new LambdaexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(LambdaStart);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(167);
					match(LeftParen);
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(168);
						functionParameterDef();
						}
						break;
					}
					setState(171);
					match(RightParen);
					}
				}

				setState(174);
				match(T__0);
				setState(175);
				suite();
				setState(176);
				match(LeftParen);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
					{
					setState(177);
					expressionList();
					}
				}

				setState(180);
				match(RightParen);
				}
				break;
			case 3:
				{
				_localctx = new PrefixexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				prefixop();
				setState(183);
				expression(5);
				}
				break;
			case 4:
				{
				_localctx = new SuffixexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				suffixop();
				setState(186);
				expression(4);
				}
				break;
			case 5:
				{
				_localctx = new UnaryexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				unaryop();
				setState(189);
				expression(3);
				}
				break;
			case 6:
				{
				_localctx = new LiteralexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				literal();
				}
				break;
			case 7:
				{
				_localctx = new VarexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(196);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						((BinaryexprContext)_localctx).b = expression(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(199);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(200);
						((BinaryexprContext)_localctx).b = expression(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(202);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(203);
						((BinaryexprContext)_localctx).b = expression(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(205);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual))) != 0)) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(206);
						((BinaryexprContext)_localctx).b = expression(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(208);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(209);
						((BinaryexprContext)_localctx).b = expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(211);
						((BinaryexprContext)_localctx).op = match(And);
						setState(212);
						((BinaryexprContext)_localctx).b = expression(15);
						}
						break;
					case 7:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(214);
						((BinaryexprContext)_localctx).op = match(Caret);
						setState(215);
						((BinaryexprContext)_localctx).b = expression(14);
						}
						break;
					case 8:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(217);
						((BinaryexprContext)_localctx).op = match(Or);
						setState(218);
						((BinaryexprContext)_localctx).b = expression(13);
						}
						break;
					case 9:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(220);
						((BinaryexprContext)_localctx).op = match(AndAnd);
						setState(221);
						((BinaryexprContext)_localctx).b = expression(12);
						}
						break;
					case 10:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(223);
						((BinaryexprContext)_localctx).op = match(OrOr);
						setState(224);
						((BinaryexprContext)_localctx).b = expression(11);
						}
						break;
					case 11:
						{
						_localctx = new BinaryexprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(226);
						match(Assign);
						setState(227);
						((BinaryexprContext)_localctx).b = expression(9);
						}
						break;
					case 12:
						{
						_localctx = new ClassexprContext(new ExpressionContext(_parentctx, _parentState));
						((ClassexprContext)_localctx).in = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(229);
						match(Dot);
						setState(230);
						((ClassexprContext)_localctx).out = expression(9);
						}
						break;
					case 13:
						{
						_localctx = new ArrexprContext(new ExpressionContext(_parentctx, _parentState));
						((ArrexprContext)_localctx).in = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(232);
						match(LeftBracket);
						setState(233);
						((ArrexprContext)_localctx).out = expression(0);
						setState(234);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new FuncexprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(237);
						match(LeftParen);
						setState(238);
						expressionList();
						setState(239);
						match(RightParen);
						}
						break;
					case 15:
						{
						_localctx = new NewexprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(242);
						match(New);
						setState(243);
						builtinType();
						setState(251);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(244);
								match(LeftBracket);
								setState(246);
								_errHandler.sync(this);
								_la = _input.LA(1);
								if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << LambdaStart) | (1L << Identifier) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) {
									{
									setState(245);
									expression(0);
									}
								}

								setState(248);
								match(RightBracket);
								}
								} 
							}
							setState(253);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						}
						setState(256);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(254);
							match(LeftParen);
							setState(255);
							match(RightParen);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<SinglevarDeclarationContext> singlevarDeclaration() {
			return getRuleContexts(SinglevarDeclarationContext.class);
		}
		public SinglevarDeclarationContext singlevarDeclaration(int i) {
			return getRuleContext(SinglevarDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxstarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxstarParser.Comma, i);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			varType();
			setState(264);
			singlevarDeclaration();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(265);
				match(Comma);
				setState(266);
				singlevarDeclaration();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationStmtContext extends ParserRuleContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxstarParser.Semi, 0); }
		public VarDeclarationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclarationStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarDeclarationStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarDeclarationStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarDeclarationStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationStmtContext varDeclarationStmt() throws RecognitionException {
		VarDeclarationStmtContext _localctx = new VarDeclarationStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDeclarationStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			varDeclaration();
			setState(273);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SinglevarDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxstarParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SinglevarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlevarDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSinglevarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSinglevarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSinglevarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinglevarDeclarationContext singlevarDeclaration() throws RecognitionException {
		SinglevarDeclarationContext _localctx = new SinglevarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_singlevarDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(Identifier);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(276);
				match(Assign);
				setState(277);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(MxstarParser.Void, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnType);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(Void);
				}
				break;
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				varType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxstarParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxstarParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxstarParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxstarParser.RightBracket, i);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			builtinType();
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBracket) {
				{
				{
				setState(285);
				match(LeftBracket);
				setState(286);
				match(RightBracket);
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltinTypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MxstarParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxstarParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxstarParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public BuiltinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterBuiltinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitBuiltinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitBuiltinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(MxstarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxstarParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(MxstarParser.Identifier, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primary);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(LeftParen);
				setState(295);
				expression(0);
				setState(296);
				match(RightParen);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(Identifier);
				}
				break;
			case Null:
			case True:
			case False:
			case DecimalInteger:
			case StringConstant:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode DecimalInteger() { return getToken(MxstarParser.DecimalInteger, 0); }
		public TerminalNode True() { return getToken(MxstarParser.True, 0); }
		public TerminalNode False() { return getToken(MxstarParser.False, 0); }
		public TerminalNode StringConstant() { return getToken(MxstarParser.StringConstant, 0); }
		public TerminalNode Null() { return getToken(MxstarParser.Null, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << DecimalInteger) | (1L << StringConstant))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 21);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0133\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\7\2\60\n\2\f\2\16"+
		"\2\63\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3;\n\3\f\3\16\3>\13\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\7\7U\n\7\f\7\16\7X\13\7\5\7Z\n\7\3\b\3\b\7\b^\n\b\f\b\16\ba\13\b\3"+
		"\b\3\b\3\t\3\t\3\t\7\th\n\t\f\t\16\tk\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\nv\n\n\3\n\3\n\5\nz\n\n\3\n\3\n\5\n~\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u0085\n\n\3\n\3\n\5\n\u0089\n\n\3\n\3\n\5\n\u008d\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009c\n\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ac\n\16\3"+
		"\16\5\16\u00af\n\16\3\16\3\16\3\16\3\16\5\16\u00b5\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c4\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f9\n\16\3\16\7\16\u00fc"+
		"\n\16\f\16\16\16\u00ff\13\16\3\16\3\16\5\16\u0103\n\16\7\16\u0105\n\16"+
		"\f\16\16\16\u0108\13\16\3\17\3\17\3\17\3\17\7\17\u010e\n\17\f\17\16\17"+
		"\u0111\13\17\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u0119\n\21\3\22\3\22\5"+
		"\22\u011d\n\22\3\23\3\23\3\23\7\23\u0122\n\23\f\23\16\23\u0125\13\23\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u012f\n\25\3\26\3\26\3\26"+
		"\2\3\32\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\13\4\2\36\36"+
		"  \5\2\35\35\37\37)*\3\2!#\4\2\35\35\37\37\3\2\33\34\3\2\27\32\3\2\60"+
		"\61\4\2\6\b::\5\2\t\t\13\f;<\2\u0157\2\61\3\2\2\2\4\64\3\2\2\2\6B\3\2"+
		"\2\2\bG\3\2\2\2\nN\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20d\3\2\2\2\22\u009b"+
		"\3\2\2\2\24\u009d\3\2\2\2\26\u009f\3\2\2\2\30\u00a1\3\2\2\2\32\u00c3\3"+
		"\2\2\2\34\u0109\3\2\2\2\36\u0112\3\2\2\2 \u0115\3\2\2\2\"\u011c\3\2\2"+
		"\2$\u011e\3\2\2\2&\u0126\3\2\2\2(\u012e\3\2\2\2*\u0130\3\2\2\2,\60\5\36"+
		"\20\2-\60\5\4\3\2.\60\5\b\5\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\61\3\2\2\2\64\65\7\5\2"+
		"\2\65\66\7:\2\2\66<\7\25\2\2\67;\5\6\4\28;\5\36\20\29;\5\b\5\2:\67\3\2"+
		"\2\2:8\3\2\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2"+
		"\2\2?@\7\26\2\2@A\7-\2\2A\5\3\2\2\2BC\7:\2\2CD\7\21\2\2DE\7\22\2\2EF\5"+
		"\16\b\2F\7\3\2\2\2GH\5\"\22\2HI\7:\2\2IJ\7\21\2\2JK\5\f\7\2KL\7\22\2\2"+
		"LM\5\16\b\2M\t\3\2\2\2NO\5$\23\2OP\7:\2\2P\13\3\2\2\2QV\5\n\6\2RS\7.\2"+
		"\2SU\5\n\6\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XV\3\2\2"+
		"\2YQ\3\2\2\2YZ\3\2\2\2Z\r\3\2\2\2[_\7\25\2\2\\^\5\22\n\2]\\\3\2\2\2^a"+
		"\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\26\2\2c\17\3\2\2"+
		"\2di\5\32\16\2ef\7.\2\2fh\5\32\16\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2j\21\3\2\2\2ki\3\2\2\2l\u009c\5\16\b\2m\u009c\5\36\20\2no\7\r\2"+
		"\2op\7\21\2\2pq\5\32\16\2qr\7\22\2\2ru\5\22\n\2st\7\16\2\2tv\5\22\n\2"+
		"us\3\2\2\2uv\3\2\2\2v\u009c\3\2\2\2wy\7\17\2\2xz\5\32\16\2yx\3\2\2\2y"+
		"z\3\2\2\2z{\3\2\2\2{\u009c\7-\2\2|~\5\32\16\2}|\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u009c\7-\2\2\u0080\u0081\7\65\2\2\u0081\u0084\7\21\2\2\u0082"+
		"\u0085\5\34\17\2\u0083\u0085\5\32\16\2\u0084\u0082\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\7-\2\2\u0087"+
		"\u0089\5\32\16\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\u008c\7-\2\2\u008b\u008d\5\32\16\2\u008c\u008b\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\22\2\2\u008f\u009c\5"+
		"\22\n\2\u0090\u0091\7\66\2\2\u0091\u0092\7\21\2\2\u0092\u0093\5\32\16"+
		"\2\u0093\u0094\7\22\2\2\u0094\u0095\5\22\n\2\u0095\u0096\7-\2\2\u0096"+
		"\u009c\3\2\2\2\u0097\u0098\7\67\2\2\u0098\u009c\7-\2\2\u0099\u009a\78"+
		"\2\2\u009a\u009c\7-\2\2\u009bl\3\2\2\2\u009bm\3\2\2\2\u009bn\3\2\2\2\u009b"+
		"w\3\2\2\2\u009b}\3\2\2\2\u009b\u0080\3\2\2\2\u009b\u0090\3\2\2\2\u009b"+
		"\u0097\3\2\2\2\u009b\u0099\3\2\2\2\u009c\23\3\2\2\2\u009d\u009e\t\2\2"+
		"\2\u009e\25\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\27\3\2\2\2\u00a1\u00a2\t"+
		"\3\2\2\u00a2\31\3\2\2\2\u00a3\u00a4\b\16\1\2\u00a4\u00a5\7\21\2\2\u00a5"+
		"\u00a6\5\32\16\2\u00a6\u00a7\7\22\2\2\u00a7\u00c4\3\2\2\2\u00a8\u00ae"+
		"\79\2\2\u00a9\u00ab\7\21\2\2\u00aa\u00ac\5\f\7\2\u00ab\u00aa\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\7\22\2\2\u00ae\u00a9\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\3\2\2\u00b1"+
		"\u00b2\5\16\b\2\u00b2\u00b4\7\21\2\2\u00b3\u00b5\5\20\t\2\u00b4\u00b3"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\22\2\2"+
		"\u00b7\u00c4\3\2\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00ba\5\32\16\7\u00ba"+
		"\u00c4\3\2\2\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd\5\32\16\6\u00bd\u00c4"+
		"\3\2\2\2\u00be\u00bf\5\30\r\2\u00bf\u00c0\5\32\16\5\u00c0\u00c4\3\2\2"+
		"\2\u00c1\u00c4\5*\26\2\u00c2\u00c4\7:\2\2\u00c3\u00a3\3\2\2\2\u00c3\u00a8"+
		"\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00be\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u0106\3\2\2\2\u00c5\u00c6\f\25"+
		"\2\2\u00c6\u00c7\t\4\2\2\u00c7\u0105\5\32\16\26\u00c8\u00c9\f\24\2\2\u00c9"+
		"\u00ca\t\5\2\2\u00ca\u0105\5\32\16\25\u00cb\u00cc\f\23\2\2\u00cc\u00cd"+
		"\t\6\2\2\u00cd\u0105\5\32\16\24\u00ce\u00cf\f\22\2\2\u00cf\u00d0\t\7\2"+
		"\2\u00d0\u0105\5\32\16\23\u00d1\u00d2\f\21\2\2\u00d2\u00d3\t\b\2\2\u00d3"+
		"\u0105\5\32\16\22\u00d4\u00d5\f\20\2\2\u00d5\u00d6\7$\2\2\u00d6\u0105"+
		"\5\32\16\21\u00d7\u00d8\f\17\2\2\u00d8\u00d9\7(\2\2\u00d9\u0105\5\32\16"+
		"\20\u00da\u00db\f\16\2\2\u00db\u00dc\7%\2\2\u00dc\u0105\5\32\16\17\u00dd"+
		"\u00de\f\r\2\2\u00de\u00df\7&\2\2\u00df\u0105\5\32\16\16\u00e0\u00e1\f"+
		"\f\2\2\u00e1\u00e2\7\'\2\2\u00e2\u0105\5\32\16\r\u00e3\u00e4\f\13\2\2"+
		"\u00e4\u00e5\7/\2\2\u00e5\u0105\5\32\16\13\u00e6\u00e7\f\n\2\2\u00e7\u00e8"+
		"\7\20\2\2\u00e8\u0105\5\32\16\13\u00e9\u00ea\f\27\2\2\u00ea\u00eb\7\23"+
		"\2\2\u00eb\u00ec\5\32\16\2\u00ec\u00ed\7\24\2\2\u00ed\u0105\3\2\2\2\u00ee"+
		"\u00ef\f\26\2\2\u00ef\u00f0\7\21\2\2\u00f0\u00f1\5\20\t\2\u00f1\u00f2"+
		"\7\22\2\2\u00f2\u0105\3\2\2\2\u00f3\u00f4\f\t\2\2\u00f4\u00f5\7\4\2\2"+
		"\u00f5\u00fd\5&\24\2\u00f6\u00f8\7\23\2\2\u00f7\u00f9\5\32\16\2\u00f8"+
		"\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\7\24"+
		"\2\2\u00fb\u00f6\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0102\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7\21"+
		"\2\2\u0101\u0103\7\22\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0105\3\2\2\2\u0104\u00c5\3\2\2\2\u0104\u00c8\3\2\2\2\u0104\u00cb\3\2"+
		"\2\2\u0104\u00ce\3\2\2\2\u0104\u00d1\3\2\2\2\u0104\u00d4\3\2\2\2\u0104"+
		"\u00d7\3\2\2\2\u0104\u00da\3\2\2\2\u0104\u00dd\3\2\2\2\u0104\u00e0\3\2"+
		"\2\2\u0104\u00e3\3\2\2\2\u0104\u00e6\3\2\2\2\u0104\u00e9\3\2\2\2\u0104"+
		"\u00ee\3\2\2\2\u0104\u00f3\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\33\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a"+
		"\5$\23\2\u010a\u010f\5 \21\2\u010b\u010c\7.\2\2\u010c\u010e\5 \21\2\u010d"+
		"\u010b\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\35\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\5\34\17\2\u0113"+
		"\u0114\7-\2\2\u0114\37\3\2\2\2\u0115\u0118\7:\2\2\u0116\u0117\7/\2\2\u0117"+
		"\u0119\5\32\16\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119!\3\2\2"+
		"\2\u011a\u011d\7\n\2\2\u011b\u011d\5$\23\2\u011c\u011a\3\2\2\2\u011c\u011b"+
		"\3\2\2\2\u011d#\3\2\2\2\u011e\u0123\5&\24\2\u011f\u0120\7\23\2\2\u0120"+
		"\u0122\7\24\2\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124%\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127"+
		"\t\t\2\2\u0127\'\3\2\2\2\u0128\u0129\7\21\2\2\u0129\u012a\5\32\16\2\u012a"+
		"\u012b\7\22\2\2\u012b\u012f\3\2\2\2\u012c\u012f\7:\2\2\u012d\u012f\5*"+
		"\26\2\u012e\u0128\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		")\3\2\2\2\u0130\u0131\t\n\2\2\u0131+\3\2\2\2\37/\61:<VY_iuy}\u0084\u0088"+
		"\u008c\u009b\u00ab\u00ae\u00b4\u00c3\u00f8\u00fd\u0102\u0104\u0106\u010f"+
		"\u0118\u011c\u0123\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}