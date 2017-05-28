package BE;

import GC.True_address;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-4-4.
 */
public class Ir {
    public List<Ir> content = new ArrayList();
    String[] a = new String[]{"", "r13", "r14", "r15"};
    public void translate(Map<Integer, True_address> assign_add) {

    }
    public String tran_reg(Address tmp, Map<Integer, True_address> map) {
        String[] a = new String[12];
        a[1] = "rbx"; a[2] = "rsi"; a[3] = "rdi"; a[4] = "r8";
        a[5] = "r9";a[6] = "r10";a[7] = "r11";a[8] = "r12";
        a[9] = "r13"; a[10] = "r14"; a[11] = "r15";
        if(tmp.globel != 0) {
            return "globel." + Integer.toString(tmp.globel);
        }
        if(tmp.imm1 != null && tmp.reg2 == null) {
            return "string." + tmp.imm2.num;
        }
        if(tmp.isVregister()) {
            True_address now = map.get(tmp.reg1.num);
            if(now.reg != 0) {
                return a[now.reg];
            } else {
                return "qword[rbp - " + Integer.toString(now.address) + "]";
            }
        } else {
            if(tmp.isImmediate()) {
                return Integer.toString(tmp.imm2.num);
            } else if(tmp.imm2 == null) {
                True_address now1 = map.get(tmp.reg1.num);
                True_address now2 = map.get(tmp.reg2.num);
                int flag = 0;
                if(now1.reg != 0) {
                    flag += 1;
                }
                if(now2.reg != 0) {
                    flag += 2;
                }

                if(flag != 0) {
                    return "n" + Integer.toString(flag);
                } else {
                    return "qword[" + a[now1.reg] + " + " + Integer.toString(tmp.imm1.num) + " * " + a[now2.reg] + "]";
                }
            } else {
                True_address now1 = map.get(tmp.reg1.num);
                if(now1.reg != 0) {
                    return "o";
                } else {
                    return "qword[" + a[now1.reg] + " + " + Integer.toString(tmp.imm2.num) + "]";
                }
            }
        }
    }

    Address toadd(Address origin, int x, int y, Map<Integer, True_address> assign_add) {
        String pattern = tran_reg(origin, assign_add);
        if(pattern.charAt(0) == 'q' || pattern.charAt(0) == 'r') {
            return origin;
        } else if(pattern.charAt(0) == 'o') {
            System.out.println("\tmov    " + a[x] + ",  " + tran_reg(new Address(origin.reg1), assign_add));
            Address ans = new Address(origin);
            ans.reg1.num = (int)1e7 + x;
            return ans;
        } else {
            System.out.println("\tmov    " + a[x] + ",  " + tran_reg(new Address(origin.reg1), assign_add));
            System.out.println("\tmov    " + a[y] + ",  " + tran_reg(new Address(origin.reg2), assign_add));
            Address ans = new Address(origin);
            ans.reg1.num = (int)1e7 + x;
            ans.reg2.num = (int)1e7 + y;
            return ans;
        }
    }

    Address toreg(Address origin, Map<Integer, True_address> assign_add) {
        Address ans = toadd(origin, 2, 3, assign_add);
        String pattern = tran_reg(ans, assign_add);
        if(pattern.charAt(0) == 'r') {
            return ans;
        } else {
            System.out.println("\tmov    " + a[1] + ",  " + pattern);
            return new Address(new Vregister((int)1e7 + 1));
        }
    }

    public Pair<Address, Address> fuck_divert(Address l, Address r, Map<Integer, True_address> assign_add) {
        String left = tran_reg(l, assign_add);
        String right = tran_reg(r, assign_add);

        if(Character.isDigit(right.charAt(0))) {
            return new Pair<Address, Address>(toadd(l, 1, 2, assign_add),r);
        }

        int num = 0;
        if(left.charAt(0) == 'r') {
            num += 1;
        }
        if(right.charAt(0) == 'r') {
            num += 2;
        }
        if(num == 3) {
            return new Pair<Address, Address>(l, r);
        }
        Address ansl, ansr;
        if(num == 0) {
            Address t = toreg(r, assign_add);
            return new Pair<Address, Address>(toadd(l, 2, 3, assign_add),t);
        } else if (num == 1) {
            return new Pair<Address, Address>(l ,toadd(r, 1, 2, assign_add));
        } else {
            return new Pair<Address, Address>(toadd(l, 1, 2, assign_add), r);
        }
    }

    public void ToString() {

    }
}
