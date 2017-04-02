package FE.AST.Expr;
import Exception.*;
/**
 * Created by suyufeng on 17-3-31.
 */
public class UnaryNode extends ExprNode{
    OperaNode op;
    ExprNode son;
    public UnaryNode() {

    }
    public UnaryNode(OperaNode a1, ExprNode a2) {
        op = a1;
        son = a2;
        if(check() == false) {
            throw new CompliationError("!");
        }
        type = a2.type;
    }
//('+'|'-'|'!'|'~'|'++'|'--')
    Boolean check() {
        if(op.equals('+') || op.equals('-') || op.equals('~') || op.equals("++") || op.equals("--")) {
            if(son.type.type.compareTo("int") != 0) {
                return false;
            }
        }
        if(op.equals('!')) {
            if(son.type.type.compareTo("bool") != 0) {
                return false;
            }
        }
        return true;
    }
}
