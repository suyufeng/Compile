package BE;

import GC.True_address;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-5-22.
 */
public class Cjump extends StmtIr {
    public Address flag;
    public Catch yes, no;
    public Cjump(Address flag, Catch yes, Catch no) {
        this.flag = flag;
        this.yes = yes;
        this.no = no;
    }
    @Override
    public void ToString(){
        System.out.println("Cjump " + "yes:" + yes.flag + " no:" + no.flag);
    }
    @Override
    public void translate(Map<Integer, True_address> map, int Num) {
        System.out.println("\tcmp    " + tran_reg(toadd(flag, 1, 2, map),map) + ",  1");
        System.out.println("\tje     Catch." + yes.flag);
        System.out.println("\tjmp    Catch." + no.flag);
    }
    @Override
    public List<Integer> use() {
        return flag.getnum();
    }
    @Override
    public List<Integer> suf(Map<Integer, Integer> map) {
        List<Integer> a = new ArrayList<>();
        a.add(map.get(yes.flag));
        a.add(map.get(no.flag));
        return a;
    }
}
