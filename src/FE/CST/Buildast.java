package FE.CST;

import FE.AST.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

import Exception.CompliationError;

public class Buildast extends MplusBaseListener{
    public Map<Pair<String, Integer>, Type> FunctionMap = new HashMap<>();
    public Map<Pair<String, Integer>, Type> NameMap = new HashMap<>();
    public Map<String, Integer> ClassMap = new HashMap<>();
    public Map<Pair<String, Integer>, Type> ClassNameMap = new HashMap<>();
    public Map<Pair<String, Integer>, List<Type>> ParaMap = new HashMap<>();
    private Stack id_stack = new Stack();
    ParseTree loop;
    ParseTreeProperty<Node> AstNode = new ParseTreeProperty<>();
    Type functiontype;
    RootNode root;
    int idcnt = 0, id = 0, now_class_id = 0, Error_num = 0, row = 0, col = 0;
    public Buildast(Map<Pair<String, Integer>, Type> a1, Map<Pair<String, Integer>, Type> a2, Map<String, Integer> b1, Map<Pair<String, Integer>, List<Type>> a3) {
        FunctionMap = a1;
        ClassNameMap = a2;
        ClassMap = b1;
        ParaMap = a3;
    }

    private void In() {
        idcnt++;
        id_stack.push(idcnt);
        id = idcnt;
    }

    private void Out() {
        id = (Integer)id_stack.pop();
    }

    Pair<Type, Integer> get_type(String name) {
        for(int i = 0; i < id_stack.size(); i++) {
            if(NameMap.containsKey(new Pair<String, Integer>(name, (Integer)id_stack.get(i)))) {
                Type type = NameMap.get(new Pair<String, Integer>(name, (Integer)id_stack.get(i)));
                return new Pair<Type, Integer>(type, (Integer)id_stack.get(i));
            }
        }
        return new Pair<Type, Integer>(new Type("!*!"), -1);
    }

    Type get(String name, int tmp) {
        Pair<Type, Integer> type = get_type(name);
        Type ttype;
        if(NameMap.containsKey(new Pair<String, Integer>(name, tmp))) {
            ttype = NameMap.get(new Pair<String, Integer>(name, tmp));
            if(tmp > type.b) {
                return ttype;
            }
        }
        return type.a;
    }

    @Override public void enterProgram(MplusParser.ProgramContext ctx) {
        In();
    }

    @Override public void exitProgram(MplusParser.ProgramContext ctx) {
        int n = ctx.getChildCount();
        RootNode tmp = new RootNode();
        for(int i = 0; i < n; i++) {
            tmp.add(AstNode.get(ctx.getChild(i)));
        }
        AstNode.put(ctx, tmp);
        root = tmp;
        if(Error_num > 0) {
            throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
        }
    }

    @Override public void enterClasspart(MplusParser.ClasspartContext ctx) {
        In();
        now_class_id = id;
    }

    @Override public void exitClasspart(MplusParser.ClasspartContext ctx) {
        Out();
        int n = ctx.getChildCount();
        ClassNode tmp = new ClassNode();
        for(int i = 0; i < n; i++) {
            tmp.add(AstNode.get(ctx.getChild(i)));
        }
        AstNode.put(ctx, tmp);
        now_class_id = 0;
    }

    @Override public void enterFunctionpart(MplusParser.FunctionpartContext ctx) {
        functiontype = new Checkconflict().trans(ctx.type().getText());
    }

    @Override public void exitFunctionpart(MplusParser.FunctionpartContext ctx) {
        int n = ctx.getChildCount();
        FunctionNode tmp = new FunctionNode();
        for(int i = 0; i < n; i++) {
            tmp.add(AstNode.get(ctx.getChild(i)));
        }
        tmp.type = functiontype;
        AstNode.put(ctx, tmp);
    }

    @Override public void enterParameter(MplusParser.ParameterContext ctx) { }

    @Override public void exitParameter(MplusParser.ParameterContext ctx) {
        ParaNode t = new ParaNode();
        int n = ctx.getChildCount();
        for(int i = 0; i < n; i++) {
            t.add(AstNode.get(ctx.getChild(i)));
        }
        AstNode.put(ctx, t);
    }

    @Override public void enterDifinition(MplusParser.DifinitionContext ctx) { }

    @Override public void exitDifinition(MplusParser.DifinitionContext ctx) {
        DifiNode tmp = new DifiNode();
        AstNode.put(ctx, tmp);
        Type t = new Checkconflict().trans(ctx.type().getText());
        String name = ctx.Name().getText();
        NameMap.put(new Pair<String, Integer>(name, id), t);
        if(ctx.getChildCount() != 3) {
            ExprNode checktype = (ExprNode) AstNode.get(ctx.getChild(3));
            if(checktype.type.type.compareTo("null") == 0) {
                if(t.len == 0) {
                    throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
                }
            } else if(checktype.type.Compareto(t) == false) {
                throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
            }
        }
    }

