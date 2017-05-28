package GC;

import BE.*;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suyufeng on 17-5-26.
 */
public class GetCode {
    List<Integer> globel = new ArrayList<>();
    List<String> pattern = new ArrayList<>();
    List<FunctionIr> function = new ArrayList<>();
    Map<Integer, True_address> assign_add = new HashMap<>();
    Map<Pair<String, Integer>, List<Address>> tt = new HashMap<>();
    public GetCode() {}
    public GetCode(List<Integer> globel, List<FunctionIr> function, List<String> pattern, Map<Pair<String, Integer>, List<Address>> tt) {
        this.globel = globel;
        this.function = function;
        this.pattern = pattern;
        this.tt = tt;
    }

    void SystemFunction() {
        System.out.println("printInt.0:");
        System.out.println("\tmov    rsi,  qword[rsp + 8]");
        System.out.println("\tmov    rdi,  format");
        System.out.println("\txor    rax,  rax");
        System.out.println("\tcall   printf");
        System.out.println("\tret");
    }

    public void prepare() {
        System.out.println("global  main");
        System.out.println("extern  printf");
        System.out.println("    section .bss");
        for(int i = 0; i < globel.size(); i++) {
            System.out.println("globel." + Integer.toString(i + 1) + ": resq 1");
        }
        System.out.println("");

        System.out.println("    section .data");
        for(int i = 0; i < pattern.size(); i++) {
            System.out.println("string." + Integer.toString(i + 1) + ": db " + pattern.get(i) + " 0");
        }
        System.out.println("format: db  \"%lld\", 0");
        System.out.println("");

        assign_add.put(10000001, new True_address(9, 0));
        assign_add.put(10000002, new True_address(10, 0));
        assign_add.put(10000003, new True_address(11, 0));
        for(int i = 0; i < function.size(); i++) {
            FunctionIr now = function.get(i);
            for(int j = 0; j < now.content.size(); j++) {
                Ir instruction = now.content.get(j);
                if(instruction instanceof CallIr) {
                    CallIr CallIr = (BE.CallIr)instruction;
                    CallIr.save = tt.get(new Pair<String, Integer>(now.name, now.label));
                }
                if(instruction instanceof Temp) {
                    int num = ((Temp)instruction).add.reg1.num;
                    now.add_num += 8;
                    assign_add.put(num, new True_address(0, now.add_num));
                }
               //instruction.ToString();
            }
        }
    }

    public void work() {
        System.out.println("    section .text");
        for(int i = 0; i < function.size(); i++) {
            FunctionIr now = function.get(i);
            now.translate(assign_add);
        }
        SystemFunction();
    }

}
