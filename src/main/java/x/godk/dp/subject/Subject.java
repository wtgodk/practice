package x.godk.dp.subject;

/**
 * 委托者 接口
 * <p>
 * 发送消息
 *
 * @author wt
 * @program practice
 * @create 2020-06-10  09:46
 */
public interface Subject {


    /**
     * 发送 执行消息
     *
     * @param obj 具体事件
     */
    void event(Event obj);

    /**
     * 添加观察者
     *
     * @param event 观察者
     */
    void addObserver(Event event);

    /**
     * 移除观察者
     *
     * @param event 观察者  根据 name 作为唯一标识
     */
    void removerObserver(Event event);


    String getName();


}
