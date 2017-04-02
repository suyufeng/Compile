package FE.AST.Stmt;

import FE.AST.Expr.ExprNode;
import FE.AST.Node;
import FE.AST.Type;

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
