package FE.AST.Expr;

import FE.AST.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suyufeng on 17-4-1.
 */
public class FuncallNode extends ExprNode {
    List<Type> son = new ArrayList();
    public List<ExprNode> son_ad = new ArrayList<>();

    public int label;
    public String name;

    public FuncallNode() {

    }
    public FuncallNode(List<Type> a1, Type a2) {
        son = a1;
        type = a2;
    }
}
