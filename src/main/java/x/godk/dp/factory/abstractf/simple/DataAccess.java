package x.godk.dp.factory.abstractf.simple;

import x.godk.dp.factory.abstractf.*;

/**
 * 简单工厂模式  改进抽象工厂模式 扩展 需要 更改 客户端代码 的 不足之处
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  09:35
 */
public class DataAccess {

    private final static String db = "mySql";

    private final static String className = "x.godk.dp.factory.abstractf.MySqlServerUserServer";

    /**
     * 版本 1 使用switch 增加需求 需要增加 case  不方便
     *
     * @return
     */
    public static IUserServer createUserServer() {
        switch (db) {
            case "mySql":
                return new MySqlServerUserServer();
            case "sqlServer":
                return new SqlServerUserServer();
            default:
                throw new RuntimeException("db can not find instance ");
        }
    }

    /**
     * 版本 1 使用switch 增加需求 需要增加 case  不方便
     *
     * @return
     */
    public static IDepServer createDepServer() {
        switch (db) {
            case "mySql":
                return new MySqlServerDepServer();
            case "sqlServer":
                return new SqlServerDepServer();
            default:
                throw new RuntimeException("db can not find instance ");
        }
    }

    /**
     * 版本 2  使用反射 干掉 switch
     *
     * @return
     */
    public static IUserServer createUserServerByReflection() {
        try {
            Class<?> aClass = Class.forName(className);
            return (IUserServer) aClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("db can not find instance ");
        }
    }


}
