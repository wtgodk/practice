package x.godk.dp.state;

/**
 * 状态模式 测试类
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  11:30
 */
public class StateTest {

    public static void main(String[] args) {
        Context context = new Context(new ContextStateC());
        for (int i = 0; i < 10; i++) {
            context.request();
        }


    }
}
