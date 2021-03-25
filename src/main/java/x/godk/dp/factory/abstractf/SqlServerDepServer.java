package x.godk.dp.factory.abstractf;

/**
 * sql server dep 操作
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  09:32
 */
public class SqlServerDepServer implements IDepServer {
    @Override
    public void insertDep() {
        System.out.println("sql server insert dep ");
    }

    @Override
    public void removeDep() {
        System.out.println("sql server remove dep ");
    }
}
