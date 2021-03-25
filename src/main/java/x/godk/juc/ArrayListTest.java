package x.godk.juc;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author wt
 * @program practice
 * @create 2021-03-10  15:19
 */
public class ArrayListTest {

    public static void main(String[] args) {
        // LIST
        /*
            List    ->  ArrayList 不安全  底层数组实现 扩容参数 1.5  查找快
                        Vector   和ArrayList相同 但是在所有方法上都加上了 synchronized
                        CopyOnWriteArrayList    ReentrantLock 方法在 add方法上加锁 ，并且在写的时候会将底层数组复制一个长度+1的新数组，写完将该数组指向原有数组
                        Collections.synchronizedList(new ArrayList<>())  在执行发放上加了synchronized 同步代码块
                        LinkedList 线程不安全   增删快     底层链表结构   双向队列
         * */
        List<String> list = new LinkedList<>();
        list.add(null);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    list.add(j +"");
                    System.err.println(list);
                }
            }).start();
        }

    }
}
