package BE;

import GC.True_address;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-5-24.
 */
public class CallIr extends ExprIr {
    public List<Address> para = new ArrayList<>();
    public List<Address> save = new ArrayList<>();
    public int label;
    public String name;
    @Override
    public void ToString(){
        System.out.println("Call " + Integer.toString(label) + "." + name);
    }
    @Override
    public void translate(Map<Integer, True_address> assign_add, int Num) {
        if(label == 2) {
            label = 0;
        }
        int num = para.size();
        Move Move = new Move();
        for(int i = 0; i < save.size(); i++) {
            Address now = save.get(i);
            Address kk = now.toreg(now, assign_add);
            String tmp = kk.tran_reg(kk, assign_add);
            System.out.println("\tpush   " + tmp);
        }
        if((Num + num * 8) % 16 != 0) {
            System.out.println("\tpush   rbp");
        }
        for(int i = num - 1; i >= 0; i--) {
            Address now = para.get(i);
            Address kk = now.toreg(now, assign_add);
            String tmp = kk.tran_reg(kk, assign_add);
            System.out.println("\tpush   " + tmp);
        }
        System.out.println("\tcall   " + name + "." + Integer.toString(label));
        System.out.println("\tadd    rsp,  " + Integer.toString(num * 8));

        if((Num + num * 8) % 16 != 0) {
            System.out.println("\tpop    rbp");
        }
        for(int i = save.size() - 1; i >= 0; i--) {
            System.out.println("\tpop    r15");
            Move = new Move(save.get(i), new Address(new Vregister((int)1e7+3)));
            Move.translate(assign_add, num);
        }
        String tmp = tran_reg(toadd(address, 1, 2, assign_add), assign_add);
        System.out.println("\tmov    " + tmp + ",  rax");
    }
}
