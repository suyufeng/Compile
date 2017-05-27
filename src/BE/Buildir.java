package BE;

import FE.AST.Expr.*;
import FE.AST.Node;
import FE.AST.Stmt.ForNode;
import FE.AST.Stmt.IfNode;
import FE.AST.Stmt.WhileNode;
import FE.AST.Type;
import FE.CST.Checkconflict;
import FE.CST.MplusBaseListener;
import FE.CST.MplusParser;
import FE.AST.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

/**
 * Created by suyufeng on 17-4-4.
 */
public class Buildir extends MplusBaseListener {
    ParseTreeProperty<Node> AstNode;
    public Map<String, Integer> ClassMap;
    int start = 0;
    Map<Node, Ir> reflict = new HashMap();
    public Map<Integer, Label> FunctionLabel= new HashMap<>();
    public Map<Pair<String, Integer>, Address> Name2register = new HashMap<>();
    public Map<Pair<Integer, String>, Integer> Classindex = new HashMap<>();
    public Map<Pair<String, Integer>, Type> NameMap = new HashMap<>();
    public Map<Address, Integer> String2register = new HashMap<>();
    public Map<Integer, Integer> Classnum = new HashMap<>();
    public List<Integer> globel = new ArrayList<>();
    public Buildir(ParseTreeProperty a2, Map<String, Integer> a3, Map<Pair<Integer, String>, Integer> b1, Map<Pair<String, Integer>, Type> b2, Map<Integer, Integer> b3) {
        AstNode = a2;
        ClassMap = a3;
        Classindex = b1;
        NameMap = b2;
        Classnum = b3;
    }
    int idcnt = 1, id = 1, now_class_id = 0;
    int register_num = 0, globelnum = 0;
    int catch_num = 0, clac = 0;
    private Stack id_stack = new Stack();
    public List procedure = new ArrayList();
    Address thisaddress;

