package Parser;// Generated from C:/Users/86185/IdeaProjects/Compiler/src\Mxstar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxstarLexer extends Lexer {
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
		This=55, LambdaStart=56, Identifier=57, DecimalInteger=58, StringConstant=59, 
		Whitespace=60, Newline=61, BlockComment=62, LineComment=63;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "New", "Class", "Int", "Bool", "String", "Null", "Void", "True", 
			"False", "If", "Else", "Return", "Dot", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
			"GreaterEqual", "LeftShift", "RightShift", "Plus", "SelfPlus", "Minus", 
			"SelfMinus", "Mul", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
			"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
			"NotEqual", "Quote", "BackSlash", "DbQuotation", "For", "While", "Break", 
			"Continue", "This", "LambdaStart", "Identifier", "DecimalInteger", "StringConstant", 
			"Whitespace", "Newline", "BlockComment", "LineComment"
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
			"'continue'", "'this'", "'[&]'"
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
			"Break", "Continue", "This", "LambdaStart", "Identifier", "DecimalInteger", 
			"StringConstant", "Whitespace", "Newline", "BlockComment", "LineComment"
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


	public MxstarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mxstar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u0183\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		"\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\38\39\39\39\39\3:\3:\7:\u013d\n:\f:\16:\u0140"+
		"\13:\3;\3;\7;\u0144\n;\f;\16;\u0147\13;\3;\5;\u014a\n;\3<\3<\3<\3<\3<"+
		"\3<\3<\3<\7<\u0154\n<\f<\16<\u0157\13<\3<\3<\3=\6=\u015c\n=\r=\16=\u015d"+
		"\3=\3=\3>\3>\5>\u0164\n>\3>\5>\u0167\n>\3>\3>\3?\3?\3?\3?\7?\u016f\n?"+
		"\f?\16?\u0172\13?\3?\3?\3?\3?\3?\3@\3@\3@\3@\7@\u017d\n@\f@\16@\u0180"+
		"\13@\3@\3@\4\u0155\u0170\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\3\2\b\4\2C\\c|\6\2\62;"+
		"C\\aac|\3\2\63;\3\2\62;\4\2\13\13\"\"\4\2\f\f\17\17\2\u018e\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u0084\3\2\2\2\7\u0088\3\2\2"+
		"\2\t\u008e\3\2\2\2\13\u0092\3\2\2\2\r\u0097\3\2\2\2\17\u009e\3\2\2\2\21"+
		"\u00a3\3\2\2\2\23\u00a8\3\2\2\2\25\u00ad\3\2\2\2\27\u00b3\3\2\2\2\31\u00b6"+
		"\3\2\2\2\33\u00bb\3\2\2\2\35\u00c2\3\2\2\2\37\u00c4\3\2\2\2!\u00c6\3\2"+
		"\2\2#\u00c8\3\2\2\2%\u00ca\3\2\2\2\'\u00cc\3\2\2\2)\u00ce\3\2\2\2+\u00d0"+
		"\3\2\2\2-\u00d2\3\2\2\2/\u00d5\3\2\2\2\61\u00d7\3\2\2\2\63\u00da\3\2\2"+
		"\2\65\u00dd\3\2\2\2\67\u00e0\3\2\2\29\u00e2\3\2\2\2;\u00e5\3\2\2\2=\u00e7"+
		"\3\2\2\2?\u00ea\3\2\2\2A\u00ec\3\2\2\2C\u00ee\3\2\2\2E\u00f0\3\2\2\2G"+
		"\u00f2\3\2\2\2I\u00f4\3\2\2\2K\u00f7\3\2\2\2M\u00fa\3\2\2\2O\u00fc\3\2"+
		"\2\2Q\u00fe\3\2\2\2S\u0100\3\2\2\2U\u0102\3\2\2\2W\u0104\3\2\2\2Y\u0106"+
		"\3\2\2\2[\u0108\3\2\2\2]\u010a\3\2\2\2_\u010d\3\2\2\2a\u0110\3\2\2\2c"+
		"\u0112\3\2\2\2e\u0115\3\2\2\2g\u0118\3\2\2\2i\u011c\3\2\2\2k\u0122\3\2"+
		"\2\2m\u0128\3\2\2\2o\u0131\3\2\2\2q\u0136\3\2\2\2s\u013a\3\2\2\2u\u0149"+
		"\3\2\2\2w\u014b\3\2\2\2y\u015b\3\2\2\2{\u0166\3\2\2\2}\u016a\3\2\2\2\177"+
		"\u0178\3\2\2\2\u0081\u0082\7/\2\2\u0082\u0083\7@\2\2\u0083\4\3\2\2\2\u0084"+
		"\u0085\7p\2\2\u0085\u0086\7g\2\2\u0086\u0087\7y\2\2\u0087\6\3\2\2\2\u0088"+
		"\u0089\7e\2\2\u0089\u008a\7n\2\2\u008a\u008b\7c\2\2\u008b\u008c\7u\2\2"+
		"\u008c\u008d\7u\2\2\u008d\b\3\2\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p"+
		"\2\2\u0090\u0091\7v\2\2\u0091\n\3\2\2\2\u0092\u0093\7d\2\2\u0093\u0094"+
		"\7q\2\2\u0094\u0095\7q\2\2\u0095\u0096\7n\2\2\u0096\f\3\2\2\2\u0097\u0098"+
		"\7u\2\2\u0098\u0099\7v\2\2\u0099\u009a\7t\2\2\u009a\u009b\7k\2\2\u009b"+
		"\u009c\7p\2\2\u009c\u009d\7i\2\2\u009d\16\3\2\2\2\u009e\u009f\7p\2\2\u009f"+
		"\u00a0\7w\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7n\2\2\u00a2\20\3\2\2\2\u00a3"+
		"\u00a4\7x\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7f\2\2"+
		"\u00a7\22\3\2\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7"+
		"w\2\2\u00ab\u00ac\7g\2\2\u00ac\24\3\2\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af"+
		"\7c\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"\26\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7h\2\2\u00b5\30\3\2\2\2\u00b6"+
		"\u00b7\7g\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7g\2\2"+
		"\u00ba\32\3\2\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7"+
		"v\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7p\2\2\u00c1\34"+
		"\3\2\2\2\u00c2\u00c3\7\60\2\2\u00c3\36\3\2\2\2\u00c4\u00c5\7*\2\2\u00c5"+
		" \3\2\2\2\u00c6\u00c7\7+\2\2\u00c7\"\3\2\2\2\u00c8\u00c9\7]\2\2\u00c9"+
		"$\3\2\2\2\u00ca\u00cb\7_\2\2\u00cb&\3\2\2\2\u00cc\u00cd\7}\2\2\u00cd("+
		"\3\2\2\2\u00ce\u00cf\7\177\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7>\2\2\u00d1"+
		",\3\2\2\2\u00d2\u00d3\7>\2\2\u00d3\u00d4\7?\2\2\u00d4.\3\2\2\2\u00d5\u00d6"+
		"\7@\2\2\u00d6\60\3\2\2\2\u00d7\u00d8\7@\2\2\u00d8\u00d9\7?\2\2\u00d9\62"+
		"\3\2\2\2\u00da\u00db\7>\2\2\u00db\u00dc\7>\2\2\u00dc\64\3\2\2\2\u00dd"+
		"\u00de\7@\2\2\u00de\u00df\7@\2\2\u00df\66\3\2\2\2\u00e0\u00e1\7-\2\2\u00e1"+
		"8\3\2\2\2\u00e2\u00e3\7-\2\2\u00e3\u00e4\7-\2\2\u00e4:\3\2\2\2\u00e5\u00e6"+
		"\7/\2\2\u00e6<\3\2\2\2\u00e7\u00e8\7/\2\2\u00e8\u00e9\7/\2\2\u00e9>\3"+
		"\2\2\2\u00ea\u00eb\7,\2\2\u00eb@\3\2\2\2\u00ec\u00ed\7\61\2\2\u00edB\3"+
		"\2\2\2\u00ee\u00ef\7\'\2\2\u00efD\3\2\2\2\u00f0\u00f1\7(\2\2\u00f1F\3"+
		"\2\2\2\u00f2\u00f3\7~\2\2\u00f3H\3\2\2\2\u00f4\u00f5\7(\2\2\u00f5\u00f6"+
		"\7(\2\2\u00f6J\3\2\2\2\u00f7\u00f8\7~\2\2\u00f8\u00f9\7~\2\2\u00f9L\3"+
		"\2\2\2\u00fa\u00fb\7`\2\2\u00fbN\3\2\2\2\u00fc\u00fd\7#\2\2\u00fdP\3\2"+
		"\2\2\u00fe\u00ff\7\u0080\2\2\u00ffR\3\2\2\2\u0100\u0101\7A\2\2\u0101T"+
		"\3\2\2\2\u0102\u0103\7<\2\2\u0103V\3\2\2\2\u0104\u0105\7=\2\2\u0105X\3"+
		"\2\2\2\u0106\u0107\7.\2\2\u0107Z\3\2\2\2\u0108\u0109\7?\2\2\u0109\\\3"+
		"\2\2\2\u010a\u010b\7?\2\2\u010b\u010c\7?\2\2\u010c^\3\2\2\2\u010d\u010e"+
		"\7#\2\2\u010e\u010f\7?\2\2\u010f`\3\2\2\2\u0110\u0111\7$\2\2\u0111b\3"+
		"\2\2\2\u0112\u0113\7^\2\2\u0113\u0114\7^\2\2\u0114d\3\2\2\2\u0115\u0116"+
		"\7^\2\2\u0116\u0117\7$\2\2\u0117f\3\2\2\2\u0118\u0119\7h\2\2\u0119\u011a"+
		"\7q\2\2\u011a\u011b\7t\2\2\u011bh\3\2\2\2\u011c\u011d\7y\2\2\u011d\u011e"+
		"\7j\2\2\u011e\u011f\7k\2\2\u011f\u0120\7n\2\2\u0120\u0121\7g\2\2\u0121"+
		"j\3\2\2\2\u0122\u0123\7d\2\2\u0123\u0124\7t\2\2\u0124\u0125\7g\2\2\u0125"+
		"\u0126\7c\2\2\u0126\u0127\7m\2\2\u0127l\3\2\2\2\u0128\u0129\7e\2\2\u0129"+
		"\u012a\7q\2\2\u012a\u012b\7p\2\2\u012b\u012c\7v\2\2\u012c\u012d\7k\2\2"+
		"\u012d\u012e\7p\2\2\u012e\u012f\7w\2\2\u012f\u0130\7g\2\2\u0130n\3\2\2"+
		"\2\u0131\u0132\7v\2\2\u0132\u0133\7j\2\2\u0133\u0134\7k\2\2\u0134\u0135"+
		"\7u\2\2\u0135p\3\2\2\2\u0136\u0137\7]\2\2\u0137\u0138\7(\2\2\u0138\u0139"+
		"\7_\2\2\u0139r\3\2\2\2\u013a\u013e\t\2\2\2\u013b\u013d\t\3\2\2\u013c\u013b"+
		"\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"t\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0145\t\4\2\2\u0142\u0144\t\5\2\2"+
		"\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u014a\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014a\7\62\2\2"+
		"\u0149\u0141\3\2\2\2\u0149\u0148\3\2\2\2\u014av\3\2\2\2\u014b\u0155\7"+
		"$\2\2\u014c\u014d\7^\2\2\u014d\u0154\7p\2\2\u014e\u014f\7^\2\2\u014f\u0154"+
		"\7^\2\2\u0150\u0151\7^\2\2\u0151\u0154\7$\2\2\u0152\u0154\13\2\2\2\u0153"+
		"\u014c\3\2\2\2\u0153\u014e\3\2\2\2\u0153\u0150\3\2\2\2\u0153\u0152\3\2"+
		"\2\2\u0154\u0157\3\2\2\2\u0155\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156"+
		"\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\7$\2\2\u0159x\3\2\2\2\u015a"+
		"\u015c\t\6\2\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2"+
		"\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\b=\2\2\u0160"+
		"z\3\2\2\2\u0161\u0163\7\17\2\2\u0162\u0164\7\f\2\2\u0163\u0162\3\2\2\2"+
		"\u0163\u0164\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0167\7\f\2\2\u0166\u0161"+
		"\3\2\2\2\u0166\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\b>\2\2\u0169"+
		"|\3\2\2\2\u016a\u016b\7\61\2\2\u016b\u016c\7,\2\2\u016c\u0170\3\2\2\2"+
		"\u016d\u016f\13\2\2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u0171"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173"+
		"\u0174\7,\2\2\u0174\u0175\7\61\2\2\u0175\u0176\3\2\2\2\u0176\u0177\b?"+
		"\2\2\u0177~\3\2\2\2\u0178\u0179\7\61\2\2\u0179\u017a\7\61\2\2\u017a\u017e"+
		"\3\2\2\2\u017b\u017d\n\7\2\2\u017c\u017b\3\2\2\2\u017d\u0180\3\2\2\2\u017e"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u017e\3\2"+
		"\2\2\u0181\u0182\b@\2\2\u0182\u0080\3\2\2\2\r\2\u013e\u0145\u0149\u0153"+
		"\u0155\u015d\u0163\u0166\u0170\u017e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}