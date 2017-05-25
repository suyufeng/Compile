package FE.AST.Expr;

import FE.AST.Type;

/**
 * Created by suyufeng on 17-3-29.
 */
public class ConstNode extends BasicNode {
    public String content;
    public ConstNode (Type type, String name, String t) {
        this.type = type;
        this.name = name;
        content = t;
    }
}
