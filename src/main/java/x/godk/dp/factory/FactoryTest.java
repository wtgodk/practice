package x.godk.dp.factory;

/**
 * 工厂模式测试
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  15:28
 */
public class FactoryTest {


    public static void main(String[] args) {
        // 如果 要增加 其他的类型 Student 需要  增加 Student以外还要增加对应的工厂类，但是客户端只需要更改 new StudentFactory(); 为指定的工厂即可
        Factory factory = new StudentFactory();
        Student student = factory.create();
        student.dota();
        student.eat();
        student.sleep();
    }
}
