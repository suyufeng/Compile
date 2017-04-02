package FE.AST;

import org.stringtemplate.v4.ST;

/**
 * Created by suyufeng on 17-3-30.
 */
public class ExprstmtNode extends StmtNode {
    ExprNode son;
    public ExprstmtNode(ExprNode t) {
        son = t;
    }
}
