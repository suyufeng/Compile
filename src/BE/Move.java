package BE;

import GC.True_address;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Map;

/**
 * Created by suyufeng on 17-5-20.
 */
public class Move extends StmtIr{
    Address left, right;
    public Move(Address left, Address right) {
        this.left = left;
        this.right = right;
    }
    public Move() {}
    @Override
    public void translate(Map<Integer, True_address> assign_add) {
        Pair<Address, Address> now = fuck_divert(left, right, assign_add);
        String nowleft = tran_reg(now.a, assign_add);
        String nowright = tran_reg(now.b, assign_add);
        System.out.println("\tmov    " + nowleft + ",  "  + nowright);
        System.out.println();
    }
    @Override
    public void ToString() {
        System.out.println("Move  left:(" + left.oString() + ")  right:(" + right.oString() + ")");
    }
}

