package x.godk.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wt
 * @program practice
 * @create 2021-03-10  15:29
 */
public class HashSetTest {

/*
 * Set 线程安全问题

        *   HashSet 线程不安全  允许null 不允许重复 底层HashMap  默认大小 16  扩容银子 0.75
        *   TreeSet 线程不安全  不允许null  底层红黑树
        *   CopyOnWriteArraySet 线程安全 底层CopyOnWriteArrayList 所以他是有序的
        *   Collections.synchronizedSet(new HashSet<>());  在方法执行前添加了一个 synchronized代码块
        *
 */

    public static void main(String[] args) {

        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        set.add(null);
        for (int i = 0; i < 100; i++) {


            new Thread(()->{
              //  for (int j = 0; j < 10; j++) {
                    set.add(UUID.randomUUID().toString().substring(0,10));
                    System.err.println(set);
              //  }
            }).start();
        }
       // System.err.println(set);
    }

}
