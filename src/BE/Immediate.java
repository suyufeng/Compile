package BE;

import org.omg.CORBA.IMP_LIMIT;

/**
 * Created by suyufeng on 17-5-20.
 */
public class Immediate {
    int num;
    public Immediate(int num) {
        this.num = num;
    }
    public Immediate() {

    }
    public Immediate(Immediate num) {
        this.num = num.num;
    }
}
