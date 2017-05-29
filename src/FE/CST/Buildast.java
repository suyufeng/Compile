package FE.CST;

import FE.AST.*;
import FE.AST.Expr.*;
import FE.AST.Stmt.*;
import jdk.nashorn.internal.ir.FunctionCall;
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
    public Map<Pair<Integer, String>, Integer> Classindex = new HashMap<>();
    public Map<Integer, Boolean> Haveselfpart = new HashMap<>();
    public Map<Integer, Integer> Classnum = new HashMap<>();
    public List<String> pattern = new ArrayList<>();
    private Stack id_stack = new Stack();
    ParseTree loop;
    public ParseTreeProperty<Node> AstNode = new ParseTreeProperty<>();
    Type functiontype;
    RootNode root;
    String classname;
    int tmp1;
    int idcnt = 1, id = 1, now_class_id = 0, Error_num = 0, row = 0, col = 0;
    int clac = 0;
    Boolean have_int_main = false;
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
        id_stack.pop();
        id = (Integer)id_stack.peek();
    }

    Pair<Type, Integer> get_type(String name) {
        for(int i = id_stack.size() - 1; i >= 0; i--) {
            if(NameMap.containsKey(new Pair<String, Integer>(name, (Integer)id_stack.get(i)))) {
                Type type = NameMap.get(new Pair<String, Integer>(name, (Integer)id_stack.get(i)));
                return new Pair<Type, Integer>(type, (Integer)id_stack.get(i));
            }
        }
        return new Pair<Type, Integer>(new Type("!+!", 1000000), -1);
    }

    Pair<Type, Integer> get(String name, int tmp) {
        Pair<Type, Integer> type = get_type(name);
        Type ttype;
        if(ClassNameMap.containsKey(new Pair<String, Integer>(name, tmp))) {
            ttype = ClassNameMap.get(new Pair<String, Integer>(name, tmp));
            if(tmp > type.b) {
                return new Pair<Type, Integer> (ttype, tmp);
            }
        }
        return new Pair<Type, Integer> (type.a, type.b);
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
        if(Error_num > 0 || have_int_main == false) {
            throw new CompliationError("82CompliationError on line: " + row + " column: " + col + " !");
        }
    }

    @Override public void enterClasspart(MplusParser.ClasspartContext ctx) {
        In();
        now_class_id = id;
        classname = ctx.Name().getText();
        clac = 0;
    }

    @Override public void exitClasspart(MplusParser.ClasspartContext ctx) {
        ExprNode son = (ExprNode) AstNode.get(ctx.getChild(1));
        if(!(son instanceof SpaceNode) && son.type.type.compareTo("!+!") == 0) {
            Error_num--;
        }
        Out();
        int n = ctx.getChildCount();
        ClassNode tmp = new ClassNode();
        for(int i = 0; i < n; i++) {
            tmp.add(AstNode.get(ctx.getChild(i)));
        }
        Classnum.put(now_class_id, clac + 1);
        AstNode.put(ctx, tmp);
        now_class_id = 0;
    }

    @Override public void enterFunctionpart(MplusParser.FunctionpartContext ctx) {
        functiontype = new Checkconflict().trans(ctx.type().getText());
        if(ctx.getChild(1).getText().compareTo("main") == 0) {
            if(ctx.getChild(0).getText().compareTo("int") == 0) {
                if(id == 2) {
                    have_int_main = true;
                }
            }
        }
    }

    @Override public void exitFunctionpart(MplusParser.FunctionpartContext ctx) {
        ExprNode son = (ExprNode) AstNode.get(ctx.getChild(1));
        if(!(son instanceof SpaceNode) && son.type.type.compareTo("!+!") == 0) {
            Error_num--;
        }
        int n = ctx.getChildCount();
        FunctionNode tmp = new FunctionNode();
        for(int i = 0; i < n; i++) {
            tmp.add(AstNode.get(ctx.getChild(i)));
        }
        tmp.type = functiontype;
        AstNode.put(ctx, tmp);
    }

    @Override public void enterParameter(MplusParser.ParameterContext ctx) {
        List<TerminalNode> ListName = ctx.Name();
        List<MplusParser.TypeContext> typeName = ctx.type();
        List<Type> type_list = new ArrayList();
        tmp1 = Error_num;
        for(int i = 0; i < ListName.size(); i++) {
            String name = ListName.get(i).getSymbol().getText();
            String ttype = typeName.get(i).getText();
            Type type = new Checkconflict().trans(ttype);
            type_list.add(type);
            Pair<String, Integer> pair = new Pair<String, Integer>(name, id);
            pair = new Pair<String, Integer>(name, idcnt + 1);
            NameMap.put(pair, type);
        }
    }

    @Override public void exitParameter(MplusParser.ParameterContext ctx) {
        ParaNode t = new ParaNode();
        int n = ctx.getChildCount();
        for(int i = 0; i < n; i++) {
            t.add(AstNode.get(ctx.getChild(i)));
        }
        AstNode.put(ctx, t);
        Error_num = tmp1;
    }

    @Override public void enterDifinition(MplusParser.DifinitionContext ctx) { }

    @Override public void exitDifinition(MplusParser.DifinitionContext ctx) {
        Type t = new Checkconflict().trans(ctx.type().getText());
        ExprNode son = (ExprNode) AstNode.get(ctx.getChild(1));
        if(!(son instanceof SpaceNode) && son.type.type.compareTo("!+!") == 0) {
            Error_num--;
        }
        if(t.type.compareTo("void") == 0) {
            throw new CompliationError("160CompliationError on line: " + row + " column: " + col + " !");
        }

        DifiNode tmp = new DifiNode();
        AstNode.put(ctx, tmp);
        String name = ctx.Name().getText();
        if(now_class_id != 2 && now_class_id == id) {
            Classindex.put(new Pair<Integer, String>(id, name), ++clac);
        }
        NameMap.put(new Pair<String, Integer>(name, id), t);
        if(ctx.getChildCount() != 3) {
            ExprNode checktype = (ExprNode) AstNode.get(ctx.getChild(3));
            if(checktype.type.type.compareTo("null") == 0) {
                if(t.len == 0) {
                    int tmpp = ClassMap.get(t.type);
                    if(tmpp <= 2) {
                        throw new CompliationError("187CompliationError on line: " + row + " column: " + col + " !");
                    }
                }
            } else if(checktype.type.Compareto(t) == false) {
                throw new CompliationError("170CompliationError on line: " + row + " column: " + col + " !");
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
        if (ctx.getChildCount() == 2) {
            Node tmp = AstNode.get(ctx.getChild(0));
            ExprstmtNode tmp1 = new ExprstmtNode((ExprNode)tmp);
            AstNode.put(ctx, tmp1);
        } else {
            ExprstmtNode tmp1 = new ExprstmtNode((ExprNode)AstNode.get(ctx.getChild(0)));
            AstNode.put(ctx, tmp1);
        }
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

    @Override public void exitThen_statement(MplusParser.Then_statementContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
    }

    @Override public void exitElse_statement(MplusParser.Else_statementContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
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
            throw new CompliationError("220CompliationError on line: " + row + " column: " + col + " !");
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
            throw new CompliationError("234CompliationError on line: " + row + " column: " + col + " !");
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
                throw new CompliationError("257CompliationError on line: " + row + " column: " + col + " !");
            }
        }
        StmtNode tmp1 = (StmtNode)AstNode.get(ctx.getChild(n - 1));
        ForNode tmp = new ForNode(a[0], a[1], a[2], tmp1);
        AstNode.put(ctx, tmp);
    }

    @Override public void enterScope_statement(MplusParser.Scope_statementContext ctx) {
        In();
    }

    @Override public void exitScope_statement(MplusParser.Scope_statementContext ctx) {
        Out();
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
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
            throw new CompliationError("288CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, returnnode);
    }

    @Override public void enterSelfpart(MplusParser.SelfpartContext ctx) {
        functiontype = new Type("void");
    }

    @Override public void exitSelfpart(MplusParser.SelfpartContext ctx) {
        SelfNode tmp = new SelfNode((StmtNode)AstNode.get(ctx.getChild(3)));
        Haveselfpart.put(now_class_id, true);
        String classnamep = ctx.getChild(0).getText();
        if(ClassMap.containsKey(classnamep)) {
            int t = ClassMap.get(classnamep);
            if(t != now_class_id) {
                throw new CompliationError("303CompliationError on line: " + row + " column: " + col + " !");
            }
        } else {
            throw new CompliationError("304CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterUnary_expr(MplusParser.Unary_exprContext ctx) {

    }

    @Override public void exitUnary_expr(MplusParser.Unary_exprContext ctx) {
        OperaNode t = new OperaNode(ctx.op.getText());
        UnaryNode tmp;
        ExprNode son = (ExprNode)(AstNode.get(ctx.getChild(1)));
        if(t.s.equals("++") || t.s.equals("--")) {
            if (!(son instanceof BasicNode) && !(son instanceof ArefNode) && !(son instanceof MemNode)) {
                throw new CompliationError("345CompliationError on line: " + row + " column: " + col + " !");
            }
            if (son instanceof ConstNode) {
                throw new CompliationError("348CompliationError on line: " + row + " column: " + col + " !");
            }
        }
        try {
            tmp = new UnaryNode(t, son);
        } catch (CompliationError ff) {
            throw new CompliationError("320CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterAref_expr(MplusParser.Aref_exprContext ctx) { }

    @Override public void exitAref_expr(MplusParser.Aref_exprContext ctx) {
        ArefNode tmp;
        Node son_left = AstNode.get(ctx.getChild(0));
        tmp = new ArefNode((ExprNode)son_left);
        if(tmp.type.len < 0) {
            throw new CompliationError("332CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterMember_expr(MplusParser.Member_exprContext ctx) {

    }

    @Override public void exitMember_expr(MplusParser.Member_exprContext ctx) {
        ExprNode left = (ExprNode)AstNode.get(ctx.getChild(0));
        ExprNode right = (ExprNode)AstNode.get(ctx.getChild(2));
        if(left.type.type.compareTo("!+!") == 0) {
            throw new CompliationError("345CompliationError on line: " + row + " column: " + col + " !");
        }
        Integer classid = ClassMap.get(left.type.type);
        if(classid == 0 && (left.type.len == 0 && left.type.type.equals("string") == false)) {
            throw new CompliationError("349CompliationError on line: " + row + " column: " + col + " !");
        }
        MemNode tmp = new MemNode(left, right);
        tmp.origin = classid;
        BasicNode tmp1 = (BasicNode)right;
        if(ClassNameMap.containsKey(new Pair<String, Integer>(tmp1.name, classid))
                && !FunctionMap.containsKey(new Pair<String, Integer>(tmp1.name, classid))) {
            Type type = ClassNameMap.get(new Pair<String, Integer>(tmp1.name, classid));
            tmp.type = type;
            if(right.type.type.compareTo("!+!") == 0) {
                Error_num--;
            }
        } else {
            tmp.type = new Type("!+!", 1000000);
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterConstant_expr(MplusParser.Constant_exprContext ctx) { }

    @Override public void exitConstant_expr(MplusParser.Constant_exprContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
        ExprNode e = (ExprNode)AstNode.get(ctx.getChild(0));
    }

    @Override public void enterBinary_expr(MplusParser.Binary_exprContext ctx) { }

    @Override public void exitBinary_expr(MplusParser.Binary_exprContext ctx) {
        ExprNode left = (ExprNode)AstNode.get(ctx.getChild(0));
        ExprNode right = (ExprNode)AstNode.get(ctx.getChild(2));
        String t = ctx.getChild(1).getText();
        BinaryOpNode tmp;
        try {
            tmp = new BinaryOpNode(left, t , right);
        } catch (CompliationError e) {
            throw new CompliationError("414CompliationError on line: " + row + " column: " + col + " !");
        }
        if(left.type.type.equals("string")) {
            FuncallNode tt = new FuncallNode();
            tt.son_ad.add(left);
            tt.son_ad.add(right);
            tt.label = 0;
            tt.type = new Type("bool");
            if(t.equals("+")) {
               tt.name = "Sadd";
               tt.type = new Type("string");
            } else if(t.equals("<")) {
                tt.name = "Slt";
            } else if(t.equals("<=")) {
                tt.name = "Sle";
            } else if(t.equals("==")) {
                tt.name = "Seq";
            } else if(t.equals("!=")) {
                tt.name = "Sne";
            } else if(t.equals(">")) {
                tt.name = "Sgt";
            } else if(t.equals(">=")) {
                tt.name = "Sge";
            }
            AstNode.put(ctx, tt);
        } else {
            AstNode.put(ctx, tmp);
        }
    }

    @Override public void enterSuffix_expr(MplusParser.Suffix_exprContext ctx) { }

    @Override public void exitSuffix_expr(MplusParser.Suffix_exprContext ctx) {
        ExprNode left = (ExprNode)AstNode.get(ctx.getChild(0));
        if(left.type.type.compareTo("int") != 0) {
            throw new CompliationError("451CompliationError on line: " + row + " column: " + col + " !");
        }
        if(!(left instanceof BasicNode) && !(left instanceof ArefNode) && !(left instanceof MemNode)) {
            throw new CompliationError("454CompliationError on line: " + row + " column: " + col + " !");
        }
        if(left instanceof ConstNode) {
            throw new CompliationError("557CompliationError on line: " + row + " column: " + col + " !");
        }
        OperaNode op = new OperaNode(ctx.getChild(1).getText());
        SufNode tmp = new SufNode(left, op);
        AstNode.put(ctx, tmp);
    }

    @Override public void enterMy_type(MplusParser.My_typeContext ctx) { }

    @Override public void exitMy_type(MplusParser.My_typeContext ctx) {
        BasicNode t = (BasicNode)AstNode.get(ctx.getChild(0));
        AstNode.put(ctx, t);
        if(t.type.type.compareTo("!+!") == 0) {
            Error_num--;
            if(ClassMap.containsKey(t.name) == false) {
                throw new CompliationError("439CompliationError on line: " + row + " column: " + col + " !");
            }
        }
    }

    @Override public void enterNew_expr(MplusParser.New_exprContext ctx) { }

    @Override public void exitNew_expr(MplusParser.New_exprContext ctx) {
        int n = ctx.getChildCount();
        String str = ctx.type().getText();
        Type type = new Checkconflict().trans(str);
        Boolean flag = true;
        Integer num = 0;
        NewNode tmp = new NewNode();
        for(int i = 2, j; i < n; i = j + 1) {
            j = i;
            while(true) {
                Node son = AstNode.get(ctx.getChild(j));
                if(son instanceof SpaceNode) {
                    num++;
                    break;
                }
                j++;
                if(j >= n) {
                    break;
                }
            }
            if(j + 1 < n) {
                Node son = AstNode.get(ctx.getChild(j + 1));
                if(!(son instanceof SpaceNode)) {
                    tmp.son.add((ExprNode) AstNode.get(ctx.getChild(j + 1)));
                }
            }
            if(j - i == 2) {
                if(flag == true) {
                    flag = false;
                }
            }
            if(j - i == 3) {
                if(flag == false) {
                    new CompliationError("CompliationError on line: " + row + " column: " + col + " !");
                }
            }
        }
        type.len = num / 2;
        tmp.type = type;
        AstNode.put(ctx, tmp);
    }

    @Override public void enterAssign_expr(MplusParser.Assign_exprContext ctx) { }

    @Override public void exitAssign_expr(MplusParser.Assign_exprContext ctx) {
        Node left = AstNode.get(ctx.getChild(0));
        Node right = AstNode.get(ctx.getChild(2));
        if(!(left instanceof BasicNode) && !(left instanceof ArefNode) && !(left instanceof MemNode)) {
            throw new CompliationError("488CompliationError on line: " + row + " column: " + col + " !");
        }
        if(left instanceof ConstNode) {
            throw new CompliationError("503CompliationError on line: " + row + " column: " + col + " !");
        }
        AssiNode tmp;
        try {
            tmp = new AssiNode((ExprNode) left, (ExprNode) right);
        } catch (CompliationError t) {
            throw new CompliationError("494CompliationError on line: " + row + " column: " + col + " !");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterName_expr(MplusParser.Name_exprContext ctx) { }

    @Override public void exitName_expr(MplusParser.Name_exprContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
    }

    @Override public void enterFunction_expr(MplusParser.Function_exprContext ctx) {

    }

    @Override public void exitFunction_expr(MplusParser.Function_exprContext ctx) {
        Node left = AstNode.get(ctx.getChild(0));
        List<Type> list = new ArrayList();
        List<ExprNode> list1 = new ArrayList<>();
        int n = ctx.getChildCount();
        for(int i = 2; i < n; i += 2) {
            if(i == n - 1) {
                break;
            }
            ExprNode son = (ExprNode)AstNode.get(ctx.getChild(i));
            Type CC = son.type;
            list.add(CC);
            list1.add(son);
        }
        if(left instanceof ConstNode || left instanceof ArefNode) {
            throw new CompliationError("517CompliationError on line: " + row + " column: " + col + " !");
        }
        int classid = 2;
        BasicNode tmp1;

        if(!(left instanceof BasicNode)) {
            tmp1 = (BasicNode)AstNode.get(ctx.getChild(0).getChild(2));
            ExprNode tmp = (ExprNode) AstNode.get(ctx.getChild(0).getChild(0));
            if(tmp.type.type.compareTo("!+!") == 0) {
                throw new CompliationError("526CompliationError on line: " + row + " column: " + col + " !");
            } else {
                classid = ClassMap.get(tmp.type.type);
            }
            if(tmp.type.len > 0) {
                BasicNode rr = (BasicNode) AstNode.get(ctx.getChild(0).getChild(2));
                if(rr.name.compareTo("size") == 0) {
                    FuncallNode ttmp = new FuncallNode();
                    ttmp.label = 2;
                    ttmp.name = "size";
                    ttmp.son_ad.add((ExprNode)AstNode.get(ctx.getChild(0).getChild(0)));
                    ttmp.type = new Type("int");
                    if(rr.type.type.compareTo("!+!") == 0) {
                        Error_num--;
                    }
                    AstNode.put(ctx, ttmp);
                    return ;
                } else {
                    throw new CompliationError("568CompliationError on line: " + row + " column: " + col + " !");
                }
            }
        } else {
            tmp1 = (BasicNode)left;
            if(now_class_id != 0) {
                if(FunctionMap.containsKey(new Pair<String, Integer>(tmp1.name, now_class_id))) {
                    classid = now_class_id;
                }
            }
        }
        List<Type> list2;
        if(!FunctionMap.containsKey(new Pair<String, Integer>(tmp1.name, classid))) {
            throw new CompliationError("547CompliationError on line: " + row + " column: " + col + " !");
        } else {
            list2 = ParaMap.get(new Pair<String, Integer>(tmp1.name, classid));
            int c = list.size();
            if(c != list2.size()) {
                throw new CompliationError("552CompliationError on line: " + row + " column: " + col + " !");
            }
            for(int i = 0; i < c; i++) {
                if(!list.get(i).Compareto(list2.get(i))) {
                    if(list.get(i).type.compareTo("null") == 0) {
                        if(list2.get(i).len > 0) {
                            continue;
                        }
                        int t = ClassMap.get(list2.get(i).type);
                        if(t > 2) {
                            continue;
                        }
                    }
                    throw new CompliationError("557CompliationError on line: " + row + " column: " + col + " !");
                }
            }
        }
        if(tmp1.type.type.compareTo("!+!") == 0) {
            Error_num--;
        }
        Type type = FunctionMap.get(new Pair<String, Integer>(tmp1.name, classid));
        FuncallNode ttmp = new FuncallNode(list2, type);
        ttmp.son_ad = list1;
        ttmp.label = classid;
        ttmp.name = tmp1.name;
        AstNode.put(ctx, ttmp);
    }

    @Override public void enterBracket_expr(MplusParser.Bracket_exprContext ctx) { }

    @Override public void exitBracket_expr(MplusParser.Bracket_exprContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(1)));
    }

    @Override public void enterBool(MplusParser.BoolContext ctx) { }

    @Override public void exitBool(MplusParser.BoolContext ctx) {
        Type tt = new Type("bool");
        ConstNode tmp;
        if(ctx.getText().equals("true")) {
            tmp = new ConstNode(tt, " ", "1");
        } else {
            tmp = new ConstNode(tt, " ", "0");
        }
        AstNode.put(ctx, tmp);
    }

    @Override public void enterInt(MplusParser.IntContext ctx) { }

    @Override public void exitInt(MplusParser.IntContext ctx) {
        Type tt = new Type("int");
        int num =  Integer.parseInt(ctx.getText());
        ConstNode tmp = new ConstNode(tt, " ", ctx.getText());
        AstNode.put(ctx, tmp);
    }

    @Override public void enterString(MplusParser.StringContext ctx) { }

    @Override public void exitString(MplusParser.StringContext ctx) {
        Type tt = new Type("string");
        ConstNode tmp = new ConstNode(tt, " ", "string" + Integer.toString(pattern.size()));
        String t = "";
        for(int i = 1; i + 1 < ctx.getText().length(); i++) {
            t += ctx.getText().charAt(i);
        }
        pattern.add(t);
        AstNode.put(ctx, tmp);
    }

    @Override public void enterNull(MplusParser.NullContext ctx) { }

    @Override public void exitNull(MplusParser.NullContext ctx) {
        Type tt = new Type("null");
        ConstNode tmp = new ConstNode(tt, " ", ctx.getText());
        AstNode.put(ctx, tmp);
    }

    @Override public void enterTrue_type(MplusParser.True_typeContext ctx) { }

    @Override public void exitTrue_type(MplusParser.True_typeContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
    }

    @Override public void enterArray_type(MplusParser.Array_typeContext ctx) {

    }

    @Override public void exitArray_type(MplusParser.Array_typeContext ctx) {
        AstNode.put(ctx, AstNode.get(ctx.getChild(0)));
    }

    @Override public void enterEveryRule(ParserRuleContext ctx) {
        row = ctx.getStart().getLine();
        col = ctx.getStart().getCharPositionInLine();
    }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitTerminal(TerminalNode node) {
        String t = node.getText();
        if(t.equals("{") || t.equals("}") || t.equals("(") || t.equals(")") || t.equals("[") || t.equals("]")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals(";") || t.equals(",") || t.equals("null")) {
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
        if(t.equals("new") || t.equals("class") || t.equals("main") || t.equals("else")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }

        if(t.equals("true") || t.equals("false")) {
            AstNode.put(node, new SpaceNode());
            return ;
        }
        if(t.equals("this")) {
            if(now_class_id == 2) {
                throw new CompliationError("660CompliationError on line: " + row + " column: " + col + " !");
            } else {
                Type type = new Type(classname);
                NameMap.put(new Pair<String, Integer>("this", now_class_id), type);
                AstNode.put(node, new ThisNode(type, "this"));
            }
            return ;
        }
        char c = t.charAt(0);
        if(Character.isLetter(c)) {
            Pair<Type, Integer> tt = get(t, now_class_id);
            if(tt.a.type.equals("!+!") == true) {
                Error_num++;
            }

            BasicNode tmp = new BasicNode(tt.a, t);
            tmp.belong = tt.b;
            AstNode.put(node, tmp);
        }
    }

    @Override public void visitErrorNode(ErrorNode node) { }

}
