package BE;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<Integer> def() {
        return new ArrayList<>();
    }

    @Override
    public List<Integer> use() {
        return new ArrayList<>();
    }

}
