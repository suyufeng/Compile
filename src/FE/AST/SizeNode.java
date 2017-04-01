package FE.AST;

/**
 * Created by suyufeng on 17-4-1.
 */
public class SizeNode extends ExprNode {
    public Type type;
    public SizeNode () {

    }
    public SizeNode(Type tmp) {
        type = tmp;
    }
}
