package FE.AST.Expr;

import FE.AST.Type;

/**
 * Created by suyufeng on 17-4-1.
 */
public class SizeNode extends ExprNode {
    public SizeNode () {
    }
    public SizeNode(Type tmp) {
        type = tmp;
    }
}
