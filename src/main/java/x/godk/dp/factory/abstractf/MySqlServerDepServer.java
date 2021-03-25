package x.godk.dp.factory.abstractf;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  09:33
 */
public class MySqlServerDepServer implements IDepServer {
    @Override
    public void insertDep() {
        System.out.println("mysql server insert dep ");
    }

    @Override
    public void removeDep() {

        System.out.println("mysql server remove dep ");
    }
}
