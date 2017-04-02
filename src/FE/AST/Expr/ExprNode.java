package FE.AST.Expr;

import FE.AST.Node;
import FE.AST.Type;

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
