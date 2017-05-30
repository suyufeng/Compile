package BE;

import GC.True_address;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-4-4.
 */
public class Address extends Ir{
    public Vregister reg1, reg2;
    Immediate imm1, imm2;
    public int globel = 0;
    //reg1 + reg2 * imm1 + imm2;
    public Address(Vregister reg1) {
        this.reg1 = reg1;
    }
    public Address() {
    }
    public Address(Vregister reg1, int x) {
        this.reg1 = reg1;
        this.imm2 = new Immediate(x);
    }
    public Address(Vregister reg1, Vregister reg2, int x) {
        this.reg1 = reg1;
        this.reg2 = reg2;
        this.imm1 = new Immediate(x);
    }
    public Address(int x) {
        this.imm2 = new Immediate(x);
    }
    public Address(Address x) {
        if(x.reg1 != null)
            reg1 = new Vregister(x.reg1);
        if(x.reg2 != null)
            reg2 = new Vregister(x.reg2);
        if(x.imm1 != null)
            imm1 = new Immediate(x.imm1);
        if(x.imm2 != null)
            imm2 = new Immediate(x.imm2);
        globel = x.globel;
    }
    public boolean isVregister() {
        if(this.reg2 == null && this.imm1 == null && this.imm2 == null && this.reg1 != null && globel == 0) {
            return true;
        } else {
            return false;
        }
    }
    boolean isImmediate() {
        if(this.reg2 == null && this.imm1 == null && this.imm2 != null && this.reg1 == null && globel == 0) {
            return true;
        } else {
            return false;
        }
    }
    boolean Vregister_equal(Vregister t1, Vregister t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return t1.num == t2.num;
    }

    boolean Imm_equal(Immediate t1, Immediate t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return t1.num == t2.num;
    }

    public boolean equal(Address now) {
        if(Vregister_equal(reg1, now.reg1) && Vregister_equal(reg2, now.reg2)) {
            if(Imm_equal(imm1, now.imm1) && Imm_equal(imm2, now.imm2)) {
                if(globel == now.globel) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTrueregister(Map<Integer, True_address> map) {
        if(!isVregister()) {
            return false;
        }
        True_address t = map.get(reg1.num);
        return t.reg > 0;
    }
    @Override
    public void ToString()  {
        System.out.print("Address:   ");
        if(reg1 != null)
            System.out.print(" reg1: " + Integer.toString(reg1.num));
        if(reg2 != null) {
            System.out.print(" reg2: " + Integer.toString(reg2.num));
        }
        if(imm1 != null)
            System.out.print(" imm1: " + Integer.toString(imm1.num));
        if(imm2 != null) {
            System.out.print(" imm2: " + Integer.toString(imm2.num));
        }
        System.out.println();
    }
    public String oString() {
        String a = "";
        a  += ("Address:   ");
        if(reg1 != null)
            a += (" reg1: " + Integer.toString(reg1.num));
        if(reg2 != null) {
            a += (" reg2: " + Integer.toString(reg2.num));
        }
        if(imm1 != null)
            a += (" imm1: " + Integer.toString(imm1.num));
        if(imm2 != null) {
            a += (" imm2: " + Integer.toString(imm2.num));
        }
        return a;
    }

    public List<Integer> getnum() {
        List<Integer> ans = new ArrayList<>();
        if (globel != 0) {
            return new ArrayList<>();
        }
        if(reg1 != null) {
            ans.add(reg1.num);
        }
        if(reg2 != null) {
            ans.add(reg2.num);
        }
        return ans;
    }

}
