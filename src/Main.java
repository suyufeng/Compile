import FE.AST.Type;
import FE.CST.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exception.CompliationError;

import static java.lang.System.exit;

public class Main {
    static void init(Map<Pair<String, Integer>, Type> FunctionMap, Map<Pair<String, Integer>, Type> NameMap, Map<String, Integer> ClassMap, Map<Pair<String, Integer>, List<Type>> ParaMap) {
        ClassMap.put("int", 0);
        ClassMap.put("bool", 0);
        ClassMap.put("string", 1);
        FunctionMap.put(new Pair<String, Integer>("length", 1), new Type("int"));
        ParaMap.put(new Pair<String, Integer>("length", 1), new ArrayList());

        FunctionMap.put(new Pair<String, Integer>("substring", 1), new Type("string"));
        List tmp = new ArrayList();
        tmp.add(new Type("int"));
        tmp.add(new Type("int"));
        ParaMap.put(new Pair<String, Integer>("substring", 1), tmp);

        tmp = new ArrayList();
        FunctionMap.put(new Pair<String, Integer>("parseInt", 1), new Type("int"));
        ParaMap.put(new Pair<String, Integer>("parseInt", 1), tmp);

        tmp = new ArrayList();
        tmp.add(new Type("int"));
        FunctionMap.put(new Pair<String, Integer>("ord", 1), new Type("int"));
        ParaMap.put(new Pair<String, Integer>("ord", 1), tmp);

        tmp = new ArrayList();
        tmp.add(new Type("string"));
        FunctionMap.put(new Pair<String, Integer>("print", 2), new Type("void"));
        ParaMap.put(new Pair<String, Integer>("print", 2), tmp);

        tmp = new ArrayList();
        tmp.add(new Type("string"));
        FunctionMap.put(new Pair<String, Integer>("println", 2), new Type("void"));
        ParaMap.put(new Pair<String, Integer>("println", 2), tmp);

        tmp = new ArrayList();
        FunctionMap.put(new Pair<String, Integer>("getString", 2), new Type("string"));
        ParaMap.put(new Pair<String, Integer>("getString", 2), tmp);

        tmp = new ArrayList();
        FunctionMap.put(new Pair<String, Integer>("getInt", 2), new Type("int"));
        ParaMap.put(new Pair<String, Integer>("getInt", 2), tmp);

        tmp = new ArrayList();
        tmp.add(new Type("int"));
        FunctionMap.put(new Pair<String, Integer>("toString", 2), new Type("string"));
        ParaMap.put(new Pair<String, Integer>("toString", 2), tmp);
    }
    public static void main(String[] args) throws Exception{

        InputStream in = new FileInputStream("/home/suyufeng/Compiler/src/a.in");

        ANTLRInputStream input = new ANTLRInputStream(in);
        MplusLexer lexer = new MplusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MplusParser parser = new MplusParser(tokens);
        ParseTree tree = parser.program();
        if(parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Error!");
            throw new CompliationError("1");
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        Checkconflict first = new Checkconflict();
        try {

            walker.walk(first, tree);
        } catch (CompliationError t) {
            System.out.println(t.getError());
            throw new CompliationError("1");
        }

        Map<Pair<String, Integer>, Type> FunctionMap = first.FunctionMap;
        Map<Pair<String, Integer>, Type> NameMap = first.NameMap;
        Map<String, Integer> ClassMap = first.ClassMap;
        Map<Pair<String, Integer>, List<Type>> ParaMap = first.ParaMap;
        init(FunctionMap, NameMap, ClassMap, ParaMap);
        Buildast second_result = new Buildast(FunctionMap, NameMap, ClassMap, ParaMap);
        try {
            walker.walk(second_result, tree);
        } catch (CompliationError t) {
            System.out.println(t.getError());
            exit(0);
        }

        // print LISP-style tree
       // System.out.println(tree.toStringTree(parser));
    }
}
