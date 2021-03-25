package x.godk.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author wt
 * @program practice
 * @create 2021-03-10  14:52
 */
public class AtomicMarkableReferenceTest {

    //解决CAS ABA问题
    public static void main(String[] args) {

        AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<Integer>(0,false);

        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           boolean b =  atomicMarkableReference.compareAndSet(0,1,false,true);
            System.out.println(Thread.currentThread().getName()+"\t 试图将值 从0改成1");
            if(b){
                System.out.println(Thread.currentThread().getName()+"\t 更改成功");
            }
        },"AA").start();
        new Thread(()->{},"AA").start();


        new Thread(()->{

            boolean b = atomicMarkableReference.compareAndSet(1, 0, true, false);
            System.out.println(Thread.currentThread().getName()+"\t 试图将值 从1改成0");
            if(b){
                System.out.println(Thread.currentThread().getName()+"\t 更改成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 更改失败");
            }

        },"AA").start();
        new Thread(()->{},"BB").start();
    }
}
