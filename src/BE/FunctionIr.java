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
    public int add_num = 0;
    public int label;
    public String name;
    public FunctionIr() {
    }
    @Override public void translate(Map<Integer, True_address> assign_add, int Num) {
        if(name.equals("main")) {
            System.out.println(name + ":");
        //    System.out.println("\tpush   rbp");
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
        System.out.println("");
        Num = 8 + add_num;
        for(int i = 0; i < content.size(); i++) {
            content.get(i).translate(assign_add, Num);
        }
        System.out.println("\tjmp    " + name + "." + Integer.toString(label) + ".out");
        System.out.println(name + "." + Integer.toString(label) + ".out:");


        System.out.println("\tleave");
        System.out.println("\tret");
    }
}
