package FE.AST;

/**
 * Created by suyufeng on 17-3-29.
 */
public class ExprNode extends Node {
    public Type type;
    ExprNode() {}
    public ExprNode(Type tmp) {
        type = tmp;
    }
}
