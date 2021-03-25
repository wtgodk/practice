package x.godk.lock;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wt
 * @program practice
 * @create 2021-03-10  15:02
 */

class  MyDataTest{
    volatile  int i = 0;
   final  AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(i,i);

   public boolean change(){
       boolean b = atomicStampedReference.attemptStamp(i, i);
       return b;
   }

}

public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        int i = 0;
        MyDataTest myDataTest = new MyDataTest();
       // while(true){
            new Thread(()->{

                boolean b =  myDataTest.change();
                System.out.println(Thread.currentThread().getName()+"\t 试图将值 从"+ myDataTest.i+"改成" + (myDataTest.i+1));
                if(b){
                    System.out.println(Thread.currentThread().getName()+"\t 更改成功");
                }
                myDataTest.i++;
            },"AA").start();
            new Thread(()->{},"AA").start();


            new Thread(()->{

                boolean b =  myDataTest.change();

                System.out.println(Thread.currentThread().getName()+"\t 试图将值 从"+ myDataTest.i+"改成" + (myDataTest.i+1));
                if(b){
                    System.out.println(Thread.currentThread().getName()+"\t 更改成功");
                }
                myDataTest.i++;

            },"BB").start();
    //    }


    }
}
