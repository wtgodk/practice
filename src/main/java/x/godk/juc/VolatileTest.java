package x.godk.juc;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wt
 * @program practice
 * @create 2021-03-10  11:57
 */

class MyData{

   volatile  int flag = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
// 默认 非公平锁
    Lock LOCK = new ReentrantLock();

    public    void change(){
//        try {
//            LOCK.lock();
//            flag++;
//        }finally {
//            LOCK.unlock();
//        }
//
        atomicInteger.getAndIncrement();

    }

}

public class VolatileTest {


    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.change();
                }
            },String.valueOf(i)).start();
        }

        TimeUnit.MILLISECONDS.sleep(5000);
//        while(myData.flag ==0){
//       //  System.out.println(1);
//        }
//        System.out.println("执行结束");
        System.out.println(myData.atomicInteger.get());
    }


}
