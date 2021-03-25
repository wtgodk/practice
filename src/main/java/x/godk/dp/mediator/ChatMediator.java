package x.godk.dp.mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wt
 * @program practice
 * @create 2020-07-30  09:33
 */
@Setter
@Getter
public class ChatMediator implements Mediator {

    private Person personA;
    private Person personB;

    @Override
    public void notice(String message, Person person) {

        if (personA.equals(person)) {
            personB.notice(message);
        } else {
            personA.notice(message);
        }
    }
}
