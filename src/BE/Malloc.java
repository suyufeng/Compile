package BE;

import GC.True_address;

import java.util.Map;

/**
 * Created by suyufeng on 17-5-25.
 */
public class Malloc extends ExprIr {
    Address size;
    public Malloc(Address address, Address size) {
        this.address = address;
        this.size = size;
    }
    @Override
    public void ToString(){
        System.out.println("Malloc receive:(" + address.oString() + ") size:(" + size.oString() + ")");
    }
    @Override
    public void translate(Map<Integer, True_address> map, int Num) {
        String right = tran_reg(toadd(size, 1, 2, map), map);
        int flag = (Num / 8) % 2;
        if(flag == 1) {
            System.out.println("\tpush   rbp");
        }
        System.out.println("\tmov    rdi,  " + right);
        System.out.println("\tadd    rdi,  1");
        System.out.println("\timul   rdi,  8");
        System.out.println("\tcall   malloc");
        System.out.println("\tmov    qword[rax],  " + right);
        System.out.println("\tadd    rax,  8");
        System.out.println("\tmov    " + tran_reg(toadd(address, 1, 2, map), map) + ",  rax");
        if(flag == 1) {
            System.out.println("\tpop    rbp");
        }
    }
}

