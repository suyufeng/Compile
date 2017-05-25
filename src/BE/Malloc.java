package BE;

/**
 * Created by suyufeng on 17-5-25.
 */
public class Malloc extends ExprIr {
    Address size;
    public Malloc(Address address, Address size) {
        this.address = address;
        this.size = size;
    }
}

