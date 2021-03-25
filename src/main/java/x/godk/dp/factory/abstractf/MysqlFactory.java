package x.godk.dp.factory.abstractf;

/**
 * @author wt
 * @program practice
 * @create 2020-06-10  11:55
 */
public class MysqlFactory extends AbstractFactory {

    @Override
    IUserServer createUser() {
        return new MySqlServerUserServer();
    }

    @Override
    IDepServer createDepServer() {
        return new MySqlServerDepServer();
    }
}
