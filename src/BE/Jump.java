package BE;

/**
 * Created by suyufeng on 17-5-22.
 */
public class Jump extends StmtIr {
    Catch yes;
    public Jump(Catch x) {
        yes = x;
    }
}