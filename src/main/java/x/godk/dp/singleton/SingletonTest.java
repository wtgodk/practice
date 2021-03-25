package x.godk.dp.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 单例模式
 *
 * @author wt
 * @program practice
 * @create 2020-06-12  13:37
 */
public class SingletonTest {

    private static String str;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int threadNum = 5;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {

                for (int i1 = 0; i1 < 1000; i1++) {

                    //  getSingleton();
                    getLazy();
                    /*//1.测试饿汉式
                    HungrySingleton hungrySingleton = HungrySingleton.getSinletonInstance();

                    //2.测试懒汉式
                    LazySingleton lazySingleton = LazySingleton.getLazySingletonInstance();
                    //3.测试双重检测锁
                    SingletonDCL singletonDCL = SingletonDCL.getInstance();
                    //4.测试静态内部类
                    LazySingleton1 lazySingleton1 = LazySingleton1.getLazySingletonInstance();
                    //5.测试枚举
                    SingletonEnum singletonEnum = SingletonEnum.singletonEnumInstance;*/
                }
                countDownLatch.countDown();
            }).start();
        }


    }

    public static void getSingleton() {
        Hungry instance = Hungry.getInstance();
        System.out.println(Thread.currentThread().getName() + "<>" + instance);
    }

    public static void getLazy() {
        Lazy instance = Lazy.getInstance();
        String s = instance.toString();
        if (str == null) {
            str = s;
        }
        if (!s.equals(str)) {
            System.out.println(s);
        }
        System.out.println(Thread.currentThread().getName() + "<>" + instance);
    }

}
