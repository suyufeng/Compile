package FE.CST;


import FE.AST.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import Exception.CompliationError;

import java.util.*;

public class Checkconflict extends MplusBaseListener {
    public Map<Pair<String, Integer>, Type> FunctionMap = new HashMap<>();
    public Map<Pair<String, Integer>, Type> NameMap = new HashMap<>();
    public Map<Pair<String, Integer>, List<Type>> ParaMap = new HashMap<>();
    private int id = 1, idcnt = 1, now_class_id = 0;
    Stack id_stack = new Stack();
    boolean canreturn = false;
    int canbreak = 0, row, col;
    String FunctionName;
    public Map<String, Integer> ClassMap = new HashMap<>();

    private void In() {
        idcnt++;
        id_stack.push(idcnt);
        id = idcnt;
    }
    private void Out() {
        id_stack.pop();
        id = (Integer)id_stack.peek();
    }

    private boolean check(String name) {
        Pair<String, Integer> pair1 = new Pair <String, Integer>(name, id);
        if(NameMap.containsKey(pair1)) {
            return false;
        }
        if(id == 1) {
             if(ClassMap.containsKey(name)) {
                 return false;
             }
        }
        return true;
    }

    public Type trans(String s) {
        Type ans = new Type();
        ans.type = "";
        for(int i = 0; i < s.length(); i++) {
            Character t = s.charAt(i);
            if(t == '[' || t == ']') {
                ans.len++;
            } else {
                ans.type = ans.type + t;
            }
        }
        ans.len /= 2;
        ans.have = 0;
        return ans;
    }

    @Override
    public void enterClasspart(MplusParser.ClasspartContext ctx) {
        String classname = ctx.Name().getText();
        if (ClassMap.containsKey(classname) || id != 2) {
            throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
        }
        In();
        ClassMap.put(classname, id);
        now_class_id = id;
    }

    @Override
    public void enterProgram(MplusParser.ProgramContext ctx) {
        In();
    }

    @Override
    public void exitClasspart(MplusParser.ClasspartContext ctx) {
        Out();
        now_class_id = 0;
    }

    @Override
    public void enterFunctionpart(MplusParser.FunctionpartContext ctx) {
        String name = ctx.Name().getSymbol().getText();
        Pair<String, Integer> pair1 = new Pair <String, Integer>(name, id);
        if(check(name) == false) {
            throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
        }
        String Nowtype = ctx.type().getText();
        Type nowtype = trans(Nowtype);
        FunctionMap.put(pair1, nowtype);
        NameMap.put(pair1, nowtype);
        pair1 = new Pair<String, Integer>(name, idcnt + 1);
        FunctionMap.put(pair1, nowtype);
        NameMap.put(pair1, nowtype);
        FunctionName = name;
        canreturn = true;
    }

    @Override
    public void exitFunctionpart(MplusParser.FunctionpartContext ctx) {

        canreturn = false;
    }

    @Override
    public void enterParameter(MplusParser.ParameterContext ctx) {
        List<TerminalNode> ListName = ctx.Name();
        List<MplusParser.TypeContext> typeName = ctx.type();
        Pair<String, Integer> pair_function = new Pair <String, Integer>(FunctionName, id);
        List<Type> type_list = new ArrayList();
        for(int i = 0; i < ListName.size(); i++) {
            String name = ListName.get(i).getSymbol().getText();
            String ttype = typeName.get(i).getText();
            Type type = trans(ttype);
            type_list.add(type);
            int tmp_id = id;
            id = idcnt + 1;
            if(check(name) == false) {
                throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
            }
            id= tmp_id;
            Pair<String, Integer> pair = new Pair<String, Integer>(name, id);
            pair = new Pair<String, Integer>(name, idcnt + 1);
            NameMap.put(pair, type);
        }
        ParaMap.put(pair_function, type_list);
    }

    @Override
    public void enterDifinition(MplusParser.DifinitionContext ctx) {
        String name = ctx.Name().getSymbol().getText();
        String ttype = ctx.type().getText();
        Type type = trans(ttype);
        if(check(name) == false) {
            throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
        }
        Pair<String, Integer> pair = new Pair<String, Integer>(name, id);
        NameMap.put(pair, type);
    }

    @Override
    public void enterBlockpart(MplusParser.BlockpartContext ctx) {
        In();
    }

    @Override
    public void exitBlockpart(MplusParser.BlockpartContext ctx) {
        Out();
    }

    @Override
    public void enterIf_statement(MplusParser.If_statementContext ctx) {
    }
    @Override
    public void exitIf_statement(MplusParser.If_statementContext ctx) {
    }

    @Override
    public void enterWhile_statement(MplusParser.While_statementContext ctx) {
        canbreak += 1;
    }

    @Override
    public void exitWhile_statement(MplusParser.While_statementContext ctx) {
        canbreak -= 1;
    }

    @Override
    public void enterFor_statement(MplusParser.For_statementContext ctx) {
        canbreak += 1;
    }

    @Override
    public void exitFor_statement(MplusParser.For_statementContext ctx) {
        canbreak -= 1;
    }
    @Override public void enterContinue(MplusParser.ContinueContext ctx) {
        if(canbreak == 0) {
            throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
        }
    }

    @Override public void enterBreak(MplusParser.BreakContext ctx) {
        if(canbreak == 0) {
            throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
        }
    }
    @Override public void enterSelfpart(MplusParser.SelfpartContext ctx) {
        canreturn = true;
    }

    @Override public void exitSelfpart(MplusParser.SelfpartContext ctx) {
        canreturn = false;
    }
    @Override public void enterReturn(MplusParser.ReturnContext ctx) {
        if(!canreturn) {
            throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        row = ctx.getStart().getLine();
        col = ctx.getStart().getCharPositionInLine();
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new CompliationError("CompliationError on line:" + row + " column:" + col + " !");
    }
}

