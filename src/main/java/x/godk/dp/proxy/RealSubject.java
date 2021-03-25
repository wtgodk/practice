package x.godk.dp.proxy;

/**
 * 真实 对象
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:42
 */
public class RealSubject implements Subject {
    @Override
    public void print() {
        System.out.println("real subject");
    }
}
