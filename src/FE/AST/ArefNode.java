package FE.AST;

/**
 * Created by suyufeng on 17-3-31.
 */
public class ArefNode extends ExprNode{
    ExprNode tmp;
    public ArefNode(ExprNode tmp) {
        type = tmp.type;
        type.len -= 1;
    }
}
