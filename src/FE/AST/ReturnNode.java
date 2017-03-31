package FE.AST;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by suyufeng on 17-3-29.
 */
public class ReturnNode  extends StmtNode{
    public ExprNode son;
    ReturnNode() {}
    public ReturnNode(Node l) {
        son = (ExprNode)l;
    }
    public Boolean check(Type t) {
        return son.type.Compareto(t);
    }
}
