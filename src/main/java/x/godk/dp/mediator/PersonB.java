package x.godk.dp.mediator;

/**
 * @author wt
 * @program practice
 * @create 2020-07-30  09:34
 */
public class PersonB extends Person {
    public PersonB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notice(String message) {
        System.out.println("person b 接收到消息：" + message);
    }

    @Override
    public void send(String message) {
        getMediator().notice(message, this);
    }
}
