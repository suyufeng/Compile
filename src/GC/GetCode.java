package GC;

import BE.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

/**
 * Created by suyufeng on 17-5-26.
 */
public class GetCode {
    List<Integer> globel = new ArrayList<>();
    List<String> pattern = new ArrayList<>();
    List<FunctionIr> function = new ArrayList<>();
    int ColorNum = 9;
    List<Ir> global = new ArrayList<>();
    Map<Integer, True_address> assign_add = new HashMap<>();
    Map<Pair<String, Integer>, List<Integer>> tt = new HashMap<>();
    SystemFunction Sfunction = new SystemFunction();

    Map<Pair<String, Integer>, List<Address>> parameters = new HashMap<>();

    Map<Integer, List<Integer>> def = new HashMap<>();
    Map<Integer, List<Integer>> use = new HashMap<>();
    Map<Integer, List<Integer>> out = new HashMap<>();
    Map<Integer, List<Integer>> in = new HashMap<>();
    Map<Integer, List<Integer>> suf = new HashMap<>();
    Map<Integer, Integer> label = new HashMap<>();

    Map<Integer, HashSet<Integer>> adj1 = new HashMap<>();
    Map<Integer, HashSet<Integer>> adj2 = new HashMap<>();

    Boolean[] used = new Boolean[10000000];

    int Vregister_num;

    public GetCode() {}
    public GetCode(List<Integer> globel, List<FunctionIr> function, List<String> pattern, Map<Pair<String, Integer>, List<Address>> tt, List<Ir> t1, int rege) {
        this.globel = globel;
        this.function = function;
        this.pattern = pattern;
        this.parameters = tt;
        this.global = t1;
        this.Vregister_num = rege;
    }

    void SystemFunction() {
        Sfunction.out();
    }

    int get_color(Map<Integer, Boolean> pattern) {
        int ans = -1;
        for(int i = 1; i <= ColorNum; i++) {
            if(!pattern.containsKey(i)) {
                return i;
            }
        }
        return ans;
    }

    void Color(List<Integer> tmp) {
        for(int i = tmp.size() - 1; i >= 0; i--) {
            Map<Integer, Boolean> colormap = new HashMap<>();
            int u = tmp.get(i);
            for(int j : adj2.get(u)) {
                if(assign_add.containsKey(j)) {
                    colormap.put(assign_add.get(j).reg, true);
                }
            }
            int flag = get_color(colormap);
            if(flag != -1) {
                //System.out.println(u + " " + flag);
                assign_add.put(u, new True_address(flag, 0));
            }
        }
    }