    private void In() {
        idcnt++;
        id_stack.push(idcnt);
        id = idcnt;
        start = procedure.size();
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

    int get(String name, int tmp) {
        Pair<Type, Integer> type = get_type(name);
        Type ttype;
        if(Classindex.containsKey(new Pair<Integer, String>(tmp, name))) {
            if(tmp > type.b) {
                return tmp;
            }
        }
        return type.b;
    }

    @Override public void enterProgram(MplusParser.ProgramContext ctx) {
        In();
    }
    
    @Override public void exitProgram(MplusParser.ProgramContext ctx) {
    }
    
    @Override public void enterClasspart(MplusParser.ClasspartContext ctx) {
        In();
        now_class_id = id;
        clac = 0;
    }
    
    @Override public void exitClasspart(MplusParser.ClasspartContext ctx) {
        Out();
        now_class_id = 0;
    }
    
    @Override public void enterSelfpart(MplusParser.SelfpartContext ctx) {
        thisaddress = new Address(new Vregister(++register_num));
    }
    
    @Override public void exitSelfpart(MplusParser.SelfpartContext ctx) {
        FunctionIr tmp = new FunctionIr();
        tmp.content.add(new Temp(thisaddress));
        Node goal = AstNode.get(ctx.getChild(3));
        for(int i = 0; i < reflict.get(goal).content.size(); i++) {
            tmp.content.add(reflict.get(goal).content.get(i));
        }
        tmp.label = now_class_id;
        tmp.name = "1selfpart";
        tmp.para.add(thisaddress);
        reflict.get(goal).content.clear();
        procedure.add(tmp);
    }
    
    @Override public void enterFunctionpart(MplusParser.FunctionpartContext ctx) {

    }
    
    @Override public void exitFunctionpart(MplusParser.FunctionpartContext ctx) {
        FunctionIr tmp = new FunctionIr();
        Node goal = AstNode.get(ctx.getChild(3));
        for(int i = 0; i < reflict.get(goal).content.size(); i++) {
            tmp.content.add(reflict.get(goal).content.get(i));
            ParaIr why = (ParaIr)(reflict.get(goal));
            tmp.para = why.para;
        }
        tmp.label = now_class_id;
        tmp.name = ctx.getChild(1).getText();
        reflict.get(goal).content.clear();
        goal = AstNode.get(ctx.getChild(5));
        for(int i = 0; i < reflict.get(goal).content.size(); i++) {
            tmp.content.add(reflict.get(goal).content.get(i));
        }
        reflict.get(goal).content.clear();
        procedure.add(tmp);
    }
    
    @Override public void enterParameter(MplusParser.ParameterContext ctx) {
        ParaIr son = new ParaIr();
        List<TerminalNode> ListName = ctx.Name();
        List<MplusParser.TypeContext> typeName = ctx.type();
        List<Type> type_list = new ArrayList();
        for(int i = 0; i < ListName.size(); i++) {
            String name = ListName.get(i).getSymbol().getText();
            Pair<String, Integer> pair = new Pair<String, Integer>(name, idcnt + 1);
            Name2register.put(pair, (new Address(new Vregister(++register_num))));
            Temp a1 = new Temp();
            a1.add = (new Address(new Vregister(register_num)));
            son.content.add(a1);
            son.para.add((new Address(new Vregister(register_num))));
        }
        if(now_class_id != 0) {
            thisaddress = new Address(new Vregister(++register_num));
            son.content.add(new Temp(thisaddress));
            son.para.add(thisaddress);
        }
        reflict.put(AstNode.get(ctx), son);
    }
    
    @Override public void exitParameter(MplusParser.ParameterContext ctx) { }
    
    @Override public void enterDifinition(MplusParser.DifinitionContext ctx) {
    }
    
    @Override public void exitDifinition(MplusParser.DifinitionContext ctx) {
        if(now_class_id == id) {
            reflict.put(AstNode.get(ctx), new Ir());
            return ;
        }
        register_num++;
        String t = ctx.getChild(1).getText();
        Temp a1 = new Temp();
        if(id == 2) {
            Address add = new Address(new Vregister(register_num));
            add.globel = ++globelnum;
            globel.add(register_num);
            Name2register.put(new Pair(t, id), add);
        } else {
            a1.add = (new Address(new Vregister(register_num)));
            a1.content.add(a1);
            Name2register.put(new Pair(t, id), new Address(new Vregister(register_num)));
        }
        if(ctx.getChildCount() != 3) {
            ExprIr hh = (ExprIr)reflict.get(AstNode.get(ctx.getChild(3)));
            Move tmp = new Move(new Address(new Vregister(register_num)), hh.address);
            a1.content.add(tmp);
        }
        reflict.put((Node)AstNode.get(ctx), a1);
    }

    @Override public void enterStatement(MplusParser.StatementContext ctx) { }

    @Override public void exitStatement(MplusParser.StatementContext ctx) {

    }

    @Override public void enterExpr_statement(MplusParser.Expr_statementContext ctx) { }

    @Override public void exitExpr_statement(MplusParser.Expr_statementContext ctx) {
        ExprIr ExprIr = (BE.ExprIr) reflict.get(AstNode.get(ctx.getChild(0)));
        StmtIr StmtIr = new StmtIr();
        for(int i = 0; i < ExprIr.content.size(); i++) {
            StmtIr.content.add(ExprIr.content.get(i));
        }
        reflict.put(AstNode.get(ctx), StmtIr);
    }

    @Override public void enterBlockpart(MplusParser.BlockpartContext ctx) {
        In();
    }

    @Override public void exitBlockpart(MplusParser.BlockpartContext ctx) {
        Out();
        StmtIr now = new StmtIr();
        BlockNode tmp = (BlockNode)AstNode.get(ctx);
        for(int i = 0; i < tmp.son.size(); i++) {
            Node u = (Node)tmp.son.get(i);
            if(reflict.containsKey(u)) {
                for(int j = 0; j < reflict.get(u).content.size(); j++) {
                    now.content.add(reflict.get(u).content.get(j));
                }
            }
            reflict.get(u).content.clear();
        }
        reflict.put(tmp, now);
    }

    @Override public void enterIf_statement(MplusParser.If_statementContext ctx) {
    }

    @Override public void exitIf_statement(MplusParser.If_statementContext ctx) {
        IfNode now = (IfNode)AstNode.get(ctx);
        StmtIr nn = new StmtIr();
        ExprIr condition = (ExprIr)reflict.get(now.condition);
        for(int i = 0; i < condition.content.size(); i++) {
            nn.content.add(condition.content.get(i));
        }
        condition.content.clear();
        Cjump Cjump = new Cjump(condition.address, new Catch(++catch_num), new Catch(++catch_num));
        nn.content.add(Cjump);

        nn.content.add(new Catch(catch_num - 1));
        StmtIr then = (StmtIr)reflict.get(now.thennode);
        for(int i = 0; i < then.content.size(); i++) {
            nn.content.add(then.content.get(i));
        }
        then.content.clear();
        if(now.elsenode != null) {
            nn.content.add(new Jump(new Catch(++catch_num)));

            nn.content.add(new Catch(catch_num - 1));
            StmtIr els = (StmtIr) reflict.get(now.thennode);
            for (int i = 0; i < els.content.size(); i++) {
                nn.content.add(els.content.get(i));
            }
            els.content.clear();
            nn.content.add(new Jump(new Catch(catch_num)));
        } else {
            nn.content.add(new Jump(new Catch(catch_num)));
        }
        nn.content.add(new Catch(catch_num));
        reflict.put(now, nn);
    }

    @Override public void enterWhile_statement(MplusParser.While_statementContext ctx) {
    }

    @Override public void exitWhile_statement(MplusParser.While_statementContext ctx) {
        StmtIr nn = new StmtIr();
        nn.content.add(new Jump(new Catch(++catch_num)));
        nn.content.add(new Catch(catch_num));
        WhileNode now = (WhileNode)AstNode.get(ctx);
        ExprIr condition = (ExprIr)reflict.get(now.condition);
        for(int i = 0; i < condition.content.size(); i++) {
            nn.content.add(condition.content.get(i));
        }
        condition.content.clear();
        Cjump Cjump = new Cjump(condition.address, new Catch(++catch_num), new Catch(++catch_num));
        nn.content.add(Cjump);
        nn.content.add(new Catch(catch_num - 1));
        for(int i = 0; i < reflict.get(now.statement).content.size(); i++) {
            nn.content.add(reflict.get(now.statement).content.get(i));
            if(reflict.get(now.statement).content.get(i) instanceof Jump) {
                Jump t = (Jump)reflict.get(now.statement).content.get(i);
                if(t.yes.flag == 123456789) {
                    t.yes.flag = catch_num - 2;
                }
                if(t.yes.flag == 987654321) {
                    t.yes.flag = catch_num;
                }
            }
        }
        reflict.get(now.statement).content.clear();
        nn.content.add(new Jump(new Catch(catch_num - 3)));
        nn.content.add(new Catch(catch_num));
        reflict.put(now, nn);
    }

    @Override public void enterScope_statement(MplusParser.Scope_statementContext ctx) {
        In();
    }

    @Override public void exitScope_statement(MplusParser.Scope_statementContext ctx) {
        Out();
    }

    @Override public void enterFor_statement(MplusParser.For_statementContext ctx) {
    }

    @Override public void exitFor_statement(MplusParser.For_statementContext ctx) {
        StmtIr nn = new StmtIr();
        ForNode ForNode = (ForNode)AstNode.get(ctx);
        if(ForNode.son[0] != null) {
            for(int i = 0; i < reflict.get(ForNode.son[0]).content.size(); i++) {
                nn.content.add(reflict.get(ForNode.son[0]).content.get(i));
            }
            reflict.get(ForNode.son[0]).content.clear();
        }
        nn.content.add(new Jump(new Catch(++catch_num)));
        nn.content.add(new Catch(catch_num));
        if(ForNode.son[1] != null) {
            for(int i = 0; i < reflict.get(ForNode.son[1]).content.size(); i++) {
                nn.content.add(reflict.get(ForNode.son[1]).content.get(i));
            }
            reflict.get(ForNode.son[1]).content.clear();
        }
        Cjump Cjump = new Cjump(((ExprIr)(reflict.get(ForNode.son[1]))).address, new Catch(++catch_num), new Catch(++catch_num));
        nn.content.add(Cjump);
        nn.content.add(new Catch(catch_num - 1));
        for(int i = 0; i < reflict.get(ForNode.statement).content.size(); i++) {
            if(reflict.get(ForNode.statement).content.get(i) instanceof Jump) {
                Jump t = (Jump)reflict.get(ForNode.statement).content.get(i);
                if(t.yes.flag == 123456789) {
                    t.yes.flag = catch_num + 1;
                }
                if(t.yes.flag == 987654321) {
                    t.yes.flag = catch_num - 1;
                }
            }
            nn.content.add(reflict.get(ForNode.statement).content.get(i));
        }
        nn.content.add(new Jump(new Catch(++catch_num)));
        nn.content.add(new Catch(catch_num));
        if(ForNode.son[2] != null) {
            for(int i = 0; i < reflict.get(ForNode.son[2]).content.size(); i++) {
                nn.content.add(reflict.get(ForNode.son[2]).content.get(i));
            }
            reflict.get(ForNode.son[2]).content.clear();
        }
        nn.content.add(new Jump(new Catch(catch_num - 2)));
        nn.content.add(new Catch(catch_num - 1));
        reflict.put(ForNode, nn);
    }

    @Override public void enterContinue(MplusParser.ContinueContext ctx) { }

    @Override public void exitContinue(MplusParser.ContinueContext ctx) {
        Jump tt = new Jump(new Catch(123456789));
        tt.content.add(tt);
        reflict.put(AstNode.get(ctx), tt);
    }

    @Override public void enterBreak(MplusParser.BreakContext ctx) { }

    @Override public void exitBreak(MplusParser.BreakContext ctx) {
        Jump tt = new Jump(new Catch(987654321));
        tt.content.add(tt);
        reflict.put(AstNode.get(ctx), tt);
    }

    @Override public void enterReturn(MplusParser.ReturnContext ctx) { }

    @Override public void exitReturn(MplusParser.ReturnContext ctx) {
        Return temp = new Return(), tt = new Return();
        if(ctx.getChildCount() > 2) {
            ExprIr son = (ExprIr)reflict.get(AstNode.get(ctx.getChild(1)));
            for(int i = 0; i < son.content.size(); i++) {
                tt.content.add(son.content.get(i));
            }
            tt.son = temp.son = son.address;
            son.content.clear();
            tt.content.add(temp);
        }
        reflict.put(AstNode.get(ctx), tt);
    }

    @Override public void enterUnary_expr(MplusParser.Unary_exprContext ctx) { }

    @Override public void exitUnary_expr(MplusParser.Unary_exprContext ctx) {
        UnaryIr tmp1 = new UnaryIr();
        UnaryNode hh = (UnaryNode) AstNode.get(ctx);
        tmp1.op = hh.op.s;
        tmp1.right = ((ExprIr)reflict.get(AstNode.get(ctx.getChild(1)))).address;
        tmp1.address = new Address(new Vregister(++register_num));
        tmp1.dest = tmp1.address;
        if(tmp1.op.equals("++") || tmp1.op.equals("--")) {
            tmp1.address = tmp1.right;
            tmp1.dest = tmp1.address;
        }
        ExprIr right = (ExprIr)reflict.get(AstNode.get(ctx.getChild(1)));
        tmp1.add(right);
        tmp1.content.add(new Temp(new Address(new Vregister(register_num))));
        tmp1.content.add(tmp1);
        reflict.put(hh, tmp1);
    }

    @Override public void enterAref_expr(MplusParser.Aref_exprContext ctx) { }

    @Override public void exitAref_expr(MplusParser.Aref_exprContext ctx) {
        ExprIr index = (ExprIr) reflict.get(AstNode.get(ctx.getChild(2)));
        ExprIr basic = (ExprIr) reflict.get(AstNode.get(ctx.getChild(0)));
        ExprIr now = new ExprIr();
        now.add(index);
        now.add(basic);
        Address basic_reg = new Address(basic.address);
        if(!basic.address.isVregister()) {
            Temp dest = new Temp(new Address(new Vregister(++register_num)));
            Move tmp = new Move(dest.add, basic.address);
            basic_reg = dest.add;
            now.content.add(dest);
            now.content.add(tmp);
        }

        Address index_reg = new Address(index.address);
        if(!index.address.isVregister()) {
            Temp dest = new Temp(new Address(new Vregister(++register_num)));
            int yjc;
            Move tmp = new Move(dest.add, index.address);
            index_reg = dest.add;
            now.content.add(dest);
            now.content.add(tmp);
        }

        Address tmp = new Address(basic_reg.reg1, index_reg.reg2, 8, 0);
        now.address = tmp;
        reflict.put(AstNode.get(ctx), now);
    }

    @Override public void enterMember_expr(MplusParser.Member_exprContext ctx) { }

    @Override public void exitMember_expr(MplusParser.Member_exprContext ctx) {
        ExprIr now = new ExprIr();
        ExprIr left = (ExprIr)reflict.get(AstNode.get(ctx.getChild(0)));
        ExprIr right = (ExprIr)reflict.get(AstNode.get(ctx.getChild(2)));
        now.add(left);
        now.add(right);
        String name = ctx.getChild(1).getText();
        int classid = ((MemNode)AstNode.get(ctx)).origin;
        if(Classindex.containsKey(new Pair<Integer, String>(classid, name))) {
            int index = Classindex.get(new Pair<Integer, String>(classid, name));
            Address basic = new Address(left.address);
            if(!left.address.isVregister()) {
                now.address = new Address(new Vregister(++register_num));
                Move Move = new Move(now.address, left.address);
                now.content.add(new Temp(now.address));
                now.content.add(Move);
                basic = now.address;
            }
            basic.imm2.num += 8 * index;
            now.address = basic;
        } else {
            now.address = new Address(new Vregister(1997101024));
        }
        reflict.put(AstNode.get(ctx), now);
    }

    @Override public void enterConstant_expr(MplusParser.Constant_exprContext ctx) {
    }

    @Override public void exitConstant_expr(MplusParser.Constant_exprContext ctx) {
        if(ctx.getText().equals("null")) {
            return ;
        }
        ConstNode tmp = (ConstNode)AstNode.get(ctx);
        Address now = new Address(new Vregister(++register_num));
        int num;
        Move Move = new Move();
        Address Address = new Address();
        if(tmp.content.charAt(0) == 's') {
            String a = "";
            int strlen = tmp.content.length();
            for(int i = 6; i < strlen; i++) {
                a = a + tmp.content.charAt(i);
            }
            Address.imm2 = new Immediate(Integer.parseInt(a));
            Address.imm1=  new Immediate(0);
            String2register.put(now, Integer.parseInt(a));
        } else {
            Address.imm2 = new Immediate(Integer.parseInt(tmp.content));
        }
        Move.left = now;
        Move.right = Address;
        ExprIr ExprIr = new ExprIr();
        ExprIr.address = now;
        ExprIr.content.add(new Temp(now));
        ExprIr.content.add(Move);
        reflict.put(AstNode.get(ctx), ExprIr);
    }

    @Override public void enterBinary_expr(MplusParser.Binary_exprContext ctx) {
    }

    CallIr calldeal(FuncallNode pattern, ExprIr thisaddress) {
        CallIr callir = new CallIr();
        for(int i = 0; i < pattern.son_ad.size(); i++) {
            ExprIr tmp = (ExprIr)reflict.get(pattern.son_ad.get(i));
            callir.add(tmp);
            callir.para.add(tmp.address);
        }
        if(pattern.label != 2) {
            callir.para.add(thisaddress.address);
        }
        callir.label = pattern.label;
        callir.name = pattern.name;
        callir.address = new Address(new Vregister(++register_num));
        callir.content.add(new Temp(callir.address));
        callir.content.add(callir);
        return callir;
    }

    @Override public void exitBinary_expr(MplusParser.Binary_exprContext ctx) {
        ExprNode ExprNode = (ExprNode)AstNode.get(ctx);
        if(ExprNode instanceof FuncallNode == false) {
            BinaryIr now = new BinaryIr();
            ExprIr left = (ExprIr)reflict.get(AstNode.get(ctx.getChild(0)));
            ExprIr right = (ExprIr)reflict.get(AstNode.get(ctx.getChild(2)));
            now.add(left);
            now.add(right);
            now.left = left.address;
            now.right = right.address;
            now.op = ctx.getChild(1).getText();
            now.content.add(new Temp(new Address(new Vregister(++register_num))));
            now.address = new Address(new Vregister(register_num));
            now.content.add(now);
            reflict.put(AstNode.get(ctx), now);
        } else {
            FuncallNode tmp = (FuncallNode)ExprNode;
            CallIr now = calldeal(tmp, new ExprIr());
            reflict.put(AstNode.get(ctx), now);
        }
    }

    @Override public void enterSuffix_expr(MplusParser.Suffix_exprContext ctx) { }

    @Override public void exitSuffix_expr(MplusParser.Suffix_exprContext ctx) {
        UnaryIr now = new UnaryIr();
        ExprIr left = (ExprIr)reflict.get(AstNode.get(ctx.getChild(0)));
        now.add(left);
        now.right = left.address;
        Address push = new Address(new Vregister(++register_num));
        now.address = push;
        now.content.add(new Temp(new Address(new Vregister(register_num))));
        Move Move = new Move(now.address, now.right);
        now.content.add(new Temp(push));
        now.content.add(Move);
        now.dest = now.right;
        now.op = ctx.getChild(1).getText();
        now.content.add(now);
        reflict.put(AstNode.get(ctx), now);
    }

    @Override public void enterNew_expr(MplusParser.New_exprContext ctx) { }

    List<Ir> getNew(List<Address> x, int y, Address z) {
        List<Ir> hh = new ArrayList<>();
        if(x.size() == 0) {
            if(y == 0 || y == 1) {
                return hh;
            }
            Malloc Malloc = new Malloc(new Address(new Vregister(++register_num)), new Address(Classnum.get(y)));
            hh.add(new Temp(Malloc.address));
            hh.add(Malloc);
            Address newadd = new Address(z); newadd.imm1 = new Immediate(8);
            hh.add(new Move(newadd, Malloc.address));
            CallIr CallIr = new CallIr();
            CallIr.para.add(z);
            CallIr.label = y;
            CallIr.name = "1selfpart";
            hh.add(CallIr);
            return hh;
        }
        List<Address> next = new ArrayList<>();
        for(int i = 1; i < x.size(); i++) {
            next.add(x.get(i));
        }
        Address Address = new Address(new Vregister(++register_num));
        hh.add(new Temp(Address));
        hh.add(new Move(Address, new Address(0)));
        // i = 0;
        Catch condition = new Catch(++catch_num);
        Catch Body = new Catch(++catch_num);
        Catch end = new Catch(++catch_num);
        hh.add(condition);
        BinaryIr Binary = new BinaryIr(Address, "<", x.get(0));
        hh.add(new Temp(new Address(new Vregister(++register_num))));
        Binary.address = new Address(new Vregister(register_num));
        hh.add(Binary);
        // t = i < n;
        Cjump Cjump = new Cjump(Binary.address, Body, end);
        hh.add(Cjump);

        hh.add(Body);
        Malloc Malloc = new Malloc(new Address(new Vregister(++register_num)), x.get(0));
        Address ttt = new Address(z);
        ttt.imm1.num = 8;
        ttt.reg2 = Address.reg1;
        hh.add(new Temp(new Address(new Vregister(register_num))));
        hh.add(new Move(ttt, Malloc.address));
        if(x.size() != 0 || y <= 1) {
            List<Ir> fuck = getNew(next, y, Malloc.address);
            for(int i = 0; i < fuck.size(); i++) {
                hh.add(fuck.get(i));
            }
        }
        Jump Jump = new Jump(condition);
        hh.add(Jump);
        hh.add(end);
        return hh;
    }

    @Override public void exitNew_expr(MplusParser.New_exprContext ctx) {
        NewNode tmp = (NewNode)AstNode.get(ctx);
        int classid = ClassMap.get(tmp.type.type);
        ExprIr now = new ExprIr();
        if(tmp.son.size() != 0) {
            List<Address> list = new ArrayList<>();
            for(int i = 1; i < tmp.son.size(); i++) {
                ExprNode u = tmp.son.get(i);
                ExprIr uu = (ExprIr)reflict.get(u);
                now.add(uu);
                list.add(uu.address);
            }
            Address t = new Address(new Vregister(++register_num));
            Malloc tp = new Malloc(t, ((ExprIr)reflict.get(tmp.son.get(0))).address);
            now.content.add(new Temp(t));
            now.content.add(tp);
            List<Ir> tmp1 = getNew(list, classid, t);
            for(int i = 0; i < tmp1.size(); i++) {
                now.content.add(tmp1.get(i));
            }
            now.address = t;
        } else {
            Address t = new Address(new Vregister(++register_num));
            Malloc Malloc = new Malloc(t, new Address(Classnum.get(classid)));
            CallIr CallIr = new CallIr();
            CallIr.para.add(t);
            CallIr.label = classid;
            CallIr.name = "1selfpart";
            now.content.add(new Temp(t));
            now.content.add(Malloc);
            now.content.add(CallIr);
        }
        reflict.put(AstNode.get(ctx), now);
    }

    @Override public void enterAssign_expr(MplusParser.Assign_exprContext ctx) { }

    @Override public void exitAssign_expr(MplusParser.Assign_exprContext ctx) {
        ExprIr now = new ExprIr();
        ExprIr left = (ExprIr)reflict.get(AstNode.get(ctx.getChild(0)));
        ExprIr right = (ExprIr)reflict.get(AstNode.get(ctx.getChild(2)));
        now.add(left);
        now.add(right);
        Move Move = new Move();
        Move.left = left.address;
        Move.right = right.address;
        Move.content.add(Move);
        reflict.put(AstNode.get(ctx), now);
    }

    @Override public void enterName_expr(MplusParser.Name_exprContext ctx) { }

    @Override public void exitName_expr(MplusParser.Name_exprContext ctx) {

    }

    @Override public void enterFunction_expr(MplusParser.Function_exprContext ctx) { }

    @Override public void exitFunction_expr(MplusParser.Function_exprContext ctx) {
        FuncallNode tmp = (FuncallNode)(AstNode.get(ctx));
        CallIr tt = new CallIr();
        if(tmp.label != 2) {
            tt = calldeal(tmp, (ExprIr)(reflict.get(AstNode.get(ctx.getChild(0).getChild(0)))));
        } else {
            tt = calldeal(tmp, new ExprIr());
        }
        reflict.put(AstNode.get(ctx), tt);
    }
    
    @Override public void enterBracket_expr(MplusParser.Bracket_exprContext ctx) { }
    
    @Override public void exitBracket_expr(MplusParser.Bracket_exprContext ctx) {

    }
    
    @Override public void enterBool(MplusParser.BoolContext ctx) { }
    
    @Override public void exitBool(MplusParser.BoolContext ctx) { }
    
    @Override public void enterInt(MplusParser.IntContext ctx) { }
    
    @Override public void exitInt(MplusParser.IntContext ctx) { }
    
    @Override public void enterString(MplusParser.StringContext ctx) { }
    
    @Override public void exitString(MplusParser.StringContext ctx) { }
    
    @Override public void enterNull(MplusParser.NullContext ctx) { }
    
    @Override public void exitNull(MplusParser.NullContext ctx) {
        Address Address = new Address(new Vregister(85547028));
        ExprIr ExprIr = new ExprIr();
        ExprIr.address = Address;
        reflict.put(AstNode.get(ctx), ExprIr);
    }
    
    @Override public void enterTrue_type(MplusParser.True_typeContext ctx) { }
    
    @Override public void exitTrue_type(MplusParser.True_typeContext ctx) { }
    
    @Override public void enterArray_type(MplusParser.Array_typeContext ctx) { }
    
    @Override public void exitArray_type(MplusParser.Array_typeContext ctx) { }
    
    @Override public void enterMy_type(MplusParser.My_typeContext ctx) { }
    
    @Override public void exitMy_type(MplusParser.My_typeContext ctx) { }

    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    
    @Override public void visitTerminal(TerminalNode node) {
        String name = node.getText();
        ExprIr Expr = new ExprIr();
        int nowid = get(name, now_class_id);
        if(now_class_id == nowid) {
            if(thisaddress != null) {
                Address address = new Address(thisaddress);
                if(Classindex.containsKey(new Pair<Integer,String>(now_class_id, name))) {
                    int index = Classindex.get(new Pair<Integer, String>(now_class_id, name));
                    address.imm2.num = index * 8;
                    Expr.address = address;
                }
            }
        } else {
            if(node.getText().equals("this")) {
                Expr.address = thisaddress;
            } else {
                Expr.address = Name2register.get(new Pair<String, Integer>(name, nowid));
            }
        }
        Expr.content.add(Expr);
        reflict.put(AstNode.get(node), Expr);
    }
    
    @Override public void visitErrorNode(ErrorNode node) { }

}
