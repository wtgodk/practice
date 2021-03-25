package x.godk.dp.state;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  11:39
 */
public class ContextStateC implements State {
    @Override
    public void contextState(Context context) {
        System.out.println("state C operation ,next state is A ");
        context.setState(new ContextStateA());
    }
}
