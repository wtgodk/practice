package x.godk.dp.observer;

/**
 * 法外狂徒 张三  观察者 之一
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  13:59
 */
public class ZhangSan extends AbstractObserver {


    public ZhangSan(Informer informer) {
        super("法外狂徒", informer);
    }

    @Override
    public void notice() {

        System.out.println(getName() + " 收到通知 " + getInformer().getAction());
    }
}
