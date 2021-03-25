package x.godk.dp.memento;

/**
 * 备忘录模式
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  14:02
 */
public class MementoTest {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("初始状态");
        originator.show();
        //创建备忘
        Memento memento = originator.createMemento();
        // 将备忘放到 备忘管理者这里
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);

        originator.setState("无状态");
        originator.show();
        // 恢复备忘
        originator.recover(caretaker.getMemento());
        originator.show();
    }
}
