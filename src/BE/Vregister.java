package BE;

/**
 * Created by suyufeng on 17-5-19.
 */
public class Vregister {
    int num;
    public Vregister(int num) {
        this.num = num;
    }
    public Vregister() {

    }
    public Vregister(Vregister num) {
        this.num = num.num;
    }
}
