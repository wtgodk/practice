package x.godk;

import java.util.HashMap;

/**
 * @author wt
 * @program practice
 * @create 2021-03-22  19:15
 */
public class DemoTest3 {

    public static void main(String[] args) {
            System.out.println(hammingWeight(10));
    }


    public static int hammingWeight(int val) {

        HashMap
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if ((val & (1 << i)) != 0) {
                num++;
            }
        }
        return num;
    }
}
