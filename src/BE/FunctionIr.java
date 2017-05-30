package BE;

import GC.True_address;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-5-17.
 */
public class FunctionIr extends Ir{
    public List<Address> para = new ArrayList<>();
    public List<Address> save = new ArrayList<>();
    public int add_num = 0;
    public int label;
    public String name;
    public FunctionIr() {
    }
    @Override public void translate(Map<Integer, True_address> assign_add, int Num) {
        Boolean flag = true;
        if(name.equals("main")) {
            System.out.println(name + ":");
            System.out.println("\tpush   rbp");
            flag = false;
        } else {
            System.out.println(name + "." + Integer.toString(label) + ":");
        }
        System.out.println("\tpush   rbp");
        System.out.println("\tmov    rbp, rsp");
        System.out.println("\tsub    rsp, " + Integer.toString(add_num));

        for(int i = 0; i < para.size(); i++) {
            System.out.println("\tmov    r15" + ",  qword[rbp + " + Integer.toString((i + 2) * 8) + "]");
            String left = tran_reg(toadd(para.get(i), 1, 2, assign_add), assign_add);
            System.out.println("\tmov    " + left + ",  r15");
        }

        for(int i = 0; i < save.size(); i++) {
            System.out.println("push    " + tran_reg(save.get(i), assign_add));
        }

        System.out.println("");
        Num = 8 + add_num + save.size() * 8;
        for(int i = 0; i < content.size(); i++) {
            content.get(i).translate(assign_add, Num);
        }

        for(int i = save.size() - 1; i > 0; i--) {
            System.out.println("pop    " + tran_reg(save.get(i), assign_add));
        }

        System.out.println("\tjmp    " + name + "." + Integer.toString(label) + ".out");
        System.out.println(name + "." + Integer.toString(label) + ".out:");


        System.out.println("\tleave");
        if(flag == false) {
            System.out.println("\tpop    rbp");
        }
        System.out.println("\tret");
    }
}
