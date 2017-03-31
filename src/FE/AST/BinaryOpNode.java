package FE.AST;

/**
 * Created by suyufeng on 17-3-29.
 */

import Exception.CompliationError;

import java.util.Stack;
import java.util.concurrent.CompletionException;

public class BinaryOpNode extends ExprNode{
    ExprNode left, right;
    OperaNode op;

    BinaryOpNode() {}
    BinaryOpNode(ExprNode x, String ope, ExprNode y) {
        left = x;
        op = new OperaNode(ope);
        right = y;

        if(op.s.equals("<") || op.s.equals(">") || op.s.equals("<=") || op.s.equals(">=") || op.s.equals("==") || op.s.equals("!="))
            type = new Type("bool");
        else
            type = left.type;
        if(Check() == false) {
            throw new CompliationError("!");
        }
    }
    BinaryOpNode(Stack T) {
        right = (ExprNode) T.pop();
        op = (OperaNode) T.pop();
        left = (ExprNode) T.pop();
        
        if(op.s.equals("<") || op.s.equals(">") || op.s.equals("<=") || op.s.equals(">=") || op.s.equals("==") || op.s.equals("!="))
            type = new Type("bool");
        else
            type = left.type;
        if(Check() == false) {
            throw new CompliationError("!");
        }
    }
    Boolean both(String t) {
        if(!left.type.type.equals(t) || right.type.type.equals(t)) {
            return false;
        } else {
            return true;
        }
    }

    Boolean Check() {
        if(left.type.flag == false || right.type.flag == false) {
            return false;
        }
        if(left.type.Compareto(right.type) == false) {
            return false;
        }
        if(left.type.len != 0) {
            return false;
        }
        if(op.s.equals("<") || op.s.equals(">") || op.s.equals("<=") || op.s.equals(">=")) {
            if(!both("int"))
                return false;
        }
        if(op.s.equals("%") || op.s.equals("<<") || op.s.equals(">>"))
            if(!both("int")) {
                return false;
            }
        return true;
    }


}
