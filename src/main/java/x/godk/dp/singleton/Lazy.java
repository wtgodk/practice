package x.godk.dp.singleton;

/**
 * @author wt
 * @program practice
 * @create 2020-06-12  13:50
 */
public class Lazy {

    private static Lazy instance = null;

    private Lazy() {

    }

    public static Lazy getInstance() {

        if (instance == null) {
            synchronized (Lazy.class) {
                if (instance == null) {
                    System.out.println("实例化------------------------------------------------------------");
                    instance = new Lazy();
                }
            }

        }
        return instance;
    }
}
