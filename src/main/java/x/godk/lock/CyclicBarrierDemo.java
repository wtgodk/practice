package x.godk.lock;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author wt
 * @program practice
 * @create 2021-01-19  14:26
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int totalThread = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < totalThread; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() +"\t 线程开始");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"\t 线程结束 ");
            },String.valueOf(i)).start();

        }






    }
}
