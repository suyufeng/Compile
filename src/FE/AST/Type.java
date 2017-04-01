package FE.AST;

import java.util.List;

/**
 * Created by suyufeng on 17-3-29.
 */
public class Type {
    public String type;
    public int len, have;
    public Type() {}
    public Type(String a_type, Integer a) {
        type = a_type;
        len = a;
        have = 0;
    }
    public Type(String a_type, Integer a, Integer b) {
        type = a_type;
        len = a;
        have = b;
    }
    public Type(String a_type) {
        type = a_type;
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
