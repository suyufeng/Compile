package FE.AST;

import Exception.*;
/**
 * Created by suyufeng on 17-4-1.
 */
public class AssiNode extends ExprNode {
    ExprNode left, right;
    public AssiNode() {}
    public AssiNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
        if(check() == false) {
            throw new CompliationError();
        }
        this.type = left.type;
    }
    Boolean check() {
        if(right.type.type.compareTo("null") == 0) {
            if(left.type.len == 0 && left.type.flag == true) {
                return false;
            }
            return true;
        }
        if(!left.type.Compareto(right.type)) {
            return false;
        }
        return true;
    }
}
