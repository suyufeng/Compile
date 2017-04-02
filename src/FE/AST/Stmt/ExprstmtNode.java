package FE.AST.Stmt;

import FE.AST.Expr.ExprNode;

/**
 * Created by suyufeng on 17-3-30.
 */
public class ExprstmtNode extends StmtNode {
    ExprNode son;
    public ExprstmtNode(ExprNode t) {
        son = t;
    }
}
