package BE;

/**
 * Created by suyufeng on 17-5-20.
 */
public class ExprIr extends Ir{
    Address address;
    public ExprIr(Address ar) {
        address = ar;
    }
    public ExprIr() {
    }
    public void add(ExprIr t) {
        for(int i = 0; i < t.content.size(); i++) {
            this.content.add(t.content.get(i));
        }
        t.content.clear();
    }
}
