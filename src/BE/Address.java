package BE;

/**
 * Created by suyufeng on 17-4-4.
 */
public class Address {
    public Vregister reg1, reg2;
    Immediate imm1, imm2;
    //reg1 + reg2 * imm1 + imm2;
    public Address(Vregister reg1) {
        this.reg1 = reg1;
        this.reg2 = new Vregister(0);
        imm1 = imm2 = new Immediate(0);
    }
    public Address() {
        this.reg1 = new Vregister(0);
        this.reg2 = new Vregister(0);
        imm1 = imm2 = new Immediate(0);
    }
    public Address(Vregister reg1, int x) {
        this.reg1 = reg1;
        this.reg2 = new Vregister(0);
        this.imm2 = new Immediate(x);
        imm1 = new Immediate(0);
    }
    public Address(Vregister reg1, Vregister reg2, int x, int y) {
        this.reg1 = reg1;
        this.reg2 = reg2;
        this.imm1 = new Immediate(x);
        this.imm2 = new Immediate(y);
    }
    public Address(int x) {
        this.reg1 = new Vregister(0);
        this.reg2 = new Vregister(0);
        this.imm1 = new Immediate(0);
        this.imm2 = new Immediate(x);
    }
    public Address(Address x) {
        reg1 = new Vregister(x.reg1);
        reg2 = new Vregister(x.reg2);
        imm1 = new Immediate(x.imm1);
        imm2 = new Immediate(x.imm2);
    }
    boolean isVregister() {
        if(this.reg2.num == 0 && this.imm1.num == 0 && this.imm2.num == 0 && this.reg1.num != 0) {
            return true;
        } else {
            return false;
        }
    }
}
