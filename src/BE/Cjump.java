package BE;

import GC.True_address;

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
        System.out.println("\tcmp    " + tran_reg(flag, map) + ",  1");
        System.out.println("\tje     Catch." + yes.flag);
        System.out.println("\tjmp    Catch." + no.flag);
    }
}
