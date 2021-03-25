package x.godk.dp.subject;

/**
 * 委托 测试
 *
 * @author wt
 * @program practice
 * @create 2020-06-10  10:22
 */
public class EventTest {

    public static void main(String[] args) {

        //创建一个 委托者

        Subject delegation = new Delegation("哨兵");


        //  delegation.addObserver(new MrZhang());
        Event event = new Event(new MrZhang(), "doEvent", delegation, "胡汉三回来了");
        delegation.event(event);


    }
}
