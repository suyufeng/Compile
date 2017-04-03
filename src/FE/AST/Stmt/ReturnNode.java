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
        if(son.type.type.equals("null")) {
            System.out.println(t.flag);
        }
        if(son.type.type.equals("null") && (t.len > 0 || t.flag == false)) {
            return true;
        }
        return son.type.Compareto(t);
    }
}
