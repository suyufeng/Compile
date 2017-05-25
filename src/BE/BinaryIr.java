package BE;

/**
 * Created by suyufeng on 17-5-23.
 */
public class BinaryIr extends ExprIr{
    public Address left, right;
    public String op;
    public BinaryIr(Address left, String op, Address right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    public BinaryIr() {

    }
}
