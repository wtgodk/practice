package x.godk.dp.state;

/**
 * 状态 A
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  11:34
 */
public class ContextStateA implements State {

    /**
     * 下一个状态
     *
     * @return
     */
    @Override
    public void contextState(Context context) {
        //

        System.out.println("state A operation ,next state is B");
        context.setState(new ContextStateB());
    }
}
