package FE.AST.Expr;

/**
 * Created by suyufeng on 17-4-1.
 */
public class MemNode extends ExprNode {
    ExprNode left, right;
    public MemNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
    }
}
