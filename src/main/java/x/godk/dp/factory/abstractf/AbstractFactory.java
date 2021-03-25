package x.godk.dp.factory.abstractf;

/**
 * 抽象工厂
 *
 * @author wt
 * @program practice
 * @create 2020-06-10  11:53
 */
public abstract class AbstractFactory {
    /**
     * 插入用户
     */
    abstract IUserServer createUser();


    abstract IDepServer createDepServer();

}
