package x.godk.dp.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wt
 * @program practice
 * @create 2020-06-09  13:51
 */
@Data
public abstract class Informer {
    /**
     * 通知内容
     */
    private String action;
    /**
     * 观察者 列表 ，表示 需要被通知的 对象
     */
    private List<AbstractObserver> observerList = new ArrayList<>();

    public Informer(String action) {
        this.action = action;
    }

    public void remove(AbstractObserver observer) {
        observerList.remove(observer);
    }

    public void add(AbstractObserver observer) {
        observerList.add(observer);
    }


    /**
     * 通知  抽象方法
     */
    public void notice() {
        List<AbstractObserver> observerList = getObserverList();
        observerList.forEach(AbstractObserver::notice);
    }


}
