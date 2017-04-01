package FE.AST;

/**
 * Created by suyufeng on 17-3-29.
 */
public class FunctionNode extends BigNode{
    public Type type;
    public FunctionNode () {

    }
    public FunctionNode(Type tmp) {
        type = tmp;
    }

}
