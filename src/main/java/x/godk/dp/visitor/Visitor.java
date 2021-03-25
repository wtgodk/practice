package x.godk.dp.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wt
 * @program practice
 * @create 2020-08-04  09:13
 */
public class Visitor {

    private List<Person> personList = new ArrayList<>();


    public void add(Person person) {
        personList.add(person);
    }


    public void del(Person person) {
        personList.remove(person);
    }

    public void display(Action action) {
        personList.forEach(x -> {
            x.accept(action);
        });
    }


}
