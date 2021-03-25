package x.godk.dp.observer;

/**
 * 观察者模式 测试
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  14:06
 */
public class ObserverTest {


    public static void main(String[] args) {
        Informer informer = new Boss("我胡汉三又回来了");
        informer.add(new LiSi(informer));
        informer.add(new ZhangSan(informer));
        informer.notice();
    }
}
