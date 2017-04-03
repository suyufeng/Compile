package FE.AST.Expr;

import FE.AST.Node;
import FE.AST.Type;

/**
 * Created by suyufeng on 17-4-1.
 */
public class ThisNode extends BasicNode {
    public ThisNode (Type type, String name) {
        this.type = type;
        this.name = name;
    }
}
