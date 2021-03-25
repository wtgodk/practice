package x.godk.dp.state;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  11:36
 */
public class ContextStateB implements State {


    @Override
    public void contextState(Context context) {
        System.out.println("state B operation ,next state is A");
        context.setState(new ContextStateA());
    }
}
