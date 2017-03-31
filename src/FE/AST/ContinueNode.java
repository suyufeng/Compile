package FE.AST;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by suyufeng on 17-3-29.
 */
public class ContinueNode extends StmtNode{
    StmtNode pre;
    ParseTree tmp;
    public ContinueNode(ParseTree x) {
        tmp = x;
    }

    public ContinueNode() {
    }
}
