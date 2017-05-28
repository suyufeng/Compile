package BE;

import GC.True_address;

import java.util.Map;

/**
 * Created by suyufeng on 17-5-25.
 */
public class Malloc extends ExprIr {
    Address size;
    public Malloc(Address address, Address size) {
        this.address = address;
        this.size = size;
    }
    @Override
    public void ToString(){
        System.out.println("Malloc receive:(" + address.oString() + ") size:(" + size.oString() + ")");
    }
    @Override
    public void translate(Map<Integer, True_address> map) {
        String right = tran_reg(toadd(size, 1, 2, map), map);
        System.out.println("mov    rsi,  " + right);
    }
}

