package x.godk.dp.factory.abstractf.simple;

import x.godk.dp.factory.abstractf.IUserServer;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  09:40
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        IUserServer userServer = DataAccess.createUserServer();
        userServer.insertUser();

        IUserServer userServerByReflection = DataAccess.createUserServerByReflection();
        userServerByReflection.insertUser();
    }
}
