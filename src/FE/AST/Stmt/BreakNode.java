package FE.AST.Stmt;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by suyufeng on 17-3-29.
 */
public class BreakNode extends StmtNode{
    StmtNode pre;
    ParseTree tmp;
    public BreakNode(ParseTree x) {
        tmp = x;
    }

    public BreakNode() {
    }
}
