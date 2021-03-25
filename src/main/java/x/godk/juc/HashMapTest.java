package x.godk.juc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wt
 * @program practice
 * @create 2021-03-10  15:46
 */
public class HashMapTest {

/*
 *   Map类
 *          HashMap  线程不安全  底层是 数组+链表  长度大于 初始化一个 默认为16 扩容因子为 1.5
 *
 */
    public static void main(String[] args) {
        int val =  (int)(1.0f/0.75f);
        System.out.println(val);
        Map<String,Object> map = new HashMap<>();
        Collection<Object> values = map.values();
        Object o = new Object();
        for (int i = 0; i < 10; i++) {
        //    new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    Object put = map.put(UUID.randomUUID().toString().substring(0, 5), o);
                    if(put!=null){
                        System.out.println();
                    }
                    System.err.println(put);
                }
        //    }).start();
        }

    }
}
