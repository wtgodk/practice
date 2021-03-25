package x.godk.dp.mediator;

/**
 * @author wt
 * @program practice
 * @create 2020-07-30  09:36
 */
public class MediatorTest {


    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Person a = new PersonA(mediator);
        Person b = new PersonB(mediator);
        mediator.setPersonA(a);
        mediator.setPersonB(b);

        a.send("你愁啥");
        b.send("抽你咋地");

    }
}
