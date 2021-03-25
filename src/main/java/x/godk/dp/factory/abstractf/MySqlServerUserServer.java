package x.godk.dp.factory.abstractf;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  09:18
 */
public class MySqlServerUserServer implements IUserServer {
    @Override
    public void insertUser() {
        System.out.println("mysql insert user ");
    }

    @Override
    public void removeUser() {
        System.out.println("mysql remove user ");
    }
}
