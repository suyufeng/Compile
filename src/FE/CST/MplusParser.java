// Generated from Mplus.g4 by ANTLR 4.6
package FE.CST;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MplusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, Comment=49, This=50, Blockcomment=51, Name=52, 
		Integer=53, String=54, Space=55;
	public static final int
		RULE_program = 0, RULE_classpart = 1, RULE_selfpart = 2, RULE_functionpart = 3, 
		RULE_parameter = 4, RULE_difinition = 5, RULE_statement = 6, RULE_expr_statement = 7, 
		RULE_blockpart = 8, RULE_if_statement = 9, RULE_while_statement = 10, 
		RULE_scope_statement = 11, RULE_for_statement = 12, RULE_skip_statement = 13, 
		RULE_expr = 14, RULE_constant = 15, RULE_type = 16;
	public static final String[] ruleNames = {
		"program", "classpart", "selfpart", "functionpart", "parameter", "difinition", 
		"statement", "expr_statement", "blockpart", "if_statement", "while_statement", 
		"scope_statement", "for_statement", "skip_statement", "expr", "constant", 
		"type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'}'", "'('", "')'", "','", "'='", "';'", "'if'", 
		"'else'", "'while'", "'for'", "'continue'", "'break'", "'return'", "'++'", 
		"'--'", "'['", "']'", "'.'", "'+'", "'-'", "'!'", "'~'", "'new'", "'*'", 
		"'/'", "'%'", "'<<'", "'>>'", "'&'", "'^'", "'|'", "'<'", "'>'", "'<='", 
		"'>='", "'=='", "'!='", "'&&'", "'||'", "'true'", "'false'", "'null'", 
		"'void'", "'int'", "'bool'", "'string'", null, "'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "Comment", "This", "Blockcomment", "Name", "Integer", "String", 
		"Space"
	};
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
	public String getGrammarFileName() { return "Mplus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MplusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<ClasspartContext> classpart() {
			return getRuleContexts(ClasspartContext.class);
		}
		public ClasspartContext classpart(int i) {
			return getRuleContext(ClasspartContext.class,i);
		}
		public List<FunctionpartContext> functionpart() {
			return getRuleContexts(FunctionpartContext.class);
		}
		public FunctionpartContext functionpart(int i) {
			return getRuleContext(FunctionpartContext.class,i);
		}
		public List<DifinitionContext> difinition() {
			return getRuleContexts(DifinitionContext.class);
		}
		public DifinitionContext difinition(int i) {
			return getRuleContext(DifinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(37);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(34);
					classpart();
					}
					break;
				case 2:
					{
					setState(35);
					functionpart();
					}
					break;
				case 3:
					{
					setState(36);
					difinition();
					}
					break;
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << Name))) != 0) );
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

	public static class ClasspartContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(MplusParser.Name, 0); }
		public List<FunctionpartContext> functionpart() {
			return getRuleContexts(FunctionpartContext.class);
		}
		public FunctionpartContext functionpart(int i) {
			return getRuleContext(FunctionpartContext.class,i);
		}
		public List<DifinitionContext> difinition() {
			return getRuleContexts(DifinitionContext.class);
		}
		public DifinitionContext difinition(int i) {
			return getRuleContext(DifinitionContext.class,i);
		}
		public List<SelfpartContext> selfpart() {
			return getRuleContexts(SelfpartContext.class);
		}
		public SelfpartContext selfpart(int i) {
			return getRuleContext(SelfpartContext.class,i);
		}
		public ClasspartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterClasspart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitClasspart(this);
		}
	}

	public final ClasspartContext classpart() throws RecognitionException {
		ClasspartContext _localctx = new ClasspartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classpart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			match(Name);
			setState(43);
			match(T__1);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << Name))) != 0)) {
				{
				setState(47);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(44);
					functionpart();
					}
					break;
				case 2:
					{
					setState(45);
					difinition();
					}
					break;
				case 3:
					{
					setState(46);
					selfpart();
					}
					break;
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(T__2);
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

	public static class SelfpartContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockpartContext blockpart() {
			return getRuleContext(BlockpartContext.class,0);
		}
		public SelfpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterSelfpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitSelfpart(this);
		}
	}

	public final SelfpartContext selfpart() throws RecognitionException {
		SelfpartContext _localctx = new SelfpartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selfpart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			type(0);
			setState(55);
			match(T__3);
			setState(56);
			match(T__4);
			setState(57);
			blockpart();
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

	public static class FunctionpartContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MplusParser.Name, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public BlockpartContext blockpart() {
			return getRuleContext(BlockpartContext.class,0);
		}
		public FunctionpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterFunctionpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitFunctionpart(this);
		}
	}

	public final FunctionpartContext functionpart() throws RecognitionException {
		FunctionpartContext _localctx = new FunctionpartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionpart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			type(0);
			setState(60);
			match(Name);
			setState(61);
			match(T__3);
			setState(62);
			parameter();
			setState(63);
			match(T__4);
			setState(64);
			blockpart();
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

	public static class ParameterContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Name() { return getTokens(MplusParser.Name); }
		public TerminalNode Name(int i) {
			return getToken(MplusParser.Name, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << Name))) != 0)) {
					{
					setState(66);
					type(0);
					setState(67);
					match(Name);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(71);
				type(0);
				setState(72);
				match(Name);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(73);
					match(T__5);
					setState(74);
					type(0);
					setState(75);
					match(Name);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class DifinitionContext extends ParserRuleContext {
		public Token op;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MplusParser.Name, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode This() { return getToken(MplusParser.This, 0); }
		public DifinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterDifinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitDifinition(this);
		}
	}

	public final DifinitionContext difinition() throws RecognitionException {
		DifinitionContext _localctx = new DifinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_difinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			type(0);
			setState(85);
			match(Name);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(86);
				((DifinitionContext)_localctx).op = match(T__6);
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(87);
					expr(0);
					}
					break;
				case 2:
					{
					setState(88);
					match(This);
					}
					break;
				}
				}
			}

			setState(93);
			match(T__7);
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
		public BlockpartContext blockpart() {
			return getRuleContext(BlockpartContext.class,0);
		}
		public Expr_statementContext expr_statement() {
			return getRuleContext(Expr_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public Skip_statementContext skip_statement() {
			return getRuleContext(Skip_statementContext.class,0);
		}
		public DifinitionContext difinition() {
			return getRuleContext(DifinitionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				blockpart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				expr_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				if_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				for_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				while_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				skip_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(101);
				difinition();
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

	public static class Expr_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode This() { return getToken(MplusParser.This, 0); }
		public Expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterExpr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitExpr_statement(this);
		}
	}

	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(104);
				expr(0);
				}
				break;
			case 2:
				{
				setState(105);
				match(This);
				}
				break;
			}
			setState(108);
			match(T__7);
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

	public static class BlockpartContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterBlockpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitBlockpart(this);
		}
	}

	public final BlockpartContext blockpart() throws RecognitionException {
		BlockpartContext _localctx = new BlockpartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blockpart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__1);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
				{
				{
				setState(111);
				statement();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__2);
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

	public static class If_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Scope_statementContext> scope_statement() {
			return getRuleContexts(Scope_statementContext.class);
		}
		public Scope_statementContext scope_statement(int i) {
			return getRuleContext(Scope_statementContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__8);
			setState(120);
			match(T__3);
			setState(121);
			expr(0);
			setState(122);
			match(T__4);
			setState(123);
			scope_statement();
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(124);
				match(T__9);
				setState(125);
				scope_statement();
				}
				break;
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

	public static class While_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Scope_statementContext scope_statement() {
			return getRuleContext(Scope_statementContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitWhile_statement(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__10);
			setState(129);
			match(T__3);
			setState(130);
			expr(0);
			setState(131);
			match(T__4);
			setState(132);
			scope_statement();
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

	public static class Scope_statementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Scope_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterScope_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitScope_statement(this);
		}
	}

	public final Scope_statementContext scope_statement() throws RecognitionException {
		Scope_statementContext _localctx = new Scope_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_scope_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			statement();
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

	public static class For_statementContext extends ParserRuleContext {
		public Scope_statementContext scope_statement() {
			return getRuleContext(Scope_statementContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> This() { return getTokens(MplusParser.This); }
		public TerminalNode This(int i) {
			return getToken(MplusParser.This, i);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitFor_statement(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__11);
			setState(137);
			match(T__3);
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(138);
				expr(0);
				}
				break;
			case 2:
				{
				setState(139);
				match(This);
				}
				break;
			}
			setState(142);
			match(T__7);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
				{
				setState(143);
				expr(0);
				}
			}

			setState(146);
			match(T__7);
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(147);
				expr(0);
				}
				break;
			case 2:
				{
				setState(148);
				match(This);
				}
				break;
			}
			setState(151);
			match(T__4);
			setState(152);
			scope_statement();
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

	public static class Skip_statementContext extends ParserRuleContext {
		public Skip_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip_statement; }
	 
		public Skip_statementContext() { }
		public void copyFrom(Skip_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BreakContext extends Skip_statementContext {
		public BreakContext(Skip_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitBreak(this);
		}
	}
	public static class ContinueContext extends Skip_statementContext {
		public ContinueContext(Skip_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitContinue(this);
		}
	}
	public static class ReturnContext extends Skip_statementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode This() { return getToken(MplusParser.This, 0); }
		public ReturnContext(Skip_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitReturn(this);
		}
	}

	public final Skip_statementContext skip_statement() throws RecognitionException {
		Skip_statementContext _localctx = new Skip_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_skip_statement);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(T__12);
				setState(155);
				match(T__7);
				}
				break;
			case T__13:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(T__13);
				setState(157);
				match(T__7);
				}
				break;
			case T__14:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				match(T__14);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(159);
					expr(0);
					}
					break;
				case 2:
					{
					setState(160);
					match(This);
					}
					break;
				}
				setState(163);
				match(T__7);
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
	public static class Unary_exprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitUnary_expr(this);
		}
	}
	public static class Aref_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Aref_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterAref_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitAref_expr(this);
		}
	}
	public static class Member_exprContext extends ExprContext {
		public TerminalNode This() { return getToken(MplusParser.This, 0); }
		public TerminalNode Name() { return getToken(MplusParser.Name, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Member_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterMember_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitMember_expr(this);
		}
	}
	public static class Constant_exprContext extends ExprContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Constant_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterConstant_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitConstant_expr(this);
		}
	}
	public static class Binary_exprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Binary_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitBinary_expr(this);
		}
	}
	public static class Suffix_exprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Suffix_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterSuffix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitSuffix_expr(this);
		}
	}
	public static class New_exprContext extends ExprContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public New_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterNew_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitNew_expr(this);
		}
	}
	public static class Assign_exprContext extends ExprContext {
		public Token op;
		public List<TerminalNode> This() { return getTokens(MplusParser.This); }
		public TerminalNode This(int i) {
			return getToken(MplusParser.This, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Assign_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitAssign_expr(this);
		}
	}
	public static class Name_exprContext extends ExprContext {
		public TerminalNode Name() { return getToken(MplusParser.Name, 0); }
		public Name_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterName_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitName_expr(this);
		}
	}
	public static class Function_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> This() { return getTokens(MplusParser.This); }
		public TerminalNode This(int i) {
			return getToken(MplusParser.This, i);
		}
		public Function_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterFunction_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitFunction_expr(this);
		}
	}
	public static class Bracket_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode This() { return getToken(MplusParser.This, 0); }
		public Bracket_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterBracket_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitBracket_expr(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new Constant_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(167);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new Name_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(Name);
				}
				break;
			case 3:
				{
				_localctx = new Bracket_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__3);
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(170);
					expr(0);
					}
					break;
				case 2:
					{
					setState(171);
					match(This);
					}
					break;
				}
				setState(174);
				match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new Member_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(This);
				setState(176);
				match(T__19);
				setState(177);
				match(Name);
				}
				break;
			case 5:
				{
				_localctx = new Unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				((Unary_exprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
					((Unary_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(179);
				expr(13);
				}
				break;
			case 6:
				{
				_localctx = new New_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(T__24);
				setState(181);
				type(0);
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(182);
						match(T__17);
						setState(184);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
							{
							setState(183);
							expr(0);
							}
						}

						setState(186);
						match(T__18);
						}
						} 
					}
					setState(191);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;
			case 7:
				{
				_localctx = new Assign_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(This);
				setState(193);
				((Assign_exprContext)_localctx).op = match(T__6);
				setState(196);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(194);
					expr(0);
					}
					break;
				case 2:
					{
					setState(195);
					match(This);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(262);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(201);
						((Binary_exprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((Binary_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(202);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(204);
						((Binary_exprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((Binary_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(205);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(207);
						((Binary_exprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((Binary_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(208);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(210);
						((Binary_exprContext)_localctx).op = match(T__30);
						setState(211);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(213);
						((Binary_exprContext)_localctx).op = match(T__31);
						setState(214);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(216);
						((Binary_exprContext)_localctx).op = match(T__32);
						setState(217);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(219);
						((Binary_exprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
							((Binary_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(220);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(222);
						((Binary_exprContext)_localctx).op = match(T__39);
						setState(223);
						expr(5);
						}
						break;
					case 9:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(225);
						((Binary_exprContext)_localctx).op = match(T__40);
						setState(226);
						expr(4);
						}
						break;
					case 10:
						{
						_localctx = new Suffix_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(228);
						((Suffix_exprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((Suffix_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 11:
						{
						_localctx = new Function_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(230);
						match(T__3);
						setState(245);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
							{
							setState(233);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
							case 1:
								{
								setState(231);
								expr(0);
								}
								break;
							case 2:
								{
								setState(232);
								match(This);
								}
								break;
							}
							setState(242);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__5) {
								{
								{
								setState(235);
								match(T__5);
								setState(238);
								_errHandler.sync(this);
								switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
								case 1:
									{
									setState(236);
									expr(0);
									}
									break;
								case 2:
									{
									setState(237);
									match(This);
									}
									break;
								}
								}
								}
								setState(244);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(247);
						match(T__4);
						}
						break;
					case 12:
						{
						_localctx = new Aref_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(249);
						match(T__17);
						setState(250);
						expr(0);
						setState(251);
						match(T__18);
						}
						break;
					case 13:
						{
						_localctx = new Member_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(254);
						match(T__19);
						setState(255);
						match(Name);
						}
						break;
					case 14:
						{
						_localctx = new Assign_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(257);
						((Assign_exprContext)_localctx).op = match(T__6);
						setState(260);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
						case 1:
							{
							setState(258);
							expr(0);
							}
							break;
						case 2:
							{
							setState(259);
							match(This);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolContext extends ConstantContext {
		public BoolContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitBool(this);
		}
	}
	public static class StringContext extends ConstantContext {
		public TerminalNode String() { return getToken(MplusParser.String, 0); }
		public StringContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitString(this);
		}
	}
	public static class NullContext extends ConstantContext {
		public NullContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitNull(this);
		}
	}
	public static class IntContext extends ConstantContext {
		public TerminalNode Integer() { return getToken(MplusParser.Integer, 0); }
		public IntContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitInt(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constant);
		int _la;
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
			case T__42:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				_la = _input.LA(1);
				if ( !(_la==T__41 || _la==T__42) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case Integer:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(Integer);
				}
				break;
			case String:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(String);
				}
				break;
			case T__43:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
				match(T__43);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class True_typeContext extends TypeContext {
		public True_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterTrue_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitTrue_type(this);
		}
	}
	public static class Array_typeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Array_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitArray_type(this);
		}
	}
	public static class My_typeContext extends TypeContext {
		public TerminalNode Name() { return getToken(MplusParser.Name, 0); }
		public My_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterMy_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitMy_type(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__44:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(274);
				match(T__44);
				}
				break;
			case T__45:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(T__45);
				}
				break;
			case T__46:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(T__46);
				}
				break;
			case T__47:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(T__47);
				}
				break;
			case Name:
				{
				_localctx = new My_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(Name);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Array_typeContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(281);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(282);
					match(T__17);
					setState(283);
					match(T__18);
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 16:
			return type_sempred((TypeContext)_localctx, predIndex);
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
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 18);
		case 10:
			return precpred(_ctx, 17);
		case 11:
			return precpred(_ctx, 16);
		case 12:
			return precpred(_ctx, 15);
		case 13:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u0124\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3"+
		"\16\3\65\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\5\6H\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6"+
		"\5\6U\n\6\3\7\3\7\3\7\3\7\3\7\5\7\\\n\7\5\7^\n\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bi\n\b\3\t\3\t\5\tm\n\t\3\t\3\t\3\n\3\n\7\ns\n\n\f\n"+
		"\16\nv\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0081\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u008f\n\16\3"+
		"\16\3\16\5\16\u0093\n\16\3\16\3\16\3\16\5\16\u0098\n\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a4\n\17\3\17\5\17\u00a7\n"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00af\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00bb\n\20\3\20\7\20\u00be\n\20\f"+
		"\20\16\20\u00c1\13\20\3\20\3\20\3\20\3\20\5\20\u00c7\n\20\5\20\u00c9\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ec\n\20\3\20\3\20\3\20\5\20\u00f1"+
		"\n\20\7\20\u00f3\n\20\f\20\16\20\u00f6\13\20\5\20\u00f8\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0107\n\20"+
		"\7\20\u0109\n\20\f\20\16\20\u010c\13\20\3\21\3\21\3\21\3\21\5\21\u0112"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011a\n\22\3\22\3\22\3\22\7\22"+
		"\u011f\n\22\f\22\16\22\u0122\13\22\3\22\2\4\36\"\23\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"\2\t\4\2\22\23\27\32\3\2\34\36\3\2\27\30\3\2\37"+
		" \3\2$)\3\2\22\23\3\2,-\u0155\2\'\3\2\2\2\4+\3\2\2\2\68\3\2\2\2\b=\3\2"+
		"\2\2\nT\3\2\2\2\fV\3\2\2\2\16h\3\2\2\2\20l\3\2\2\2\22p\3\2\2\2\24y\3\2"+
		"\2\2\26\u0082\3\2\2\2\30\u0088\3\2\2\2\32\u008a\3\2\2\2\34\u00a6\3\2\2"+
		"\2\36\u00c8\3\2\2\2 \u0111\3\2\2\2\"\u0119\3\2\2\2$(\5\4\3\2%(\5\b\5\2"+
		"&(\5\f\7\2\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2"+
		"\2\2*\3\3\2\2\2+,\7\3\2\2,-\7\66\2\2-\63\7\4\2\2.\62\5\b\5\2/\62\5\f\7"+
		"\2\60\62\5\6\4\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\5\2\2\67"+
		"\5\3\2\2\289\5\"\22\29:\7\6\2\2:;\7\7\2\2;<\5\22\n\2<\7\3\2\2\2=>\5\""+
		"\22\2>?\7\66\2\2?@\7\6\2\2@A\5\n\6\2AB\7\7\2\2BC\5\22\n\2C\t\3\2\2\2D"+
		"E\5\"\22\2EF\7\66\2\2FH\3\2\2\2GD\3\2\2\2GH\3\2\2\2HU\3\2\2\2IJ\5\"\22"+
		"\2JQ\7\66\2\2KL\7\b\2\2LM\5\"\22\2MN\7\66\2\2NP\3\2\2\2OK\3\2\2\2PS\3"+
		"\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TG\3\2\2\2TI\3\2\2\2U\13"+
		"\3\2\2\2VW\5\"\22\2W]\7\66\2\2X[\7\t\2\2Y\\\5\36\20\2Z\\\7\64\2\2[Y\3"+
		"\2\2\2[Z\3\2\2\2\\^\3\2\2\2]X\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\n\2\2`\r"+
		"\3\2\2\2ai\5\22\n\2bi\5\20\t\2ci\5\24\13\2di\5\32\16\2ei\5\26\f\2fi\5"+
		"\34\17\2gi\5\f\7\2ha\3\2\2\2hb\3\2\2\2hc\3\2\2\2hd\3\2\2\2he\3\2\2\2h"+
		"f\3\2\2\2hg\3\2\2\2i\17\3\2\2\2jm\5\36\20\2km\7\64\2\2lj\3\2\2\2lk\3\2"+
		"\2\2lm\3\2\2\2mn\3\2\2\2no\7\n\2\2o\21\3\2\2\2pt\7\4\2\2qs\5\16\b\2rq"+
		"\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7\5\2\2x"+
		"\23\3\2\2\2yz\7\13\2\2z{\7\6\2\2{|\5\36\20\2|}\7\7\2\2}\u0080\5\30\r\2"+
		"~\177\7\f\2\2\177\u0081\5\30\r\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\25\3\2\2\2\u0082\u0083\7\r\2\2\u0083\u0084\7\6\2\2\u0084\u0085\5\36\20"+
		"\2\u0085\u0086\7\7\2\2\u0086\u0087\5\30\r\2\u0087\27\3\2\2\2\u0088\u0089"+
		"\5\16\b\2\u0089\31\3\2\2\2\u008a\u008b\7\16\2\2\u008b\u008e\7\6\2\2\u008c"+
		"\u008f\5\36\20\2\u008d\u008f\7\64\2\2\u008e\u008c\3\2\2\2\u008e\u008d"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\7\n\2\2\u0091"+
		"\u0093\5\36\20\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0097\7\n\2\2\u0095\u0098\5\36\20\2\u0096\u0098\7\64\2\2"+
		"\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u009a\7\7\2\2\u009a\u009b\5\30\r\2\u009b\33\3\2\2\2\u009c"+
		"\u009d\7\17\2\2\u009d\u00a7\7\n\2\2\u009e\u009f\7\20\2\2\u009f\u00a7\7"+
		"\n\2\2\u00a0\u00a3\7\21\2\2\u00a1\u00a4\5\36\20\2\u00a2\u00a4\7\64\2\2"+
		"\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a7\7\n\2\2\u00a6\u009c\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6"+
		"\u00a0\3\2\2\2\u00a7\35\3\2\2\2\u00a8\u00a9\b\20\1\2\u00a9\u00c9\5 \21"+
		"\2\u00aa\u00c9\7\66\2\2\u00ab\u00ae\7\6\2\2\u00ac\u00af\5\36\20\2\u00ad"+
		"\u00af\7\64\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00c9\7\7\2\2\u00b1\u00b2\7\64\2\2\u00b2\u00b3\7\26\2\2\u00b3"+
		"\u00c9\7\66\2\2\u00b4\u00b5\t\2\2\2\u00b5\u00c9\5\36\20\17\u00b6\u00b7"+
		"\7\33\2\2\u00b7\u00bf\5\"\22\2\u00b8\u00ba\7\24\2\2\u00b9\u00bb\5\36\20"+
		"\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be"+
		"\7\25\2\2\u00bd\u00b8\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2"+
		"\u00bf\u00c0\3\2\2\2\u00c0\u00c9\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3"+
		"\7\64\2\2\u00c3\u00c6\7\t\2\2\u00c4\u00c7\5\36\20\2\u00c5\u00c7\7\64\2"+
		"\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00a8"+
		"\3\2\2\2\u00c8\u00aa\3\2\2\2\u00c8\u00ab\3\2\2\2\u00c8\u00b1\3\2\2\2\u00c8"+
		"\u00b4\3\2\2\2\u00c8\u00b6\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c9\u010a\3\2"+
		"\2\2\u00ca\u00cb\f\r\2\2\u00cb\u00cc\t\3\2\2\u00cc\u0109\5\36\20\16\u00cd"+
		"\u00ce\f\f\2\2\u00ce\u00cf\t\4\2\2\u00cf\u0109\5\36\20\r\u00d0\u00d1\f"+
		"\13\2\2\u00d1\u00d2\t\5\2\2\u00d2\u0109\5\36\20\f\u00d3\u00d4\f\n\2\2"+
		"\u00d4\u00d5\7!\2\2\u00d5\u0109\5\36\20\13\u00d6\u00d7\f\t\2\2\u00d7\u00d8"+
		"\7\"\2\2\u00d8\u0109\5\36\20\n\u00d9\u00da\f\b\2\2\u00da\u00db\7#\2\2"+
		"\u00db\u0109\5\36\20\t\u00dc\u00dd\f\7\2\2\u00dd\u00de\t\6\2\2\u00de\u0109"+
		"\5\36\20\b\u00df\u00e0\f\6\2\2\u00e0\u00e1\7*\2\2\u00e1\u0109\5\36\20"+
		"\7\u00e2\u00e3\f\5\2\2\u00e3\u00e4\7+\2\2\u00e4\u0109\5\36\20\6\u00e5"+
		"\u00e6\f\24\2\2\u00e6\u0109\t\7\2\2\u00e7\u00e8\f\23\2\2\u00e8\u00f7\7"+
		"\6\2\2\u00e9\u00ec\5\36\20\2\u00ea\u00ec\7\64\2\2\u00eb\u00e9\3\2\2\2"+
		"\u00eb\u00ea\3\2\2\2\u00ec\u00f4\3\2\2\2\u00ed\u00f0\7\b\2\2\u00ee\u00f1"+
		"\5\36\20\2\u00ef\u00f1\7\64\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2"+
		"\2\u00f1\u00f3\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2"+
		"\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7"+
		"\u00eb\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u0109\7\7"+
		"\2\2\u00fa\u00fb\f\22\2\2\u00fb\u00fc\7\24\2\2\u00fc\u00fd\5\36\20\2\u00fd"+
		"\u00fe\7\25\2\2\u00fe\u0109\3\2\2\2\u00ff\u0100\f\21\2\2\u0100\u0101\7"+
		"\26\2\2\u0101\u0109\7\66\2\2\u0102\u0103\f\4\2\2\u0103\u0106\7\t\2\2\u0104"+
		"\u0107\5\36\20\2\u0105\u0107\7\64\2\2\u0106\u0104\3\2\2\2\u0106\u0105"+
		"\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u00ca\3\2\2\2\u0108\u00cd\3\2\2\2\u0108"+
		"\u00d0\3\2\2\2\u0108\u00d3\3\2\2\2\u0108\u00d6\3\2\2\2\u0108\u00d9\3\2"+
		"\2\2\u0108\u00dc\3\2\2\2\u0108\u00df\3\2\2\2\u0108\u00e2\3\2\2\2\u0108"+
		"\u00e5\3\2\2\2\u0108\u00e7\3\2\2\2\u0108\u00fa\3\2\2\2\u0108\u00ff\3\2"+
		"\2\2\u0108\u0102\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\37\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0112\t\b\2"+
		"\2\u010e\u0112\7\67\2\2\u010f\u0112\78\2\2\u0110\u0112\7.\2\2\u0111\u010d"+
		"\3\2\2\2\u0111\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112"+
		"!\3\2\2\2\u0113\u0114\b\22\1\2\u0114\u011a\7/\2\2\u0115\u011a\7\60\2\2"+
		"\u0116\u011a\7\61\2\2\u0117\u011a\7\62\2\2\u0118\u011a\7\66\2\2\u0119"+
		"\u0113\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u0118\3\2\2\2\u011a\u0120\3\2\2\2\u011b\u011c\f\3\2\2\u011c"+
		"\u011d\7\24\2\2\u011d\u011f\7\25\2\2\u011e\u011b\3\2\2\2\u011f\u0122\3"+
		"\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121#\3\2\2\2\u0122\u0120"+
		"\3\2\2\2#\')\61\63GQT[]hlt\u0080\u008e\u0092\u0097\u00a3\u00a6\u00ae\u00ba"+
		"\u00bf\u00c6\u00c8\u00eb\u00f0\u00f4\u00f7\u0106\u0108\u010a\u0111\u0119"+
		"\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}