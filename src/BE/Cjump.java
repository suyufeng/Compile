package BE;

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
}
