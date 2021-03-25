package x.godk.dp.subject;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体 委托者
 *
 * @author wt
 * @program practice
 * @create 2020-06-10  09:49
 */
@Setter
@Getter
public class Delegation implements Subject {
    /**
     * 委托者姓名  唯一标识
     */
    private String name;

    /**
     * 观察者 集合
     */
    private List<Event> observerList = new ArrayList<>();

    public Delegation(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void event(Event obj) {
        obj.invoke();
    }

    @Override
    public void addObserver(Event event) {
        if (!observerList.contains(event)) {
            observerList.add(event);
        }
    }

    @Override
    public void removerObserver(Event event) {
        observerList.remove(event);
    }
}
