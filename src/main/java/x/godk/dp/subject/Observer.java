package x.godk.dp.subject;

/**
 * 观察者  执行委托者的 event
 *
 * @author wt
 * @program practice
 * @create 2020-06-10  09:48
 */
public interface Observer {


    /**
     * 执行  时间
     */
    void doEvent(Subject subject, String msg);
}
