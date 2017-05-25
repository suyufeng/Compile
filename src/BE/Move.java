package BE;

/**
 * Created by suyufeng on 17-5-20.
 */
public class Move extends Ir{
    Address left, right;
    public Move(Address left, Address right) {
        this.left = left;
        this.right = right;
    }
    public Move() {}
}

