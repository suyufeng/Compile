package BE;

import GC.True_address;

import java.util.Map;

/**
 * Created by suyufeng on 17-5-22.
 */
public class Jump extends StmtIr {
    Catch yes;
    public Jump(Catch x) {
        yes = x;
    }
    @Override
    public void ToString(){
        System.out.println("Jump  " + "flag:" + yes.flag);
    }
    @Override
    public void translate(Map<Integer, True_address> map, int Num) {
        System.out.println("\tjmp    Catch." + yes.flag);
    }
}
