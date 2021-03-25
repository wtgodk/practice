package x.godk.dp.visitor;

/**
 * @author wt
 * @program practice
 * @create 2020-08-04  09:14
 */
public class PersonMan implements Person {


    @Override
    public void accept(Action action) {
        action.manAction(this);
    }
}
