package BE;

import GC.True_address;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-5-22.
 */
public class Return extends StmtIr {
    public Address son;
    public int label;
    public String name;
    @Override
    public void ToString() {
        if(son != null) {
            System.out.println("Return  son:(" + son.oString() + ")");
        } else {
            System.out.println("Return  ");
        }
    }
    @Override
    public void translate(Map<Integer, True_address> map, int Num) {
        if(son != null) {
            String a = tran_reg(toadd(son, 1, 2, map), map);
            System.out.println("\tmov    rax" + ",  " + a);
        }
        System.out.println("\tjmp    " + name + "." + label + ".out");
    }

    @Override
    public List<Integer> use() {
        if(son == null) {
            return new ArrayList<>();
        }
        return son.getnum();
    }
}
