package BE;

import GC.True_address;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Map;

/**
 * Created by suyufeng on 17-5-23.
 */
public class BinaryIr extends ExprIr{
    public Address left, right;
    public String op;
    public BinaryIr(Address left, String op, Address right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    public BinaryIr() {
    }
    @Override
    public void translate(Map<Integer, True_address> assign_add, int Num) {
        Pair<Address, Address> now = fuck_divert(address, left, assign_add);
        String le = tran_reg(now.a, assign_add);
        String ri = tran_reg(now.b, assign_add);
        System.out.println("\tmov    " + le + ",  " + ri);
        now = fuck_divert(now.a, right, assign_add);
        le = tran_reg(now.a, assign_add);
        ri = tran_reg(now.b, assign_add);
        if(op.equals("+")) {
            System.out.println("\tadd    " + le + ",  " + ri);
        } else if(op.equals("-")) {
            System.out.println("\tsub    " + le + ",  " + ri);
        } else if(op.equals("*")) {
            System.out.println("\tmov    rax" + ",  " + le);
            System.out.println("\timul   " + "rax" + ",  " + ri);
            System.out.println("\tmov    " + le + ",  " + "rax");
        } else if(op.equals("/")) {
            System.out.println("\tmov    " + "rax" + ",  " + le);
            System.out.println("\tcdq");
            System.out.println("\tidiv   " + ri);
            System.out.println("\tmov    " + le + ",  " + "rax");
        } else if(op.equals("%")) {
            System.out.println("\tmov    " + "rax" + ",  " + le);
            System.out.println("\tcdq");
            System.out.println("\tidiv   " + ri);
            System.out.println("\tmov    " + le + ",  " + "rdx");
        } else if(op.equals("<")) {
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetl   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("<=")) {
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetle   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals(">")) {
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetg   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals(">=")) {
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetge  al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("==")) {
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsete   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("!=")) {
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetne   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("&")) {
            System.out.println("\tand    " + le + ",  " + ri);
        } else if(op.equals("|")) {
            System.out.println("\tor     " + le + ",  " + ri);
        } else if(op.equals("^")) {
            System.out.println("\txor    " + le + ",  " + ri);
        }
    }
    @Override
    public void ToString() {
        System.out.println("BinaryIr (" + address.oString() + ") = (" + left.oString() + ") " + op + " (" + right.oString() + ")");
    }
}
