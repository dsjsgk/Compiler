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
		LambdaStart=55, Identifier=56, DecimalInteger=57, StringConstant=58, Whitespace=59, 
		Newline=60, BlockComment=61, LineComment=62;
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
			"Continue", "LambdaStart", "Identifier", "DecimalInteger", "StringConstant", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u017c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\38\38\38\38\39\39\79\u0136\n9\f9\169\u0139\139\3:\3:\7:\u013d\n"+
		":\f:\16:\u0140\13:\3:\5:\u0143\n:\3;\3;\3;\3;\3;\3;\3;\3;\7;\u014d\n;"+
		"\f;\16;\u0150\13;\3;\3;\3<\6<\u0155\n<\r<\16<\u0156\3<\3<\3=\3=\5=\u015d"+
		"\n=\3=\5=\u0160\n=\3=\3=\3>\3>\3>\3>\7>\u0168\n>\f>\16>\u016b\13>\3>\3"+
		">\3>\3>\3>\3?\3?\3?\3?\7?\u0176\n?\f?\16?\u0179\13?\3?\3?\4\u014e\u0169"+
		"\2@\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\3\2\b\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\4\2\13"+
		"\13\"\"\4\2\f\f\17\17\2\u0187\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0082"+
		"\3\2\2\2\7\u0086\3\2\2\2\t\u008c\3\2\2\2\13\u0090\3\2\2\2\r\u0095\3\2"+
		"\2\2\17\u009c\3\2\2\2\21\u00a1\3\2\2\2\23\u00a6\3\2\2\2\25\u00ab\3\2\2"+
		"\2\27\u00b1\3\2\2\2\31\u00b4\3\2\2\2\33\u00b9\3\2\2\2\35\u00c0\3\2\2\2"+
		"\37\u00c2\3\2\2\2!\u00c4\3\2\2\2#\u00c6\3\2\2\2%\u00c8\3\2\2\2\'\u00ca"+
		"\3\2\2\2)\u00cc\3\2\2\2+\u00ce\3\2\2\2-\u00d0\3\2\2\2/\u00d3\3\2\2\2\61"+
		"\u00d5\3\2\2\2\63\u00d8\3\2\2\2\65\u00db\3\2\2\2\67\u00de\3\2\2\29\u00e0"+
		"\3\2\2\2;\u00e3\3\2\2\2=\u00e5\3\2\2\2?\u00e8\3\2\2\2A\u00ea\3\2\2\2C"+
		"\u00ec\3\2\2\2E\u00ee\3\2\2\2G\u00f0\3\2\2\2I\u00f2\3\2\2\2K\u00f5\3\2"+
		"\2\2M\u00f8\3\2\2\2O\u00fa\3\2\2\2Q\u00fc\3\2\2\2S\u00fe\3\2\2\2U\u0100"+
		"\3\2\2\2W\u0102\3\2\2\2Y\u0104\3\2\2\2[\u0106\3\2\2\2]\u0108\3\2\2\2_"+
		"\u010b\3\2\2\2a\u010e\3\2\2\2c\u0110\3\2\2\2e\u0113\3\2\2\2g\u0116\3\2"+
		"\2\2i\u011a\3\2\2\2k\u0120\3\2\2\2m\u0126\3\2\2\2o\u012f\3\2\2\2q\u0133"+
		"\3\2\2\2s\u0142\3\2\2\2u\u0144\3\2\2\2w\u0154\3\2\2\2y\u015f\3\2\2\2{"+
		"\u0163\3\2\2\2}\u0171\3\2\2\2\177\u0080\7/\2\2\u0080\u0081\7@\2\2\u0081"+
		"\4\3\2\2\2\u0082\u0083\7p\2\2\u0083\u0084\7g\2\2\u0084\u0085\7y\2\2\u0085"+
		"\6\3\2\2\2\u0086\u0087\7e\2\2\u0087\u0088\7n\2\2\u0088\u0089\7c\2\2\u0089"+
		"\u008a\7u\2\2\u008a\u008b\7u\2\2\u008b\b\3\2\2\2\u008c\u008d\7k\2\2\u008d"+
		"\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\n\3\2\2\2\u0090\u0091\7d\2\2\u0091"+
		"\u0092\7q\2\2\u0092\u0093\7q\2\2\u0093\u0094\7n\2\2\u0094\f\3\2\2\2\u0095"+
		"\u0096\7u\2\2\u0096\u0097\7v\2\2\u0097\u0098\7t\2\2\u0098\u0099\7k\2\2"+
		"\u0099\u009a\7p\2\2\u009a\u009b\7i\2\2\u009b\16\3\2\2\2\u009c\u009d\7"+
		"p\2\2\u009d\u009e\7w\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7n\2\2\u00a0\20"+
		"\3\2\2\2\u00a1\u00a2\7x\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7k\2\2\u00a4"+
		"\u00a5\7f\2\2\u00a5\22\3\2\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"\u00a9\7w\2\2\u00a9\u00aa\7g\2\2\u00aa\24\3\2\2\2\u00ab\u00ac\7h\2\2\u00ac"+
		"\u00ad\7c\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2"+
		"\u00b0\26\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b3\30\3\2\2"+
		"\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8"+
		"\7g\2\2\u00b8\32\3\2\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc"+
		"\7v\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7p\2\2\u00bf"+
		"\34\3\2\2\2\u00c0\u00c1\7\60\2\2\u00c1\36\3\2\2\2\u00c2\u00c3\7*\2\2\u00c3"+
		" \3\2\2\2\u00c4\u00c5\7+\2\2\u00c5\"\3\2\2\2\u00c6\u00c7\7]\2\2\u00c7"+
		"$\3\2\2\2\u00c8\u00c9\7_\2\2\u00c9&\3\2\2\2\u00ca\u00cb\7}\2\2\u00cb("+
		"\3\2\2\2\u00cc\u00cd\7\177\2\2\u00cd*\3\2\2\2\u00ce\u00cf\7>\2\2\u00cf"+
		",\3\2\2\2\u00d0\u00d1\7>\2\2\u00d1\u00d2\7?\2\2\u00d2.\3\2\2\2\u00d3\u00d4"+
		"\7@\2\2\u00d4\60\3\2\2\2\u00d5\u00d6\7@\2\2\u00d6\u00d7\7?\2\2\u00d7\62"+
		"\3\2\2\2\u00d8\u00d9\7>\2\2\u00d9\u00da\7>\2\2\u00da\64\3\2\2\2\u00db"+
		"\u00dc\7@\2\2\u00dc\u00dd\7@\2\2\u00dd\66\3\2\2\2\u00de\u00df\7-\2\2\u00df"+
		"8\3\2\2\2\u00e0\u00e1\7-\2\2\u00e1\u00e2\7-\2\2\u00e2:\3\2\2\2\u00e3\u00e4"+
		"\7/\2\2\u00e4<\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6\u00e7\7/\2\2\u00e7>\3"+
		"\2\2\2\u00e8\u00e9\7,\2\2\u00e9@\3\2\2\2\u00ea\u00eb\7\61\2\2\u00ebB\3"+
		"\2\2\2\u00ec\u00ed\7\'\2\2\u00edD\3\2\2\2\u00ee\u00ef\7(\2\2\u00efF\3"+
		"\2\2\2\u00f0\u00f1\7~\2\2\u00f1H\3\2\2\2\u00f2\u00f3\7(\2\2\u00f3\u00f4"+
		"\7(\2\2\u00f4J\3\2\2\2\u00f5\u00f6\7~\2\2\u00f6\u00f7\7~\2\2\u00f7L\3"+
		"\2\2\2\u00f8\u00f9\7`\2\2\u00f9N\3\2\2\2\u00fa\u00fb\7#\2\2\u00fbP\3\2"+
		"\2\2\u00fc\u00fd\7\u0080\2\2\u00fdR\3\2\2\2\u00fe\u00ff\7A\2\2\u00ffT"+
		"\3\2\2\2\u0100\u0101\7<\2\2\u0101V\3\2\2\2\u0102\u0103\7=\2\2\u0103X\3"+
		"\2\2\2\u0104\u0105\7.\2\2\u0105Z\3\2\2\2\u0106\u0107\7?\2\2\u0107\\\3"+
		"\2\2\2\u0108\u0109\7?\2\2\u0109\u010a\7?\2\2\u010a^\3\2\2\2\u010b\u010c"+
		"\7#\2\2\u010c\u010d\7?\2\2\u010d`\3\2\2\2\u010e\u010f\7$\2\2\u010fb\3"+
		"\2\2\2\u0110\u0111\7^\2\2\u0111\u0112\7^\2\2\u0112d\3\2\2\2\u0113\u0114"+
		"\7^\2\2\u0114\u0115\7$\2\2\u0115f\3\2\2\2\u0116\u0117\7h\2\2\u0117\u0118"+
		"\7q\2\2\u0118\u0119\7t\2\2\u0119h\3\2\2\2\u011a\u011b\7y\2\2\u011b\u011c"+
		"\7j\2\2\u011c\u011d\7k\2\2\u011d\u011e\7n\2\2\u011e\u011f\7g\2\2\u011f"+
		"j\3\2\2\2\u0120\u0121\7d\2\2\u0121\u0122\7t\2\2\u0122\u0123\7g\2\2\u0123"+
		"\u0124\7c\2\2\u0124\u0125\7m\2\2\u0125l\3\2\2\2\u0126\u0127\7e\2\2\u0127"+
		"\u0128\7q\2\2\u0128\u0129\7p\2\2\u0129\u012a\7v\2\2\u012a\u012b\7k\2\2"+
		"\u012b\u012c\7p\2\2\u012c\u012d\7w\2\2\u012d\u012e\7g\2\2\u012en\3\2\2"+
		"\2\u012f\u0130\7]\2\2\u0130\u0131\7(\2\2\u0131\u0132\7_\2\2\u0132p\3\2"+
		"\2\2\u0133\u0137\t\2\2\2\u0134\u0136\t\3\2\2\u0135\u0134\3\2\2\2\u0136"+
		"\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138r\3\2\2\2"+
		"\u0139\u0137\3\2\2\2\u013a\u013e\t\4\2\2\u013b\u013d\t\5\2\2\u013c\u013b"+
		"\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0143\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\7\62\2\2\u0142\u013a\3"+
		"\2\2\2\u0142\u0141\3\2\2\2\u0143t\3\2\2\2\u0144\u014e\7$\2\2\u0145\u0146"+
		"\7^\2\2\u0146\u014d\7p\2\2\u0147\u0148\7^\2\2\u0148\u014d\7^\2\2\u0149"+
		"\u014a\7^\2\2\u014a\u014d\7$\2\2\u014b\u014d\13\2\2\2\u014c\u0145\3\2"+
		"\2\2\u014c\u0147\3\2\2\2\u014c\u0149\3\2\2\2\u014c\u014b\3\2\2\2\u014d"+
		"\u0150\3\2\2\2\u014e\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0151\3\2"+
		"\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7$\2\2\u0152v\3\2\2\2\u0153\u0155"+
		"\t\6\2\2\u0154\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\b<\2\2\u0159x\3\2\2\2\u015a"+
		"\u015c\7\17\2\2\u015b\u015d\7\f\2\2\u015c\u015b\3\2\2\2\u015c\u015d\3"+
		"\2\2\2\u015d\u0160\3\2\2\2\u015e\u0160\7\f\2\2\u015f\u015a\3\2\2\2\u015f"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\b=\2\2\u0162z\3\2\2\2\u0163"+
		"\u0164\7\61\2\2\u0164\u0165\7,\2\2\u0165\u0169\3\2\2\2\u0166\u0168\13"+
		"\2\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u016a\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7,"+
		"\2\2\u016d\u016e\7\61\2\2\u016e\u016f\3\2\2\2\u016f\u0170\b>\2\2\u0170"+
		"|\3\2\2\2\u0171\u0172\7\61\2\2\u0172\u0173\7\61\2\2\u0173\u0177\3\2\2"+
		"\2\u0174\u0176\n\7\2\2\u0175\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a"+
		"\u017b\b?\2\2\u017b~\3\2\2\2\r\2\u0137\u013e\u0142\u014c\u014e\u0156\u015c"+
		"\u015f\u0169\u0177\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}