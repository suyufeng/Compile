// Generated from Mplus.g4 by ANTLR 4.6
package FE.CST;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MplusParser}.
 */
public interface MplusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MplusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MplusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MplusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#classpart}.
	 * @param ctx the parse tree
	 */
	void enterClasspart(MplusParser.ClasspartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#classpart}.
	 * @param ctx the parse tree
	 */
	void exitClasspart(MplusParser.ClasspartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#selfpart}.
	 * @param ctx the parse tree
	 */
	void enterSelfpart(MplusParser.SelfpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#selfpart}.
	 * @param ctx the parse tree
	 */
	void exitSelfpart(MplusParser.SelfpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#functionpart}.
	 * @param ctx the parse tree
	 */
	void enterFunctionpart(MplusParser.FunctionpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#functionpart}.
	 * @param ctx the parse tree
	 */
	void exitFunctionpart(MplusParser.FunctionpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MplusParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MplusParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#difinition}.
	 * @param ctx the parse tree
	 */
	void enterDifinition(MplusParser.DifinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#difinition}.
	 * @param ctx the parse tree
	 */
	void exitDifinition(MplusParser.DifinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MplusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MplusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#expr_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpr_statement(MplusParser.Expr_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#expr_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpr_statement(MplusParser.Expr_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#blockpart}.
	 * @param ctx the parse tree
	 */
	void enterBlockpart(MplusParser.BlockpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#blockpart}.
	 * @param ctx the parse tree
	 */
	void exitBlockpart(MplusParser.BlockpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MplusParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MplusParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(MplusParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(MplusParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#scope_statement}.
	 * @param ctx the parse tree
	 */
	void enterScope_statement(MplusParser.Scope_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#scope_statement}.
	 * @param ctx the parse tree
	 */
	void exitScope_statement(MplusParser.Scope_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MplusParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(MplusParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MplusParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(MplusParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue}
	 * labeled alternative in {@link MplusParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue(MplusParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link MplusParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue(MplusParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link MplusParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak(MplusParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link MplusParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak(MplusParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link MplusParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MplusParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link MplusParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MplusParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MplusParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MplusParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aref_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAref_expr(MplusParser.Aref_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aref_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAref_expr(MplusParser.Aref_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code member_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMember_expr(MplusParser.Member_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code member_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMember_expr(MplusParser.Member_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expr(MplusParser.Constant_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expr(MplusParser.Constant_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binary_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expr(MplusParser.Binary_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binary_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expr(MplusParser.Binary_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffix_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuffix_expr(MplusParser.Suffix_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffix_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuffix_expr(MplusParser.Suffix_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNew_expr(MplusParser.New_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNew_expr(MplusParser.New_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(MplusParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(MplusParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code name_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterName_expr(MplusParser.Name_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code name_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitName_expr(MplusParser.Name_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction_expr(MplusParser.Function_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction_expr(MplusParser.Function_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracket_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracket_expr(MplusParser.Bracket_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracket_expr}
	 * labeled alternative in {@link MplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracket_expr(MplusParser.Bracket_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBool(MplusParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBool(MplusParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterInt(MplusParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitInt(MplusParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterString(MplusParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitString(MplusParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNull(MplusParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null}
	 * labeled alternative in {@link MplusParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNull(MplusParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true_type}
	 * labeled alternative in {@link MplusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTrue_type(MplusParser.True_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true_type}
	 * labeled alternative in {@link MplusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTrue_type(MplusParser.True_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_type}
	 * labeled alternative in {@link MplusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArray_type(MplusParser.Array_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_type}
	 * labeled alternative in {@link MplusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArray_type(MplusParser.Array_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code my_type}
	 * labeled alternative in {@link MplusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMy_type(MplusParser.My_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code my_type}
	 * labeled alternative in {@link MplusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMy_type(MplusParser.My_typeContext ctx);
}