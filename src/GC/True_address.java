package GC;

/**
 * Created by suyufeng on 17-5-27.
 */
public class True_address {
    public int reg;
    public int address;
    public True_address(int reg, int address) {
        this.reg = reg;
        this.address = address;
    }
    public int clac() {
        if(reg != 0) {
            return 1;
        }
        return 0;
    }
}
