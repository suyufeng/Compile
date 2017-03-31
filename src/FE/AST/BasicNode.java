package FE.AST;

import java.util.BitSet;

/**
 * Created by suyufeng on 17-3-29.
 */
public class BasicNode extends ExprNode {
    String name;
    public BasicNode () {}
    public BasicNode (Type type, String name) {
        this.type = type;
        this.name = name;
    }
}
