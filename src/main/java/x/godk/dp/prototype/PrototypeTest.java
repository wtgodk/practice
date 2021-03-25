package x.godk.dp.prototype;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wt
 * @program practice
 * @create 2020-06-05  15:00
 */
public class PrototypeTest {

    public static void main(String[] args) {

        Prototype prototype = new Prototype("godk", "male");
        try {
            Prototype clone = (Prototype) prototype.clone();
            clone.setName("jgodk");
            System.out.println(prototype.toString());
            System.out.println(clone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
