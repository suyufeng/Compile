package BE;

import FE.CST.Checkconflict;

/**
 * Created by suyufeng on 17-5-22.
 */
public class Catch extends Ir{
    public int flag;
    public Catch(int flag) {
        this.flag = flag;
    }
    @Override
    public void ToString(){
        System.out.println("Catch " + "flag: " + Integer.toString(flag));
    }
}
