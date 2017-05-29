package BE;

import GC.True_address;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Map;

/**
 * Created by suyufeng on 17-5-22.
 */
public class UnaryIr extends ExprIr {
    String op;
    Address right;
    Address dest;
    public UnaryIr(String op, Address right) {
        this.op = op;
        this.right = right;
    }
    public UnaryIr() {
    }
    @Override
    public void ToString() {
        System.out.println("UnaryIr  op:" + op + "  address:(" + address.oString() + ")  dest("  + dest.oString() + ")");
    }
    @Override
    public void translate(Map<Integer, True_address> map, int Num) {
        if(op.equals("++") || op.equals("--") || op.equals("!")) {
            Pair<Address, Address> now = fuck_divert(dest, right, map);
            String left = tran_reg(now.a, map);
            String righ = tran_reg(now.b, map);
            if(op.equals("++")) {
                System.out.println("\tmov    " + left + ",  " + righ);
                System.out.println("\tadd    " + left + ",  1");
            } else if(op.equals("--")){
                System.out.println("\tmov    " + left + ",  " + righ);
                System.out.println("\tsub    " + left + ",  1");
            } else {
                System.out.println("\tcmp    " + righ + ",  0");
                System.out.println("\tsete   al");
                System.out.println("\tmovzx  rax, al");
                System.out.println("\tmov    " + left + ",  rax");
            }
        } else {
            String righ = tran_reg(toreg(right, map), map);
            System.out.println("\tmov    r15,  " + righ);
            if(op.equals("-")) {
                System.out.println("\tneg    r15");
            } else if(op.equals("~")){
                System.out.println("\tnot    r15");
            }
            System.out.println("\tmov    " + tran_reg(toadd(dest, 1, 2, map), map) + ",  r15");
        }
    }
}
