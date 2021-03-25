package x.godk;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wt
 * @program practice
 * @create 2021-03-19  19:33
 */
public class DemoTest {

    private  static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return i.getAndIncrement();
            }
        });
        FutureTask futureTask2 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return i.getAndIncrement();
            }
        });

        new Thread(futureTask).start();
        new Thread(futureTask2).start();

        try {
            Object o = futureTask.get();
            Object o1 = futureTask2.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
