import FE.AST.Type;
import FE.CST.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exception.CompliationError;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws Exception{

        InputStream in = new FileInputStream("/home/suyufeng/Compiler/src/a.in");

        ANTLRInputStream input = new ANTLRInputStream(in);
        MplusLexer lexer = new MplusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MplusParser parser = new MplusParser(tokens);
        ParseTree tree = parser.program();
        if(parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Error!");
            exit(0);
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        Checkconflict first = new Checkconflict();
        try {
            walker.walk(first, tree);
        } catch (CompliationError t) {
            System.out.println(t.getError());
            exit(0);
        }
        Map<Pair<String, Integer>, Type> FunctionMap = first.FunctionMap;
        Map<Pair<String, Integer>, Type> NameMap = first.NameMap;
        Map<String, Integer> ClassMap = first.ClassMap;
        Map<Pair<String, Integer>, List<Type>> ParaMap = first.ParaMap;
        ClassMap.put("int", 0);
        ClassMap.put("bool", 0);
        ClassMap.put("string", 0);
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
