package x.godk.dp.factory.abstractf;

/**
 * @author wt
 * @program practice
 * @create 2020-06-10  11:54
 */
public class SqlServerFactory extends AbstractFactory {


    @Override
    IUserServer createUser() {
        return new SqlServerUserServer();
    }

    @Override
    IDepServer createDepServer() {
        return new SqlServerDepServer();
    }
}
