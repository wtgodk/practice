package x.godk.dp.flyweight;

/**
 * @author wt
 * @program practice
 * @create 2020-07-30  10:06
 */
public class ConcreteFlyweight implements Flyweight {


    @Override
    public void operation(String flag, String msg) {
        System.out.println(flag + "<>" + msg);
    }
}
