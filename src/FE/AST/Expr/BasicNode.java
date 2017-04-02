package FE.AST.Expr;

import FE.AST.Type;

/**
 * Created by suyufeng on 17-3-29.
 */
public class BasicNode extends ExprNode {
    public String name;
    public BasicNode () {}
    public BasicNode (Type type, String name) {
        this.type = type;
        this.name = name;
    }
}
