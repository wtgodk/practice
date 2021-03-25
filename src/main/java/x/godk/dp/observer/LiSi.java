package x.godk.dp.observer;

/**
 * @author wt
 * @program practice
 * @create 2020-06-09  14:03
 */
public class LiSi extends AbstractObserver {

    public LiSi(Informer informer) {
        super("天网恢恢", informer);
    }

    @Override
    public void notice() {
        System.out.println(getName() + " 收到通知 " + getInformer().getAction());
    }
}
