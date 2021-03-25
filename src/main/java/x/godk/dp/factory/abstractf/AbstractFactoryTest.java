package x.godk.dp.factory.abstractf;

/**
 * 抽象工厂 测试
 *
 * @author wt
 * @program practice
 * @create 2020-06-10  11:52
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        AbstractFactory factory = new MysqlFactory();

        factory.createUser().insertUser();
        factory.createDepServer().insertDep();
    }


}
