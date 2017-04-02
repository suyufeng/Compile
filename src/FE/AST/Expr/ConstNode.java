package FE.AST.Expr;

import FE.AST.Type;

/**
 * Created by suyufeng on 17-3-29.
 */
public class ConstNode extends BasicNode {
    Boolean flag;
    public ConstNode (Type type, String name) {
        this.type = type;
        this.name = name;
        flag = false;
    }
}
