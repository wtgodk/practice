package x.godk.dp.factory.abstractf;

/**
 * @author wt
 * @program practice
 * @create 2020-06-10  11:57
 */
public class SqlServerUserServer implements IUserServer {


    @Override
    public void insertUser() {
        System.out.println("sql server insert user ");
    }


    @Override
    public void removeUser() {
        System.out.println("sql server remove user ");
    }
}
