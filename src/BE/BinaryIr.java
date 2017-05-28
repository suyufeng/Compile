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
    public void translate(Map<Integer, True_address> assign_add) {
        Pair<Address, Address> now = fuck_divert(address, left, assign_add);
        String le = tran_reg(now.a, assign_add);
        String ri = tran_reg(now.b, assign_add);
        System.out.println("\tmov    " + le + ",  " + ri);
        now = fuck_divert(now.a, right, assign_add);
        le = tran_reg(now.a, assign_add);
        ri = tran_reg(now.b, assign_add);
        if(op.equals("+")) {
            System.out.println("\tadd    " + le + ",  " + ri);
        }
    }
    @Override
    public void ToString() {
        System.out.print("BinaryIr (" + address.oString() + ") = (" + left.oString() + ") " + op + " (" + right.oString() + ")");
    }
}
