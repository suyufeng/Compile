package BE;

/**
 * Created by suyufeng on 17-5-22.
 */
public class UnaryIr extends ExprIr {
    String op;
    Address right;
    Address dest;
    public UnaryIr(String op, Address right) {
        this.op = op;
        this.right = right;
    }
    public UnaryIr() {
    }
    @Override
    public void ToString() {
        System.out.println("UnaryIr  op:" + op + "  address:(" + address.oString() + ")  dest("  + dest.oString() + ")");
    }
}
