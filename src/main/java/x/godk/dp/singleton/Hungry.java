package x.godk.dp.singleton;

/**
 * 饿汉式 单例
 *
 * @author wt
 * @program practice
 * @create 2020-06-12  13:39
 */
public class Hungry {

    private static final Hungry hungry = new Hungry();

    private Hungry() {
    }


    public static Hungry getInstance() {
        return hungry;
    }


}
