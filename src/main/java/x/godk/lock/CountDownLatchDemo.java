package x.godk.lock;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wt
 * @program practice
 * @create 2021-01-19  14:22
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        System.out.println(Thread.currentThread().getName() +"\t 开始执行");
        // 创建是个线程
        for (int i = 0; i < 10; i++) {

            new  Thread(()->{
                System.out.println(Thread.currentThread().getName() +"\t 开始执行");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"\t 执行结束");
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }


        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() +"\t 执行结束");

    }
}
