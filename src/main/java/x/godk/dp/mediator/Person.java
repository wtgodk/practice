package x.godk.dp.mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * 人
 *
 * @author wt
 * @program practice
 * @create 2020-07-30  09:27
 */
@Setter
@Getter
public abstract class Person {


    private Mediator mediator;

    public Person(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void notice(String message);

    public abstract void send(String message);

}