    @Override public void enterStatement(MplusParser.StatementContext ctx) {
    }

    @Override public void exitStatement(MplusParser.StatementContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
    }

    @Override public void enterExpr_statement(MplusParser.Expr_statementContext ctx) { }

    @Override public void exitExpr_statement(MplusParser.Expr_statementContext ctx) {
        ExprstmtNode tmp = new ExprstmtNode();
        AstNode.put(ctx, tmp);
    }

    @Override public void enterBlockpart(MplusParser.BlockpartContext ctx) {
        In();
    }

    @Override public void exitBlockpart(MplusParser.BlockpartContext ctx) {
        Out();
        BlockNode tmp = new BlockNode();
        int n = ctx.getChildCount();
        for(int i = 0; i < n; i++) {
            tmp.add(AstNode.get(ctx.getChild(i)));
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterIf_statement(MplusParser.If_statementContext ctx) {
    }

    @Override public void exitIf_statement(MplusParser.If_statementContext ctx) {
        int n = ctx.getChildCount();
        IfNode tmp;
        if(n == 5) {
            ExprNode t1 = (ExprNode)AstNode.get(ctx.getChild(2));
            StmtNode t2 = (StmtNode)AstNode.get(ctx.getChild(4));
            tmp = new IfNode(t1, t2);
        } else {
            ExprNode t1 = (ExprNode)AstNode.get(ctx.getChild(2));
            StmtNode t2 = (StmtNode)AstNode.get(ctx.getChild(4));
            StmtNode t3 = (StmtNode)AstNode.get(ctx.getChild(6));
            tmp = new IfNode(t1, t2, t3);
        }
        if(tmp.condition.type.Compareto(new Type("bool")) == false) {
            throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterWhile_statement(MplusParser.While_statementContext ctx) {
        loop = ctx;
    }

    @Override public void exitWhile_statement(MplusParser.While_statementContext ctx) {
        ExprNode t1 = (ExprNode)AstNode.get(ctx.getChild(2));
        StmtNode t2 = (StmtNode)AstNode.get(ctx.getChild(4));
        WhileNode tmp = new WhileNode(t1, t2);
        if(tmp.condition.type.Compareto(new Type("bool")) == false) {
            throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterFor_statement(MplusParser.For_statementContext ctx) {
        loop = ctx;
    }

    @Override public void exitFor_statement(MplusParser.For_statementContext ctx) {
        int n = ctx.getChildCount();
        ExprNode[] a = new ExprNode[4];
        int cnt = 0;
        for(int i = 0; i < n - 1; i++) {
            Node tmp = AstNode.get(ctx.getChild(i));
            if(tmp instanceof SpaceNode == true) {
                cnt++;
            } else {
                a[cnt - 2] = (ExprNode)tmp;
            }
        }
        if(a[1] != null) {
            if(a[1].type.type.compareTo("bool") != 0) {
                throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
            }
        }
        StmtNode tmp1 = (StmtNode)AstNode.get(ctx.getChild(n - 1));
        ForNode tmp = new ForNode(a[0], a[1], a[2], tmp1);
        AstNode.put(ctx, tmp);
    }


    @Override public void enterContinue(MplusParser.ContinueContext ctx) {}

    @Override public void exitContinue(MplusParser.ContinueContext ctx) {
        AstNode.put(ctx, new ContinueNode(loop));
    }

    @Override public void enterBreak(MplusParser.BreakContext ctx) { }

    @Override public void exitBreak(MplusParser.BreakContext ctx) {
        AstNode.put(ctx, new BreakNode(loop));
    }

    @Override public void enterReturn(MplusParser.ReturnContext ctx) {}

    @Override public void exitReturn(MplusParser.ReturnContext ctx) {
        ReturnNode returnnode;
        if(ctx.getChildCount() == 3) {
            returnnode = new ReturnNode(AstNode.get(ctx.getChild(1)));
        } else {
            returnnode = new ReturnNode(new ExprNode(new Type("void")));
        }
        if(returnnode.check(functiontype) == false) {
            throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, returnnode);
    }

    @Override public void enterUnary_expr(MplusParser.Unary_exprContext ctx) {

    }

    @Override public void exitUnary_expr(MplusParser.Unary_exprContext ctx) {
        OperaNode t = new OperaNode(ctx.op.getText());
        UnaryNode tmp;
        try {
            ExprNode son = (ExprNode)(AstNode.get(ctx.getChild(1)));
            tmp = new UnaryNode(t, son);
        } catch (CompliationError ff) {
            throw new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterAref_expr(MplusParser.Aref_exprContext ctx) { }

    @Override public void exitAref_expr(MplusParser.Aref_exprContext ctx) {

    }

    @Override public void enterMember_expr(MplusParser.Member_exprContext ctx) { }

    @Override public void exitMember_expr(MplusParser.Member_exprContext ctx) { }

    @Override public void enterConstant_expr(MplusParser.Constant_exprContext ctx) { }

    @Override public void exitConstant_expr(MplusParser.Constant_exprContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
        ExprNode e = (ExprNode)AstNode.get(ctx.getChild(0));
    }

    @Override public void enterBinary_expr(MplusParser.Binary_exprContext ctx) { }

    @Override public void exitBinary_expr(MplusParser.Binary_exprContext ctx) { }

    @Override public void enterSuffix_expr(MplusParser.Suffix_exprContext ctx) { }

    @Override public void exitSuffix_expr(MplusParser.Suffix_exprContext ctx) { }

    @Override public void enterNew_expr(MplusParser.New_exprContext ctx) { }

    @Override public void exitNew_expr(MplusParser.New_exprContext ctx) { }

    @Override public void enterAssign_expr(MplusParser.Assign_exprContext ctx) { }

    @Override public void exitAssign_expr(MplusParser.Assign_exprContext ctx) { }

    @Override public void enterName_expr(MplusParser.Name_exprContext ctx) { }

    @Override public void exitName_expr(MplusParser.Name_exprContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
    }

    @Override public void enterFunction_expr(MplusParser.Function_exprContext ctx) { }

    @Override public void exitFunction_expr(MplusParser.Function_exprContext ctx) { }

    @Override public void enterBracket_expr(MplusParser.Bracket_exprContext ctx) { }

    @Override public void exitBracket_expr(MplusParser.Bracket_exprContext ctx) { }

    @Override public void enterBool(MplusParser.BoolContext ctx) { }

    @Override public void exitBool(MplusParser.BoolContext ctx) {
        Type tt = new Type("bool");
        ConstNode tmp = new ConstNode(tt, " ");
        AstNode.put(ctx, tmp);
    }

    @Override public void enterInt(MplusParser.IntContext ctx) { }

    @Override public void exitInt(MplusParser.IntContext ctx) {
        Type tt = new Type("int");
        ConstNode tmp = new ConstNode(tt, " ");
        AstNode.put(ctx, tmp);
    }

    @Override public void enterString(MplusParser.StringContext ctx) { }

    @Override public void exitString(MplusParser.StringContext ctx) {
        Type tt = new Type("string");
        ConstNode tmp = new ConstNode(tt, " ");
        AstNode.put(ctx, tmp);
    }

    @Override public void enterNull(MplusParser.NullContext ctx) { }

    @Override public void exitNull(MplusParser.NullContext ctx) {
        Type tt = new Type("null");
        ConstNode tmp = new ConstNode(tt, " ");
        AstNode.put(ctx, tmp);
    }

    @Override public void enterTrue_type(MplusParser.True_typeContext ctx) { }

    @Override public void exitTrue_type(MplusParser.True_typeContext ctx) {
        AstNode.put(ctx, new SpaceNode());
    }

    @Override public void enterArray_type(MplusParser.Array_typeContext ctx) {

    }

    @Override public void exitArray_type(MplusParser.Array_typeContext ctx) { }

    @Override public void enterEveryRule(ParserRuleContext ctx) {
        row = ctx.getStart().getLine();
        col = ctx.getStart().getCharPositionInLine();
    }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitTerminal(TerminalNode node) {
        String t = node.getText();

        if(t.equals("{") || t.equals("}") || t.equals("(") || t.equals(")")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals(";") || t.equals(",")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals("int") || t.equals("void") || t.equals("string")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals("bool") || t.equals("if") || t.equals("while") || t.equals("for")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals("break") || t.equals("continue") || t.equals("return")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals("new") || t.equals("class") || t.equals("main")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }

        if(t.equals("true") || t.equals("false")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        char c = t.charAt(0);
        if(Character.isLetter(c)) {
            Type tt = get(t, now_class_id);
            if(tt.type.equals("!+!") == true) {
                Error_num++;
            }
            BasicNode tmp = new BasicNode(tt, t);
            AstNode.put(node, tmp);
        }
    }

    @Override public void visitErrorNode(ErrorNode node) { }

}
