package FE.AST;

import java.util.List;

/**
 * Created by suyufeng on 17-3-29.
 */
public class Type {
    public String type;
    public int len = 0, have = 0;
    public Boolean flag;
    public Type() {
        flag = false;
    }
    public Type(String a_type, Integer a) {
        type = a_type;
        flag = false;
        if(a_type.equals("int") || a_type.equals("string") || a_type.equals("bool")) {
            flag = true;
        }
        len = a;
        have = 0;
    }
    public Type(String a_type, Integer a, Integer b) {
        type = a_type;
        flag = false;
        if(a_type.equals("int") || a_type.equals("string") || a_type.equals("bool")) {
            flag = true;
        }
        len = a;
        have = b;
    }
    public Type(String a_type) {
        type = a_type;
        flag = false;
        if(a_type.equals("int") || a_type.equals("string") || a_type.equals("bool")) {
            flag = true;
        }
        have = len = 0;
    }
    public void print() {
        System.out.println(type + " " + len + " " + have);
    }
    public Boolean Compareto(Type x) {
        if(x.have != have || x.len != len) {
            return false;
        }
        return x.type.compareTo(type) == 0;
    }
}
