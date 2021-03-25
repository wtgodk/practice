package x.godk.dp.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * 备忘 发起人
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  13:55
 */
@Setter
@Getter
public class Originator {

    /**
     * 当前  信息 ，在初始化的时候
     */
    private String state;


    public void recover(Memento memento) {
        //恢复备忘
        this.state = memento.getState();

    }

    public Memento createMemento() {
        //创建备忘
        return new Memento(state);
    }

    public void show() {
        System.out.println("当前state:" + state);
    }
}
