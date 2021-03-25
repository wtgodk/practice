package x.godk.volatiletest;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author wt
 * @program practice
 * @create 2021-03-08  09:18
 */
public class VolatileTest {


    static class MyData{
     volatile   int nums;
        public void numsTo3(){
            this.nums = 3;
        }
    }

    public static void main(String[] args) {

//        MyData myData = new MyData();
//
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            myData.numsTo3();
//            System.out.println(Thread.currentThread() + " myData nums : " + myData.nums);
//        },"thread1").start();
//
//        while(myData.nums == 0){
//
//        }
//        System.out.println(Thread.currentThread() + " myData nums : " + myData.nums);

        VolatileTest myData = new VolatileTest();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                myData.method1();
                myData.method2();
            },String.valueOf(i)).start();

        }



    }

    private int a = 0;

    private boolean flag = false;


    public  void method1(){
        a = 1;
        flag = true;
    }

    public void method2(){
        if(flag){
            a = a + 5;
        }
        System.out.println(a);
    }



}
