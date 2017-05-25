package FE.AST.Expr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suyufeng on 17-4-1.
 */
public class NewNode extends ExprNode{
    public List<ExprNode> son = new ArrayList();
    public int label;
}
