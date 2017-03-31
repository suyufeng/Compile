package FE.AST;

import org.stringtemplate.v4.ST;

/**
 * Created by suyufeng on 17-3-30.
 */
public class IfNode extends StmtNode {
    public ExprNode condition;
    StmtNode thennode, elsenode;

    public IfNode() {}
    public IfNode(ExprNode a1, StmtNode a2) {
        condition = a1;
        thennode = a2;
    }
    public IfNode(ExprNode a1, StmtNode a2, StmtNode a3) {
        condition = a1;
        thennode = a2;
        elsenode = a3;
    }
}
