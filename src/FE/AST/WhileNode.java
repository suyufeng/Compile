package FE.AST;

/**
 * Created by suyufeng on 17-3-30.
 */
public class WhileNode extends StmtNode {
    public ExprNode condition;
    StmtNode statement;

    public WhileNode() {}
    public WhileNode(ExprNode a1, StmtNode a2) {
        condition = a1;
        statement = a2;
    }
}
