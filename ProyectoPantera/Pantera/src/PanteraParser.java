// Generated from C:/Users/Israel/Desktop/Pantera/src/Pantera.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PanteraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, Break=26, Do=27, Continuar=28, Else=29, Func=30, For=31, If=32, 
		Then=33, Len=34, NoneObj=35, Print=36, Return=37, While=38, TrueLiteral=39, 
		FalseLiteral=40, LINEA_COMENTARIO=41, NUMERO=42, ESPACIO=43, VARIABLE=44, 
		NEWLINE=45;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_identifier = 2, RULE_functionDecl = 3, 
		RULE_stmt = 4, RULE_expr = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "identifier", "functionDecl", "stmt", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "','", "')'", "';'", "'in'", "'..'", "'='", 
			"'['", "']'", "'+'", "'-'", "'!'", "'*'", "'/'", "'%'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'&'", "'|'", "'break'", "'do'", "'continuar'", 
			"'else'", "'func'", "'for'", "'if'", "'then'", "'len'", "'none'", "'print'", 
			"'return'", "'while'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "Break", "Do", "Continuar", "Else", "Func", "For", "If", 
			"Then", "Len", "NoneObj", "Print", "Return", "While", "TrueLiteral", 
			"FalseLiteral", "LINEA_COMENTARIO", "NUMERO", "ESPACIO", "VARIABLE", 
			"NEWLINE"
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
	public String getGrammarFileName() { return "Pantera.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PanteraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PanteraParser.EOF, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Func) {
				{
				{
				setState(12);
				functionDecl();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__0);
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24178853966922L) != 0)) {
				{
				{
				setState(21);
				stmt();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public Token var;
		public TerminalNode VARIABLE() { return getToken(PanteraParser.VARIABLE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			((IdentifierContext)_localctx).var = match(VARIABLE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Func() { return getToken(PanteraParser.Func, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(PanteraParser.VARIABLE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(Func);
			{
			setState(32);
			((FunctionDeclContext)_localctx).name = match(VARIABLE);
			}
			setState(33);
			match(T__2);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLE) {
				{
				setState(34);
				identifier();
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(35);
					match(T__3);
					setState(36);
					identifier();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(44);
			match(T__4);
			setState(45);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends StmtContext {
		public TerminalNode Print() { return getToken(PanteraParser.Print, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterPrintStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitPrintStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStmtContext extends StmtContext {
		public TerminalNode If() { return getToken(PanteraParser.If, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Then() { return getToken(PanteraParser.Then, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Else() { return getToken(PanteraParser.Else, 0); }
		public IfElseStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterIfElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitIfElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitIfElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends StmtContext {
		public Token var;
		public ExprContext rhs;
		public TerminalNode VARIABLE() { return getToken(PanteraParser.VARIABLE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends StmtContext {
		public TerminalNode Continuar() { return getToken(PanteraParser.Continuar, 0); }
		public ContinueStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitContinueStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StmtContext {
		public TerminalNode If() { return getToken(PanteraParser.If, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Then() { return getToken(PanteraParser.Then, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignIdxStmtContext extends StmtContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignIdxStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterAssignIdxStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitAssignIdxStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitAssignIdxStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StmtContext {
		public TerminalNode While() { return getToken(PanteraParser.While, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Do() { return getToken(PanteraParser.Do, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StmtContext {
		public TerminalNode Break() { return getToken(PanteraParser.Break, 0); }
		public BreakStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SingleStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterSingleStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitSingleStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitSingleStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullStmtContext extends StmtContext {
		public NullStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterNullStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitNullStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitNullStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StmtContext {
		public TerminalNode Return() { return getToken(PanteraParser.Return, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StmtContext {
		public Token var;
		public ExprContext lbound;
		public ExprContext ubound;
		public TerminalNode For() { return getToken(PanteraParser.For, 0); }
		public TerminalNode Do() { return getToken(PanteraParser.Do, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(PanteraParser.VARIABLE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				block();
				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(Print);
				setState(49);
				expr(0);
				setState(50);
				match(T__5);
				}
				break;
			case 3:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(Continuar);
				setState(53);
				match(T__5);
				}
				break;
			case 4:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				match(Break);
				setState(55);
				match(T__5);
				}
				break;
			case 5:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				match(Return);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 23691039634440L) != 0)) {
					{
					setState(57);
					expr(0);
					}
				}

				setState(60);
				match(T__5);
				}
				break;
			case 6:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(61);
				match(If);
				setState(62);
				expr(0);
				setState(63);
				match(Then);
				setState(64);
				stmt();
				}
				break;
			case 7:
				_localctx = new IfElseStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				match(If);
				setState(67);
				expr(0);
				setState(68);
				match(Then);
				setState(69);
				stmt();
				setState(70);
				match(Else);
				setState(71);
				stmt();
				}
				break;
			case 8:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				match(For);
				setState(74);
				((ForStmtContext)_localctx).var = match(VARIABLE);
				setState(75);
				match(T__6);
				{
				setState(76);
				((ForStmtContext)_localctx).lbound = expr(0);
				}
				setState(77);
				match(T__7);
				{
				setState(78);
				((ForStmtContext)_localctx).ubound = expr(0);
				}
				setState(79);
				match(Do);
				setState(80);
				stmt();
				}
				break;
			case 9:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				match(While);
				setState(83);
				expr(0);
				setState(84);
				match(Do);
				setState(85);
				stmt();
				}
				break;
			case 10:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(87);
				((AssignStmtContext)_localctx).var = match(VARIABLE);
				}
				setState(88);
				match(T__8);
				{
				setState(89);
				((AssignStmtContext)_localctx).rhs = expr(0);
				}
				setState(90);
				match(T__5);
				}
				break;
			case 11:
				_localctx = new AssignIdxStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(92);
				expr(0);
				setState(93);
				match(T__9);
				setState(94);
				expr(0);
				setState(95);
				match(T__10);
				setState(96);
				match(T__8);
				setState(97);
				expr(0);
				setState(98);
				match(T__5);
				}
				break;
			case 12:
				_localctx = new SingleStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(100);
				expr(0);
				setState(101);
				match(T__5);
				}
				break;
			case 13:
				_localctx = new NullStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(103);
				match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends ExprContext {
		public Token name;
		public TerminalNode VARIABLE() { return getToken(PanteraParser.VARIABLE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralContext extends ExprContext {
		public TerminalNode TrueLiteral() { return getToken(PanteraParser.TrueLiteral, 0); }
		public TrueLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExprContext extends ExprContext {
		public Token num;
		public TerminalNode NUMERO() { return getToken(PanteraParser.NUMERO, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends ExprContext {
		public Token var;
		public TerminalNode VARIABLE() { return getToken(PanteraParser.VARIABLE, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneExprContext extends ExprContext {
		public TerminalNode NoneObj() { return getToken(PanteraParser.NoneObj, 0); }
		public NoneExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterNoneExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitNoneExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitNoneExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinExprContext extends ExprContext {
		public Token num;
		public Token op;
		public List<TerminalNode> NUMERO() { return getTokens(PanteraParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(PanteraParser.NUMERO, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterBinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitBinExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitBinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterListExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitListExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Len() { return getToken(PanteraParser.Len, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralContext extends ExprContext {
		public TerminalNode FalseLiteral() { return getToken(PanteraParser.FalseLiteral, 0); }
		public FalseLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).enterFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PanteraListener ) ((PanteraListener)listener).exitFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PanteraVisitor ) return ((PanteraVisitor<? extends T>)visitor).visitFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new FuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				{
				setState(107);
				((FuncCallContext)_localctx).name = match(VARIABLE);
				}
				setState(108);
				match(T__2);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 23691039634440L) != 0)) {
					{
					setState(109);
					expr(0);
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(110);
						match(T__3);
						setState(111);
						expr(0);
						}
						}
						setState(116);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(119);
				match(T__4);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(T__2);
				setState(121);
				expr(0);
				setState(122);
				match(T__4);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179897856L) != 0)) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(125);
				expr(12);
				}
				break;
			case 4:
				{
				_localctx = new BinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				((BinExprContext)_localctx).num = match(NUMERO);
				setState(127);
				((BinExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16515072L) != 0)) ) {
					((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				((BinExprContext)_localctx).num = match(NUMERO);
				}
				break;
			case 5:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(T__9);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 23691039634440L) != 0)) {
					{
					setState(130);
					expr(0);
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(131);
						match(T__3);
						setState(132);
						expr(0);
						}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(140);
				match(T__10);
				}
				break;
			case 6:
				{
				_localctx = new TrueLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(TrueLiteral);
				}
				break;
			case 7:
				{
				_localctx = new FalseLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(FalseLiteral);
				}
				break;
			case 8:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				((NumExprContext)_localctx).num = match(NUMERO);
				}
				break;
			case 9:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				((VarExprContext)_localctx).var = match(VARIABLE);
				}
				break;
			case 10:
				{
				_localctx = new NoneExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(NoneObj);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(165);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(149);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(152);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(155);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16515072L) != 0)) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(158);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(161);
						match(T__9);
						setState(162);
						expr(0);
						setState(163);
						match(T__10);
						}
						break;
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u00ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u0017\b\u0001\n\u0001\f\u0001\u001a\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003&\b\u0003\n\u0003\f\u0003)\t\u0003\u0003"+
		"\u0003+\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004i\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005q\b\u0005\n\u0005"+
		"\f\u0005t\t\u0005\u0003\u0005v\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0086\b\u0005\n\u0005\f\u0005\u0089\t\u0005\u0003\u0005\u008b\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0093\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00a6\b\u0005\n\u0005\f\u0005\u00a9\t\u0005\u0001"+
		"\u0005\u0000\u0001\n\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0005\u0002"+
		"\u0000\f\u000e\"\"\u0001\u0000\u0012\u0017\u0001\u0000\u000f\u0011\u0001"+
		"\u0000\f\r\u0001\u0000\u0018\u0019\u00c7\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0002\u0014\u0001\u0000\u0000\u0000\u0004\u001d\u0001\u0000\u0000"+
		"\u0000\u0006\u001f\u0001\u0000\u0000\u0000\bh\u0001\u0000\u0000\u0000"+
		"\n\u0092\u0001\u0000\u0000\u0000\f\u000e\u0003\u0006\u0003\u0000\r\f\u0001"+
		"\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000"+
		"\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0012\u0001\u0000"+
		"\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0000"+
		"\u0000\u0001\u0013\u0001\u0001\u0000\u0000\u0000\u0014\u0018\u0005\u0001"+
		"\u0000\u0000\u0015\u0017\u0003\b\u0004\u0000\u0016\u0015\u0001\u0000\u0000"+
		"\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000"+
		"\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0002\u0000"+
		"\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001e\u0005,\u0000\u0000"+
		"\u001e\u0005\u0001\u0000\u0000\u0000\u001f \u0005\u001e\u0000\u0000 !"+
		"\u0005,\u0000\u0000!*\u0005\u0003\u0000\u0000\"\'\u0003\u0004\u0002\u0000"+
		"#$\u0005\u0004\u0000\u0000$&\u0003\u0004\u0002\u0000%#\u0001\u0000\u0000"+
		"\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*\"\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		",-\u0005\u0005\u0000\u0000-.\u0003\u0002\u0001\u0000.\u0007\u0001\u0000"+
		"\u0000\u0000/i\u0003\u0002\u0001\u000001\u0005$\u0000\u000012\u0003\n"+
		"\u0005\u000023\u0005\u0006\u0000\u00003i\u0001\u0000\u0000\u000045\u0005"+
		"\u001c\u0000\u00005i\u0005\u0006\u0000\u000067\u0005\u001a\u0000\u0000"+
		"7i\u0005\u0006\u0000\u00008:\u0005%\u0000\u00009;\u0003\n\u0005\u0000"+
		":9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<i\u0005\u0006\u0000\u0000=>\u0005 \u0000\u0000>?\u0003\n\u0005"+
		"\u0000?@\u0005!\u0000\u0000@A\u0003\b\u0004\u0000Ai\u0001\u0000\u0000"+
		"\u0000BC\u0005 \u0000\u0000CD\u0003\n\u0005\u0000DE\u0005!\u0000\u0000"+
		"EF\u0003\b\u0004\u0000FG\u0005\u001d\u0000\u0000GH\u0003\b\u0004\u0000"+
		"Hi\u0001\u0000\u0000\u0000IJ\u0005\u001f\u0000\u0000JK\u0005,\u0000\u0000"+
		"KL\u0005\u0007\u0000\u0000LM\u0003\n\u0005\u0000MN\u0005\b\u0000\u0000"+
		"NO\u0003\n\u0005\u0000OP\u0005\u001b\u0000\u0000PQ\u0003\b\u0004\u0000"+
		"Qi\u0001\u0000\u0000\u0000RS\u0005&\u0000\u0000ST\u0003\n\u0005\u0000"+
		"TU\u0005\u001b\u0000\u0000UV\u0003\b\u0004\u0000Vi\u0001\u0000\u0000\u0000"+
		"WX\u0005,\u0000\u0000XY\u0005\t\u0000\u0000YZ\u0003\n\u0005\u0000Z[\u0005"+
		"\u0006\u0000\u0000[i\u0001\u0000\u0000\u0000\\]\u0003\n\u0005\u0000]^"+
		"\u0005\n\u0000\u0000^_\u0003\n\u0005\u0000_`\u0005\u000b\u0000\u0000`"+
		"a\u0005\t\u0000\u0000ab\u0003\n\u0005\u0000bc\u0005\u0006\u0000\u0000"+
		"ci\u0001\u0000\u0000\u0000de\u0003\n\u0005\u0000ef\u0005\u0006\u0000\u0000"+
		"fi\u0001\u0000\u0000\u0000gi\u0005\u0006\u0000\u0000h/\u0001\u0000\u0000"+
		"\u0000h0\u0001\u0000\u0000\u0000h4\u0001\u0000\u0000\u0000h6\u0001\u0000"+
		"\u0000\u0000h8\u0001\u0000\u0000\u0000h=\u0001\u0000\u0000\u0000hB\u0001"+
		"\u0000\u0000\u0000hI\u0001\u0000\u0000\u0000hR\u0001\u0000\u0000\u0000"+
		"hW\u0001\u0000\u0000\u0000h\\\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000"+
		"\u0000hg\u0001\u0000\u0000\u0000i\t\u0001\u0000\u0000\u0000jk\u0006\u0005"+
		"\uffff\uffff\u0000kl\u0005,\u0000\u0000lu\u0005\u0003\u0000\u0000mr\u0003"+
		"\n\u0005\u0000no\u0005\u0004\u0000\u0000oq\u0003\n\u0005\u0000pn\u0001"+
		"\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000um\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000w\u0093\u0005\u0005\u0000\u0000xy\u0005\u0003\u0000\u0000"+
		"yz\u0003\n\u0005\u0000z{\u0005\u0005\u0000\u0000{\u0093\u0001\u0000\u0000"+
		"\u0000|}\u0007\u0000\u0000\u0000}\u0093\u0003\n\u0005\f~\u007f\u0005*"+
		"\u0000\u0000\u007f\u0080\u0007\u0001\u0000\u0000\u0080\u0093\u0005*\u0000"+
		"\u0000\u0081\u008a\u0005\n\u0000\u0000\u0082\u0087\u0003\n\u0005\u0000"+
		"\u0083\u0084\u0005\u0004\u0000\u0000\u0084\u0086\u0003\n\u0005\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u0082\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u0093\u0005\u000b\u0000\u0000\u008d"+
		"\u0093\u0005\'\u0000\u0000\u008e\u0093\u0005(\u0000\u0000\u008f\u0093"+
		"\u0005*\u0000\u0000\u0090\u0093\u0005,\u0000\u0000\u0091\u0093\u0005#"+
		"\u0000\u0000\u0092j\u0001\u0000\u0000\u0000\u0092x\u0001\u0000\u0000\u0000"+
		"\u0092|\u0001\u0000\u0000\u0000\u0092~\u0001\u0000\u0000\u0000\u0092\u0081"+
		"\u0001\u0000\u0000\u0000\u0092\u008d\u0001\u0000\u0000\u0000\u0092\u008e"+
		"\u0001\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u00a7"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\n\u000b\u0000\u0000\u0095\u0096\u0007"+
		"\u0002\u0000\u0000\u0096\u00a6\u0003\n\u0005\f\u0097\u0098\n\n\u0000\u0000"+
		"\u0098\u0099\u0007\u0003\u0000\u0000\u0099\u00a6\u0003\n\u0005\u000b\u009a"+
		"\u009b\n\t\u0000\u0000\u009b\u009c\u0007\u0001\u0000\u0000\u009c\u00a6"+
		"\u0003\n\u0005\n\u009d\u009e\n\u0007\u0000\u0000\u009e\u009f\u0007\u0004"+
		"\u0000\u0000\u009f\u00a6\u0003\n\u0005\b\u00a0\u00a1\n\r\u0000\u0000\u00a1"+
		"\u00a2\u0005\n\u0000\u0000\u00a2\u00a3\u0003\n\u0005\u0000\u00a3\u00a4"+
		"\u0005\u000b\u0000\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u0094"+
		"\u0001\u0000\u0000\u0000\u00a5\u0097\u0001\u0000\u0000\u0000\u00a5\u009a"+
		"\u0001\u0000\u0000\u0000\u00a5\u009d\u0001\u0000\u0000\u0000\u00a5\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u000b"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\r\u000f\u0018"+
		"\'*:hru\u0087\u008a\u0092\u00a5\u00a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}