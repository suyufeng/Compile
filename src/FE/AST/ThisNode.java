package FE.AST;

/**
 * Created by suyufeng on 17-4-1.
 */
public class ThisNode extends ExprNode {
    public ExprNode son;
    public ThisNode(Node son) {
        this.son = (ExprNode)son;
    }
}
