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
		RULE_blockpart = 8, RULE_then_statement = 9, RULE_else_statement = 10, 
		RULE_if_statement = 11, RULE_while_statement = 12, RULE_scope_statement = 13, 
		RULE_for_statement = 14, RULE_skip_statement = 15, RULE_expr = 16, RULE_constant = 17, 
		RULE_type = 18;
	public static final String[] ruleNames = {
		"program", "classpart", "selfpart", "functionpart", "parameter", "difinition", 
		"statement", "expr_statement", "blockpart", "then_statement", "else_statement", 
		"if_statement", "while_statement", "scope_statement", "for_statement", 
		"skip_statement", "expr", "constant", "type"
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
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(41);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(38);
					classpart();
					}
					break;
				case 2:
					{
					setState(39);
					functionpart();
					}
					break;
				case 3:
					{
					setState(40);
					difinition();
					}
					break;
				}
				}
				setState(43); 
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
			setState(45);
			match(T__0);
			setState(46);
			match(Name);
			setState(47);
			match(T__1);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << Name))) != 0)) {
				{
				setState(51);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(48);
					functionpart();
					}
					break;
				case 2:
					{
					setState(49);
					difinition();
					}
					break;
				case 3:
					{
					setState(50);
					selfpart();
					}
					break;
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
			setState(58);
			type(0);
			setState(59);
			match(T__3);
			setState(60);
			match(T__4);
			setState(61);
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
			setState(63);
			type(0);
			setState(64);
			match(Name);
			setState(65);
			match(T__3);
			setState(66);
			parameter();
			setState(67);
			match(T__4);
			setState(68);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << Name))) != 0)) {
					{
					setState(70);
					type(0);
					setState(71);
					match(Name);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(75);
				type(0);
				setState(76);
				match(Name);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(77);
					match(T__5);
					setState(78);
					type(0);
					setState(79);
					match(Name);
					}
					}
					setState(85);
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
			setState(88);
			type(0);
			setState(89);
			match(Name);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(90);
				((DifinitionContext)_localctx).op = match(T__6);
				setState(93);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(91);
					expr(0);
					}
					break;
				case 2:
					{
					setState(92);
					match(This);
					}
					break;
				}
				}
			}

			setState(97);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				blockpart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				expr_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				if_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				for_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				while_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(104);
				skip_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(105);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(108);
				expr(0);
				}
				break;
			case 2:
				{
				setState(109);
				match(This);
				}
				break;
			}
			setState(112);
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
			setState(114);
			match(T__1);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
				{
				{
				setState(115);
				statement();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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

	public static class Then_statementContext extends ParserRuleContext {
		public Scope_statementContext scope_statement() {
			return getRuleContext(Scope_statementContext.class,0);
		}
		public Then_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterThen_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitThen_statement(this);
		}
	}

	public final Then_statementContext then_statement() throws RecognitionException {
		Then_statementContext _localctx = new Then_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_then_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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

	public static class Else_statementContext extends ParserRuleContext {
		public Scope_statementContext scope_statement() {
			return getRuleContext(Scope_statementContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MplusListener ) ((MplusListener)listener).exitElse_statement(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
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

	public static class If_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Then_statementContext then_statement() {
			return getRuleContext(Then_statementContext.class,0);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
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
		enterRule(_localctx, 22, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__8);
			setState(128);
			match(T__3);
			setState(129);
			expr(0);
			setState(130);
			match(T__4);
			setState(131);
			then_statement();
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(132);
				match(T__9);
				setState(133);
				else_statement();
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
		enterRule(_localctx, 24, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__10);
			setState(137);
			match(T__3);
			setState(138);
			expr(0);
			setState(139);
			match(T__4);
			setState(140);
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
		enterRule(_localctx, 26, RULE_scope_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
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
		enterRule(_localctx, 28, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__11);
			setState(145);
			match(T__3);
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(146);
				expr(0);
				}
				break;
			case 2:
				{
				setState(147);
				match(This);
				}
				break;
			}
			setState(150);
			match(T__7);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
				{
				setState(151);
				expr(0);
				}
			}

			setState(154);
			match(T__7);
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(155);
				expr(0);
				}
				break;
			case 2:
				{
				setState(156);
				match(This);
				}
				break;
			}
			setState(159);
			match(T__4);
			setState(160);
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
		enterRule(_localctx, 30, RULE_skip_statement);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(T__12);
				setState(163);
				match(T__7);
				}
				break;
			case T__13:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(T__13);
				setState(165);
				match(T__7);
				}
				break;
			case T__14:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(T__14);
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(167);
					expr(0);
					}
					break;
				case 2:
					{
					setState(168);
					match(This);
					}
					break;
				}
				setState(171);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new Constant_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(175);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new Name_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(Name);
				}
				break;
			case 3:
				{
				_localctx = new Bracket_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(T__3);
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(178);
					expr(0);
					}
					break;
				case 2:
					{
					setState(179);
					match(This);
					}
					break;
				}
				setState(182);
				match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new Member_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(This);
				setState(184);
				match(T__19);
				setState(185);
				match(Name);
				}
				break;
			case 5:
				{
				_localctx = new Unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
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
				setState(187);
				expr(13);
				}
				break;
			case 6:
				{
				_localctx = new New_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(T__24);
				setState(189);
				type(0);
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(190);
						match(T__17);
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
							{
							setState(191);
							expr(0);
							}
						}

						setState(194);
						match(T__18);
						}
						} 
					}
					setState(199);
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
				setState(200);
				match(This);
				setState(201);
				((Assign_exprContext)_localctx).op = match(T__6);
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(202);
					expr(0);
					}
					break;
				case 2:
					{
					setState(203);
					match(This);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(209);
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
						setState(210);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(212);
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
						setState(213);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(215);
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
						setState(216);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(218);
						((Binary_exprContext)_localctx).op = match(T__30);
						setState(219);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(221);
						((Binary_exprContext)_localctx).op = match(T__31);
						setState(222);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(224);
						((Binary_exprContext)_localctx).op = match(T__32);
						setState(225);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(227);
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
						setState(228);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(230);
						((Binary_exprContext)_localctx).op = match(T__39);
						setState(231);
						expr(5);
						}
						break;
					case 9:
						{
						_localctx = new Binary_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(233);
						((Binary_exprContext)_localctx).op = match(T__40);
						setState(234);
						expr(4);
						}
						break;
					case 10:
						{
						_localctx = new Suffix_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(236);
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
						setState(237);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(238);
						match(T__3);
						setState(253);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << This) | (1L << Name) | (1L << Integer) | (1L << String))) != 0)) {
							{
							setState(241);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
							case 1:
								{
								setState(239);
								expr(0);
								}
								break;
							case 2:
								{
								setState(240);
								match(This);
								}
								break;
							}
							setState(250);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__5) {
								{
								{
								setState(243);
								match(T__5);
								setState(246);
								_errHandler.sync(this);
								switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
								case 1:
									{
									setState(244);
									expr(0);
									}
									break;
								case 2:
									{
									setState(245);
									match(This);
									}
									break;
								}
								}
								}
								setState(252);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(255);
						match(T__4);
						}
						break;
					case 12:
						{
						_localctx = new Aref_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(257);
						match(T__17);
						setState(258);
						expr(0);
						setState(259);
						match(T__18);
						}
						break;
					case 13:
						{
						_localctx = new Member_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(262);
						match(T__19);
						setState(263);
						match(Name);
						}
						break;
					case 14:
						{
						_localctx = new Assign_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(265);
						((Assign_exprContext)_localctx).op = match(T__6);
						setState(268);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
						case 1:
							{
							setState(266);
							expr(0);
							}
							break;
						case 2:
							{
							setState(267);
							match(This);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(274);
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
		enterRule(_localctx, 34, RULE_constant);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
			case T__42:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
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
				setState(276);
				match(Integer);
				}
				break;
			case String:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				match(String);
				}
				break;
			case T__43:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(278);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__44:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(282);
				match(T__44);
				}
				break;
			case T__45:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(T__45);
				}
				break;
			case T__46:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(T__46);
				}
				break;
			case T__47:
				{
				_localctx = new True_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(T__47);
				}
				break;
			case Name:
				{
				_localctx = new My_typeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(Name);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
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
					setState(289);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(290);
					match(T__17);
					setState(291);
					match(T__18);
					}
					} 
				}
				setState(296);
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
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 18:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u012c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\6\2,\n\2\r\2\16\2-\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3\66\n\3\f\3\16\39\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6T\n"+
		"\6\f\6\16\6W\13\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\5\7b\n\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\t\3\t\5\tq\n\t\3\t\3\t\3\n\3"+
		"\n\7\nw\n\n\f\n\16\nz\13\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\5\20\u0097\n\20\3\20\3\20\5\20\u009b\n\20\3\20\3\20\3"+
		"\20\5\20\u00a0\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00ac\n\21\3\21\5\21\u00af\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u00b7\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00c3\n\22\3\22\7\22\u00c6\n\22\f\22\16\22\u00c9\13\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00cf\n\22\5\22\u00d1\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f4"+
		"\n\22\3\22\3\22\3\22\5\22\u00f9\n\22\7\22\u00fb\n\22\f\22\16\22\u00fe"+
		"\13\22\5\22\u0100\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u010f\n\22\7\22\u0111\n\22\f\22\16\22\u0114\13"+
		"\22\3\23\3\23\3\23\3\23\5\23\u011a\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u0122\n\24\3\24\3\24\3\24\7\24\u0127\n\24\f\24\16\24\u012a\13\24"+
		"\3\24\2\4\"&\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\t\4\2\22"+
		"\23\27\32\3\2\34\36\3\2\27\30\3\2\37 \3\2$)\3\2\22\23\3\2,-\u015b\2+\3"+
		"\2\2\2\4/\3\2\2\2\6<\3\2\2\2\bA\3\2\2\2\nX\3\2\2\2\fZ\3\2\2\2\16l\3\2"+
		"\2\2\20p\3\2\2\2\22t\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\u0081\3\2\2"+
		"\2\32\u008a\3\2\2\2\34\u0090\3\2\2\2\36\u0092\3\2\2\2 \u00ae\3\2\2\2\""+
		"\u00d0\3\2\2\2$\u0119\3\2\2\2&\u0121\3\2\2\2(,\5\4\3\2),\5\b\5\2*,\5\f"+
		"\7\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\3\3"+
		"\2\2\2/\60\7\3\2\2\60\61\7\66\2\2\61\67\7\4\2\2\62\66\5\b\5\2\63\66\5"+
		"\f\7\2\64\66\5\6\4\2\65\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\669\3\2"+
		"\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7\5\2\2;\5\3\2"+
		"\2\2<=\5&\24\2=>\7\6\2\2>?\7\7\2\2?@\5\22\n\2@\7\3\2\2\2AB\5&\24\2BC\7"+
		"\66\2\2CD\7\6\2\2DE\5\n\6\2EF\7\7\2\2FG\5\22\n\2G\t\3\2\2\2HI\5&\24\2"+
		"IJ\7\66\2\2JL\3\2\2\2KH\3\2\2\2KL\3\2\2\2LY\3\2\2\2MN\5&\24\2NU\7\66\2"+
		"\2OP\7\b\2\2PQ\5&\24\2QR\7\66\2\2RT\3\2\2\2SO\3\2\2\2TW\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2VY\3\2\2\2WU\3\2\2\2XK\3\2\2\2XM\3\2\2\2Y\13\3\2\2\2Z[\5"+
		"&\24\2[a\7\66\2\2\\_\7\t\2\2]`\5\"\22\2^`\7\64\2\2_]\3\2\2\2_^\3\2\2\2"+
		"`b\3\2\2\2a\\\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\n\2\2d\r\3\2\2\2em\5\22"+
		"\n\2fm\5\20\t\2gm\5\30\r\2hm\5\36\20\2im\5\32\16\2jm\5 \21\2km\5\f\7\2"+
		"le\3\2\2\2lf\3\2\2\2lg\3\2\2\2lh\3\2\2\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2"+
		"m\17\3\2\2\2nq\5\"\22\2oq\7\64\2\2pn\3\2\2\2po\3\2\2\2pq\3\2\2\2qr\3\2"+
		"\2\2rs\7\n\2\2s\21\3\2\2\2tx\7\4\2\2uw\5\16\b\2vu\3\2\2\2wz\3\2\2\2xv"+
		"\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\5\2\2|\23\3\2\2\2}~\5\34\17"+
		"\2~\25\3\2\2\2\177\u0080\5\34\17\2\u0080\27\3\2\2\2\u0081\u0082\7\13\2"+
		"\2\u0082\u0083\7\6\2\2\u0083\u0084\5\"\22\2\u0084\u0085\7\7\2\2\u0085"+
		"\u0088\5\24\13\2\u0086\u0087\7\f\2\2\u0087\u0089\5\26\f\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\31\3\2\2\2\u008a\u008b\7\r\2\2\u008b"+
		"\u008c\7\6\2\2\u008c\u008d\5\"\22\2\u008d\u008e\7\7\2\2\u008e\u008f\5"+
		"\34\17\2\u008f\33\3\2\2\2\u0090\u0091\5\16\b\2\u0091\35\3\2\2\2\u0092"+
		"\u0093\7\16\2\2\u0093\u0096\7\6\2\2\u0094\u0097\5\"\22\2\u0095\u0097\7"+
		"\64\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009a\7\n\2\2\u0099\u009b\5\"\22\2\u009a\u0099\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\7\n\2\2\u009d"+
		"\u00a0\5\"\22\2\u009e\u00a0\7\64\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\7\2\2\u00a2"+
		"\u00a3\5\34\17\2\u00a3\37\3\2\2\2\u00a4\u00a5\7\17\2\2\u00a5\u00af\7\n"+
		"\2\2\u00a6\u00a7\7\20\2\2\u00a7\u00af\7\n\2\2\u00a8\u00ab\7\21\2\2\u00a9"+
		"\u00ac\5\"\22\2\u00aa\u00ac\7\64\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\7\n\2\2\u00ae"+
		"\u00a4\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00a8\3\2\2\2\u00af!\3\2\2\2"+
		"\u00b0\u00b1\b\22\1\2\u00b1\u00d1\5$\23\2\u00b2\u00d1\7\66\2\2\u00b3\u00b6"+
		"\7\6\2\2\u00b4\u00b7\5\"\22\2\u00b5\u00b7\7\64\2\2\u00b6\u00b4\3\2\2\2"+
		"\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00d1\7\7\2\2\u00b9\u00ba"+
		"\7\64\2\2\u00ba\u00bb\7\26\2\2\u00bb\u00d1\7\66\2\2\u00bc\u00bd\t\2\2"+
		"\2\u00bd\u00d1\5\"\22\17\u00be\u00bf\7\33\2\2\u00bf\u00c7\5&\24\2\u00c0"+
		"\u00c2\7\24\2\2\u00c1\u00c3\5\"\22\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3"+
		"\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\7\25\2\2\u00c5\u00c0\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00d1\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\64\2\2\u00cb\u00ce\7\t\2\2\u00cc"+
		"\u00cf\5\"\22\2\u00cd\u00cf\7\64\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3"+
		"\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00b0\3\2\2\2\u00d0\u00b2\3\2\2\2\u00d0"+
		"\u00b3\3\2\2\2\u00d0\u00b9\3\2\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00be\3\2"+
		"\2\2\u00d0\u00ca\3\2\2\2\u00d1\u0112\3\2\2\2\u00d2\u00d3\f\r\2\2\u00d3"+
		"\u00d4\t\3\2\2\u00d4\u0111\5\"\22\16\u00d5\u00d6\f\f\2\2\u00d6\u00d7\t"+
		"\4\2\2\u00d7\u0111\5\"\22\r\u00d8\u00d9\f\13\2\2\u00d9\u00da\t\5\2\2\u00da"+
		"\u0111\5\"\22\f\u00db\u00dc\f\n\2\2\u00dc\u00dd\7!\2\2\u00dd\u0111\5\""+
		"\22\13\u00de\u00df\f\t\2\2\u00df\u00e0\7\"\2\2\u00e0\u0111\5\"\22\n\u00e1"+
		"\u00e2\f\b\2\2\u00e2\u00e3\7#\2\2\u00e3\u0111\5\"\22\t\u00e4\u00e5\f\7"+
		"\2\2\u00e5\u00e6\t\6\2\2\u00e6\u0111\5\"\22\b\u00e7\u00e8\f\6\2\2\u00e8"+
		"\u00e9\7*\2\2\u00e9\u0111\5\"\22\7\u00ea\u00eb\f\5\2\2\u00eb\u00ec\7+"+
		"\2\2\u00ec\u0111\5\"\22\6\u00ed\u00ee\f\24\2\2\u00ee\u0111\t\7\2\2\u00ef"+
		"\u00f0\f\23\2\2\u00f0\u00ff\7\6\2\2\u00f1\u00f4\5\"\22\2\u00f2\u00f4\7"+
		"\64\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00fc\3\2\2\2\u00f5"+
		"\u00f8\7\b\2\2\u00f6\u00f9\5\"\22\2\u00f7\u00f9\7\64\2\2\u00f8\u00f6\3"+
		"\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\3\2"+
		"\2\2\u00fe\u00fc\3\2\2\2\u00ff\u00f3\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0111\7\7\2\2\u0102\u0103\f\22\2\2\u0103\u0104\7"+
		"\24\2\2\u0104\u0105\5\"\22\2\u0105\u0106\7\25\2\2\u0106\u0111\3\2\2\2"+
		"\u0107\u0108\f\21\2\2\u0108\u0109\7\26\2\2\u0109\u0111\7\66\2\2\u010a"+
		"\u010b\f\4\2\2\u010b\u010e\7\t\2\2\u010c\u010f\5\"\22\2\u010d\u010f\7"+
		"\64\2\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f\u0111\3\2\2\2\u0110"+
		"\u00d2\3\2\2\2\u0110\u00d5\3\2\2\2\u0110\u00d8\3\2\2\2\u0110\u00db\3\2"+
		"\2\2\u0110\u00de\3\2\2\2\u0110\u00e1\3\2\2\2\u0110\u00e4\3\2\2\2\u0110"+
		"\u00e7\3\2\2\2\u0110\u00ea\3\2\2\2\u0110\u00ed\3\2\2\2\u0110\u00ef\3\2"+
		"\2\2\u0110\u0102\3\2\2\2\u0110\u0107\3\2\2\2\u0110\u010a\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113#\3\2\2\2"+
		"\u0114\u0112\3\2\2\2\u0115\u011a\t\b\2\2\u0116\u011a\7\67\2\2\u0117\u011a"+
		"\78\2\2\u0118\u011a\7.\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a%\3\2\2\2\u011b\u011c\b\24\1\2"+
		"\u011c\u0122\7/\2\2\u011d\u0122\7\60\2\2\u011e\u0122\7\61\2\2\u011f\u0122"+
		"\7\62\2\2\u0120\u0122\7\66\2\2\u0121\u011b\3\2\2\2\u0121\u011d\3\2\2\2"+
		"\u0121\u011e\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122\u0128"+
		"\3\2\2\2\u0123\u0124\f\3\2\2\u0124\u0125\7\24\2\2\u0125\u0127\7\25\2\2"+
		"\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\'\3\2\2\2\u012a\u0128\3\2\2\2#+-\65\67KUX_alpx\u0088\u0096"+
		"\u009a\u009f\u00ab\u00ae\u00b6\u00c2\u00c7\u00ce\u00d0\u00f3\u00f8\u00fc"+
		"\u00ff\u010e\u0110\u0112\u0119\u0121\u0128";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}