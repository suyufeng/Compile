package BE;

import GC.True_address;

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
        System.out.println("Return  son:(" + son.oString() + ")");
    }
    @Override
    public void translate(Map<Integer, True_address> map, int Num) {
        String a = tran_reg(toadd(son, 1, 2, map), map);
        System.out.println("\tmov    rax" + ",  " + a);
        System.out.println("\tjmp    " + name + "." + label + ".out");
    }
}
