package x.godk.dp.mediator;

/**
 * @author wt
 * @program practice
 * @create 2020-07-30  09:28
 */
public class PersonA extends Person {


    public PersonA(Mediator mediator) {
        super(mediator);
    }


    @Override
    public void notice(String message) {

        System.out.println("person A 接收到消息" + message);
    }

    @Override
    public void send(String message) {
        getMediator().notice(message, this);
    }


}
