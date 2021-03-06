package BE;

import GC.True_address;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;
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
        if(op.equals("+") && address.isTrueregister(assign_add) && left.isTrueregister(assign_add) && right.isTrueregister(assign_add)) {
            String a = tran_reg(address, assign_add);
            String b = tran_reg(left, assign_add);
            String c = tran_reg(right, assign_add);
            System.out.println("\tlea    " + a + ",  [" + b + "+" + c + "]");
            return ;
        }
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
            if(Character.isDigit(ri.charAt(0)) || ri.charAt(0) == 'q') {
                System.out.println("\tmov    r15" + ",  " + ri);
                ri = "r15";
            }
            if(Character.isDigit(ri.charAt(1))) {
                ri += 'D';
                System.out.println("\tmov    " + "rax" + ",  " + le);
                System.out.println("\tcdq");
                System.out.println("\tidiv   " + ri);
                System.out.println("\tmov    " + le + ",  " + "rax");
            } else {
                System.out.println("\tmov    " + "rax" + ",  " + le);
                System.out.println("\tcdq");
                System.out.println("\tidiv   " + ri);
                System.out.println("\tmov    " + le + ",  " + "rax");
            }
        } else if(op.equals("%")) {
            if(Character.isDigit(ri.charAt(0)) ||  ri.charAt(0) == 'q') {
                System.out.println("\tmov    r15" + ",  " + ri);
                ri = "r15";
            }
            if(Character.isDigit(ri.charAt(1))) {
                ri += 'D';
                System.out.println("\tmov    " + "rax" + ",  " + le);
                System.out.println("\tcdq");
                System.out.println("\tidiv   " + ri);
                System.out.println("\tmov    " + le + ",  " + "rdx");
            } else {
                System.out.println("\tmov    " + "rax" + ",  " + le);
                System.out.println("\tcdq");
                System.out.println("\tidiv   " + ri);
                System.out.println("\tmov    " + le + ",  " + "rdx");
            }
        } else if(op.equals("<")) {
            if(Character.isDigit(le.charAt(0))) {
                System.out.println("\tmov    " + "rdx" + ",  " + le);
                le = "rdx";
            }
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetl   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("<=")) {
            if(Character.isDigit(le.charAt(0))) {
                System.out.println("\tmov    " + "rdx" + ",  " + le);
                le = "rdx";
            }
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetle   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals(">")) {
            if(Character.isDigit(le.charAt(0))) {
                System.out.println("\tmov    " + "rdx" + ",  " + le);
                le = "rdx";
            }
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetg   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals(">=")) {
            if(Character.isDigit(le.charAt(0))) {
                System.out.println("\tmov    " + "rdx" + ",  " + le);
                le = "rdx";
            }
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetge  al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("==")) {
            if(Character.isDigit(le.charAt(0))) {
                System.out.println("\tmov    " + "rdx" + ",  " + le);
                le = "rdx";
            }
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsete   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("!=")) {
            if(Character.isDigit(le.charAt(0))) {
                System.out.println("\tmov    " + "rdx" + ",  " + le);
                le = "rdx";
            }
            System.out.println("\tcmp    " + le + ",  " + ri);
            System.out.println("\tsetne   al");
            System.out.println("\tmovzx  " + "rax" + ",  al");
            System.out.println("\tmov    " + le + ",  rax");
        } else if(op.equals("&") || op.equals("&&")) {
            System.out.println("\tand    " + le + ",  " + ri);
        } else if(op.equals("|") || op.equals("||")) {
            System.out.println("\tor     " + le + ",  " + ri);
        } else if(op.equals("^")) {
            System.out.println("\txor    " + le + ",  " + ri);
        } else if(op.equals("<<")) {
            if(le.equals("rcx")) {
                System.out.println("\tmov    rax,  " + le);
                System.out.println("\tmov    rcx,  " + ri);
                System.out.println("\tshl    rax,  cl");
                System.out.println("\tmov    " + le + ",  rax");
            } else if(ri.equals("rcx")){
                System.out.println("\tshl    " + le + ",  cl");
            } else {
                System.out.println("\tpush   rcx");
                System.out.println("\tmov    rcx,  " + ri);
                System.out.println("\tshl    " + le + ",  cl");
                System.out.println("\tpop   rcx");
            }
        } else if(op.equals(">>")) {
            if(le.equals("rcx")) {
                System.out.println("\tmov    rax,  " + le);
                System.out.println("\tmov    rcx,  " + ri);
                System.out.println("\tsar    rax,  cl");
                System.out.println("\tmov    " + le + ",  rax");
            } else if(ri.equals("rcx")){
                System.out.println("\tsar    " + le + ",  cl");
            } else {
                System.out.println("\tpush   rcx");
                System.out.println("\tmov    rcx,  " + ri);
                System.out.println("\tsar    " + le + ",  cl");
                System.out.println("\tpop   rcx");
            }
        }
    }
    @Override
    public void ToString() {
        System.out.println("BinaryIr (" + address.oString() + ") = (" + left.oString() + ") " + op + " (" + right.oString() + ")");
    }
    @Override
    public List<Integer> def() {
        if(address.isVregister())
            return address.getnum();
        else
            return new ArrayList<>();
    }
    @Override
    public List<Integer> use() {
        List<Integer> a = fix(left.getnum(), right.getnum());
        if(!address.isVregister()) {
            a = fix(a, address.getnum());
        }
        return a;
    }
}