    List<Integer> build_graph(List<Ir> a, List<Address> b) {
        List<Ir> fix = new ArrayList<>();
        def.clear();use.clear();in.clear();out.clear();

        for(int i = 0; i < a.size(); i++) {
            Ir t = a.get(i);
            if(t instanceof Catch) {
                Catch tt = (Catch)t;
                label.put(tt.flag, i);
            }
        }

        for(int i = 0; i < a.size(); i++) {
            List<Integer> this_def = a.get(i).def();
            List<Integer> this_use = a.get(i).use();
            List<Integer> this_suf = a.get(i).suf(label);
            if(i + 1 < a.size()) {
                this_suf.add(i + 1);
            }
            def.put(i, this_def);
            use.put(i, this_use);
            suf.put(i, this_suf);
          //  System.out.println(i + " " + this_def + " " + this_use);
            in.put(i, new ArrayList<>());
            out.put(i, new ArrayList<>());
        }
        Boolean flag = true;
        while(true) {
            if(flag == false) {
                break;
            }
            flag = false;
            for(int i = a.size() - 1; i >= 0; i--) {
                List<Integer> edge = suf.get(i);
                List<Integer> outset = out.get(i);
                List<Integer> inset = in.get(i);
                int out_num = outset.size();
                int in_num = inset.size();
                for(int j = 0; j < edge.size(); j++) {
                    int u = edge.get(j);
                    outset = new Ir().fix(outset, in.get(u));
                }
                out.remove(i);
                out.put(i, outset);
                List<Integer> inse = new Ir().del(out.get(i), def.get(i));
                inset = new Ir().fix(inset, inse);
                inset = new Ir().fix(inset, use.get(i));
                in.remove(i);
                in.put(i, inset);
                if(outset.size() != out_num || inset.size() != in_num) {
                    flag = true;
                }
            }
        }
        List<Integer> all = new ArrayList<>();
        int Max = 0;

        for(int i = 0; i < b.size(); i++) {
            all.add(b.get(i).reg1.num);
        }
        for(int i = 0; i < a.size(); i++) {
            all = new Ir().fix(all, use.get(i));
            all = new Ir().fix(all, def.get(i));
        }
        for(int i = 0; i < all.size(); i++) {
            if(all.get(i) > Max) {
                Max = all.get(i);
            }
        }
        for(int i = 1; i <= Max; i++) {
            adj1.put(i, new HashSet<>());
            adj2.put(i, new HashSet<>());
        }
        for(int i = 0; i < a.size(); i++) {
            Ir now = a.get(i);
            List<Integer> Def = def.get(i);
            List<Integer> Out = out.get(i);
            for(int j = 0; j < Def.size(); j++) {
                for(int l = 0; l < Out.size(); l++) {
                    if(Def.get(j).equals(Out.get(l))) {
                        continue;
                    }
                    adj1.get(Def.get(j)).add(Out.get(l));
                    adj1.get(Out.get(l)).add(Def.get(j));
                    adj2.get(Def.get(j)).add(Out.get(l));
                    adj2.get(Out.get(l)).add(Def.get(j));
                }
            }

            List<Integer> Use = use.get(i);
            for(int j = 0; j < Def.size(); j++) {
                for(int l = 0; l < Use.size(); l++) {
                    if(Def.get(j).equals(Use.get(l))) {
                        continue;
                    }
                    adj1.get(Def.get(j)).add(Use.get(l));
                    adj1.get(Use.get(l)).add(Def.get(j));
                    adj2.get(Def.get(j)).add(Use.get(l));
                    adj2.get(Use.get(l)).add(Def.get(j));
                }
            }
        }
        if(a.size() > 0) {
            for (int i = 0; i < b.size(); i++) {
                List<Integer> pattern = in.get(0);
                for (int j = 0; j < pattern.size(); j++) {
                    if(pattern.get(j).equals(b.get(i).reg1.num)) {
                        continue;
                    }
                    adj1.get(b.get(i).reg1.num).add(pattern.get(j));
                    adj1.get(pattern.get(j)).add(b.get(i).reg1.num);
                    adj2.get(b.get(i).reg1.num).add(pattern.get(j));
                    adj2.get(pattern.get(j)).add(b.get(i).reg1.num);
                }
            }
        }

        List<Integer> queue = new ArrayList<>();
        for(int i = 0; i < all.size(); i++) {
            int to = all.get(i);
            used[to] = false;
            if(adj1.get(to).size() <= ColorNum) {
                used[to] = true;
                queue.add(to);
            }
        }
        int i = -1;
        while(true) {
            if (i + 1 == queue.size()) {
                for(int j = 0; j < all.size(); j++) {
                    int to = all.get(j);
                    if(!used[to]) {
                        used[to] = true;
                        queue.add(to);
                        break;
                    }
                }
                if(i + 1== queue.size()) {
                    break;
                }
                continue;
            }
            i++;
            int u = queue.get(i);
            HashSet<Integer> myset = adj1.get(u);
            for(Integer j : myset) {
                adj1.get(j).remove(u);
                if(adj1.get(j).size() <= ColorNum) {
                    if(!used[j]) {
                        used[j] = true;
                        queue.add(j);
                    }
                }
            }
        }

        Color(queue);
        return all;
    }

