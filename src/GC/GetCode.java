package GC;

import BE.FunctionIr;
import BE.Ir;
import BE.Temp;

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
    Map<Integer, Integer> assign_add = new HashMap<>();
    public GetCode() {}
    public GetCode(List<Integer> globel, List<FunctionIr> function, List<String> pattern) {
        this.globel = globel;
        this.function = function;
        this.pattern = pattern;
    }

    public void prepare() {
        System.out.println("    section .bss");
        for(int i = 0; i < globel.size(); i++) {
            System.out.println("globel." + Integer.toString(i + 1) + ": resq 1");
        }
        System.out.println("");

        System.out.println("    section .data");
        for(int i = 0; i < pattern.size(); i++) {
            System.out.println("string." + Integer.toString(i + 1) + ": db " + pattern.get(i) + " 0");
        }
        System.out.println("");

        for(int i = 0; i < function.size(); i++) {
            FunctionIr now = function.get(i);
            for(int j = 0; j < now.content.size(); j++) {
                Ir instruction = now.content.get(j);
                if(instruction instanceof Temp) {
                    int num = ((Temp)instruction).add.reg1.num;
                    assign_add.put(num, now.add_num);
                    now.add_num += 8;
                }
            }
        }
    }

    public void work() {
        System.out.println("    section .text");
    }

}
