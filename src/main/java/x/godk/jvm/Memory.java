package x.godk.jvm;

/**
 * @author wt
 * @program practice
 * @create 2020-08-17  17:12
 */
public class Memory {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        long l = runtime.freeMemory();
        long l1 = runtime.maxMemory();

    }
}
