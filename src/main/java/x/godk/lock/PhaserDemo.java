package x.godk.lock;

import java.io.IOException;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author wt
 * @program practice
 * @create 2021-01-19  14:29
 */
class MyData extends  Phaser{

    public MyData(int parties) {
        super(parties);
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println(Thread.currentThread().getName() + "\t 执行完成:" + phase +"\t 注册放"+ registeredParties);
        return false;
    }
}


public class PhaserDemo {

    public static void main(String[] args) throws IOException {
        int parties = 3;
        int phases = 4;
//        final Phaser phaser = new Phaser(parties) {
//            @Override
//            protected boolean onAdvance(int phase, int registeredParties) {
//                System.out.println("====== Phase : " + phase + " ======");
//                return registeredParties == 0;
//            }
//        };
        MyData myData = new MyData(parties);
        for (int i = 0; i < parties; i++) {
           new Thread(() -> {
                for (int phase = 0; phase < phases; phase++) {
                    System.out.println(Thread.currentThread().getName() +"\t 开始执行");
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                        //执行完成
                        System.out.println(Thread.currentThread().getName() +"\t 执行完成");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myData.arriveAndAwaitAdvance();
                }
            },String.valueOf(i)+"thread ").start();
        }
    }
}