    public void Assign_true_reg() {
        for(int i = 0; i < function.size(); i++) {
            tt.put(new Pair<String, Integer>(function.get(i).name, function.get(i).label), build_graph(function.get(i).content, parameters.get(new Pair<String, Integer>(function.get(i).name, function.get(i).label))));
            List<Ir> now = function.get(i).content;
            for(int j = 0; j + 1 < now.size(); j++) {
                Ir cur = now.get(j);
                Ir nxt = now.get(j + 1);
                if(cur instanceof Move && nxt instanceof Move) {
                    Move Cur_move = (Move)cur;
                    Move Nxt_move = (Move)nxt;
                    if(Cur_move.left.equal(Nxt_move.right)){
                        if(Cur_move.left.isVregister()) {
                            List<Integer> OU = out.get(j + 1);
                            boolean flag = true;
                            for(int l = 0; l < OU.size(); l++) {
                                if(OU.get(l).equals(Cur_move.left.reg1.num)) {
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag) {
                                Nxt_move.right = Cur_move.right;
                                Cur_move.skip = true;
                            }
                        }
                    }
                }
                if(cur instanceof Jump && nxt instanceof Catch) {
                    Jump Cur_Jump = (Jump)cur;
                    Catch Nxt_Jump = (Catch) nxt;
                    if(Cur_Jump.yes.flag == Nxt_Jump.flag) {
                        Cur_Jump.skip = true;
                    }
                }
            }
        }
    }

    public void prepare() {
        System.out.println("global  main");
        System.out.println("extern scanf");
        System.out.println("extern printf");
        System.out.println("extern puts");
        System.out.println("extern strlen");
        System.out.println("extern memcpy");
        System.out.println("extern sscanf");
        System.out.println("extern sprintf");
        System.out.println("extern malloc");
        System.out.println("extern strcmp");
        System.out.println("    section .bss");
        System.out.println("stringbuffer:");
        System.out.println("	resb 256");
        for(int i = 0; i < globel.size(); i++) {
            System.out.println("globel." + Integer.toString(i + 1) + ": resq 1");
        }
        System.out.println("");

        System.out.println("    section .data");
        System.out.println("intbuffer:");
        System.out.println("	dq 0");
        System.out.println("format1:");
        System.out.println("	db\"%lld\",0");
        System.out.println("format2:");
        System.out.println("	db\"%lld \",10,0");
        System.out.println("format3:");
        System.out.println("	db\"%s\",0");
        System.out.println("format4:");
        System.out.println("	db\"%s\",10,0");
        for(int i = 0; i < pattern.size(); i++) {
            int length = pattern.get(i).length();
            char last = ' ';
            int true_length = length;
            for(int j = 0; j < length; j++) {
                if(pattern.get(i).charAt(j) == '\\' && last != '\\') {
                    true_length--;
                }
                last = pattern.get(i).charAt(j);
            }

            System.out.println("dq  " + true_length);
            String t = "";
            for(int j = 0; j < pattern.get(i).length(); j++) {
                if(pattern.get(i).charAt(j) == '`') {
                    t += "`,\"`\",`";
                } else if(pattern.get(i).charAt(j) == ';') {
                    t += "`,\";\",`";
                } else {
                    t += pattern.get(i).charAt(j);
                }
            }
            System.out.println("string." + Integer.toString(i) + ": db `" + t + "`, 0");
        }
        System.out.println("format: db  \"%lld\", 0");
        System.out.println("");

        assign_add.put(10000001, new True_address(10, 0));
        assign_add.put(10000002, new True_address(11, 0));
        assign_add.put(10000003, new True_address(12, 0));
        int label = 0;
        for(int i = 0; i < function.size(); i++) {
            if(function.get(i).name.equals("main") && function.get(i).label == 0) {
                label = i;
                break;
            }
        }
        for(int i = 0; i < function.get(label).content.size(); i++) {
            global.add(function.get(label).content.get(i));
        }
        function.get(label).content.clear();
        function.get(label).content = global;
        if(Vregister_num < 800)
            Assign_true_reg();
        for(int i = 0; i < function.size(); i++) {
            FunctionIr now = function.get(i);
            {
                List<Integer> num = tt.get(new Pair<String, Integer>(now.name, now.label));
                Map<Integer, Boolean> color2 = new HashMap<>();
                if(num != null) {
                    for(int l = 0; l < num.size(); l++) {
                        if(assign_add.containsKey(num.get(l)) && assign_add.get(num.get(l)).reg != 0) {
                            if(!color2.containsKey(assign_add.get(num.get(l)).reg) && assign_add.get(num.get(l)).reg > 0){
                                color2.put(assign_add.get(num.get(l)).reg, true);
                                now.save.add(new Address(new Vregister(num.get(l))));
                            }
                        }
                    }
                }
            }
            for(int j = 0; j < now.content.size(); j++) {
                Ir instruction = now.content.get(j);
                if(instruction instanceof CallIr) {
                    CallIr CallIr = (BE.CallIr)instruction;
                    List<Integer> num = tt.get(new Pair<String, Integer>(now.name, now.label));
                    Map<Integer, Boolean> color2 = new HashMap<>();
                    if(num != null) {
                        for(int l = 0; l < num.size(); l++) {
                            if(assign_add.containsKey(num.get(l)) && assign_add.get(num.get(l)).reg != 0) {
                                if(!color2.containsKey(assign_add.get(num.get(l)).reg) && assign_add.get(num.get(l)).reg <= 0){
                                    color2.put(assign_add.get(num.get(l)).reg, true);
                                    CallIr.save.add(new Address(new Vregister(num.get(l))));
                                }
                            }
                        }
                    }
                }
                if(instruction instanceof Malloc) {
                    Malloc Malloc = (Malloc)instruction;
                    List<Integer> num = tt.get(new Pair<String, Integer>(now.name, now.label));
                    Map<Integer, Boolean> color2 = new HashMap<>();
                    if(num != null) {
                        for(int l = 0; l < num.size(); l++) {
                            if(assign_add.containsKey(num.get(l)) && assign_add.get(num.get(l)).reg != 0) {
                                if(!color2.containsKey(assign_add.get(num.get(l)).reg) && assign_add.get(num.get(l)).reg <= 5){
                                    color2.put(assign_add.get(num.get(l)).reg, true);
                                    Malloc.save.add(new Address(new Vregister(num.get(l))));
                                }
                            }
                        }
                    }
                }
                if(instruction instanceof Temp) {
                    int num = ((Temp)instruction).add.reg1.num;
                    if(!assign_add.containsKey(num)) {
                        now.add_num += 8;
                        assign_add.put(num, new True_address(0, now.add_num));
                    }
                }
                //instruction.ToString();
            }
        }
    }

    public void work() {
        System.out.println("    section .text");
        for(int i = 0; i < function.size(); i++) {
            FunctionIr now = function.get(i);
            now.translate(assign_add, 0);
            //System.out.print(" ");
        }
        SystemFunction();
    }

}
