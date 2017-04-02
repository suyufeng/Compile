package FE.AST.Stmt;

import FE.AST.Expr.ExprNode;

/**
 * Created by suyufeng on 17-3-30.
 */
public class ForNode extends StmtNode {
    ExprNode[] son = new ExprNode[3];
    StmtNode statement;
    public ForNode() {}
    public ForNode(ExprNode a1, ExprNode a2, ExprNode a3, StmtNode a4) {
        son[0] = a1;
        son[1] = a2;
        son[2] = a3;
        statement = a4;
    }
}
