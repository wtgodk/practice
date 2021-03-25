package x.godk;

import java.util.concurrent.CountDownLatch;

/**
 * @author wt
 * @program practice
 * @create 2021-03-18  19:49
 */
public class Test {


    private static volatile  boolean flag = true;
   public static void main(String[] args){
           CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
         // flag =   checkCustomerPrice(order);
          countDownLatch.countDown();
          System.out.println("结束1");
        }).start();
        new Thread(()->{
          //  flag =   checkInventory(order) ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("结束2");
            flag = false;
        }).start();


        while (countDownLatch.getCount()>0){

            if(!flag){
System.out.println("结束");
            }

        }


// 订单处理逻辑代码，不需要关注 return true;
    }





}
