package BE;

import GC.True_address;
import org.antlr.v4.runtime.misc.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-5-20.
 */
public class Move extends StmtIr{
    public Address left, right;
    public Move(Address left, Address right) {
        this.left = new Address(left);
        this.right = new Address(right);
    }
    public Move() {}
    @Override
    public void translate(Map<Integer, True_address> assign_add, int Num) {
        if(skip) {
            return ;
        }
        if(left.equal(right)) {
            return ;
        }
        if(left.globel == 0) {
            Pair<Address, Address> now = fuck_divert(left, right, assign_add);
            String nowleft = tran_reg(now.a, assign_add);
            String nowright = tran_reg(now.b, assign_add);
            System.out.println("\tmov    " + nowleft + ",  "  + nowright);
        } else {
            String nowleft = tran_reg(left, assign_add);
            String nowright = tran_reg(toreg(right, assign_add), assign_add);
            System.out.println("\tmov    " + nowleft + ",  "  + nowright);
        }
    }
    @Override
    public void ToString() {
        if(skip) {
            return ;
        }
        System.out.println("Move  left:(" + left.oString() + ")  right:(" + right.oString() + ")");
    }
    public List<Integer> def() {
        if(left.isVregister()) {
            return left.getnum();
        } else {
            return new ArrayList();
        }
    }

    public List<Integer> use() {
        if(!left.isVregister()) {
            return new Ir().fix(left.getnum(), right.getnum());
        } else {
            return right.getnum();
        }
    }

}

