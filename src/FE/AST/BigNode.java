package FE.AST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by suyufeng on 17-3-29.
 */
public class BigNode extends StmtNode{
    public List son = new ArrayList();
    public BigNode() {}
    public BigNode(Stack T) {
        while(!T.empty()) {
            son.add(T.pop());
        }
    }
    public void add(Node t) {
        Boolean flag = t instanceof SpaceNode;
        if(!flag) {
            son.add(t);
        }
    }
}
