package FE.AST;

import org.stringtemplate.v4.ST;

/**
 * Created by suyufeng on 17-4-1.
 */
public class SelfNode extends StmtNode {
    StmtNode son;
    public SelfNode () {}
    public SelfNode (StmtNode x) {
        son = x;
    }
}
