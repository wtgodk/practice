package x.godk;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */

class MyData{

    final String flag = "a";
    final String flag2 = "b";

    public void test() throws InterruptedException {
            synchronized (flag){

                test2();
            }
    }

    public void test2() throws InterruptedException {
        synchronized (flag2){
            Thread.sleep(Long.parseLong("1000"));
            test2();
           System.out.println("执行完毕");
        }
    }

}
public class AppTest {
    public static void main(String[] args) {
      MyData myData = new MyData();

        new Thread(()->{
            try {
                myData.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                myData.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();



        int[] a = {1, 1, 2, 2, 2, 3, 4, 5};
//        int[] b = {2,5, 6};
      demo2(a);
//        System.out.println(Arrays.toString(ints));
    }

    public static int[] demo1(int[] a ,int[] b){

        int aLen = a.length-1;
        int bLen = b.length -1;

        int total = aLen + bLen + 2;
        int[] result = new int[total ];
        int index = total -1;
        while(aLen >= 0 && bLen >=0){
            if(a[aLen] >= b[bLen]){
                result[index--]  = a[aLen];
                aLen--;
            }else if(a[aLen] < b[bLen]){
                result[index--]  = b[bLen];
                bLen--;
            }
        }

        while(aLen>=0 && index>=0){
            result[index--] = a[aLen];
        }
        while(bLen>=0 && index>=0){
            result[index--] = b[bLen];
        }
        return result;
    }


    public static void demo2(int[] arr){
        /**
         * 功能描述: <br>
         * 〈〉2．输入：数组 [1, 1, 2, 2, 2, 3, 4, 5]，有序数组，有重复值，
         * 请写一段代码将该数组内容变为 [1, 2, 3, 4, 5, x,x,x] （对x的值不做要求），
         * 并返回前面无重复序列的长度 5
         * 要求：原数组操作（不能创建新数组），一次遍历完成。
         * @param
         * @return void
         * @author weitao
         * @date 2021/3/16 10:41
         */

        int tmp = 0;
      for(int i=0 ;i< arr.length;i++){
          int val = arr[i] ;
          if(val == arr[tmp]){

          }else{
              arr[++tmp] = val;

          }
      }
      System.out.println(arr);

    }

}
