package FE.AST.Expr;

/**
 * Created by suyufeng on 17-4-1.
 */
public class SufNode extends ExprNode {
    ExprNode left;
    OperaNode op;

    public SufNode() {}
    public SufNode(ExprNode a1, OperaNode a2) {
        left = a1;
        op = a2;
        type = left.type;
    }
}
