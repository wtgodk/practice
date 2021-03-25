package x.godk.dp.observer;

import lombok.Data;

/**
 * 观察者 模式
 * 观察者接口 允许加入 观察者 和 被通知
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  13:47
 */
@Data
public abstract class AbstractObserver {

    private Informer informer;
    /**
     * 观察者 姓名
     */
    private String name;

    public AbstractObserver(String name, Informer informer) {
        this.name = name;
        this.informer = informer;
    }

    /**
     * 接受 到通知
     */
    public abstract void notice();


}
