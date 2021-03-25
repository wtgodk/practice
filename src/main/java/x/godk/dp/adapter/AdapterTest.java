package x.godk.dp.adapter;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  13:37
 */
public class AdapterTest {

    public static void main(String[] args) {


        Target target = new Adapater(new Adaptee());
        target.request();
    }
}
