package x.godk.dp.strategy;


/**
 * @author wt
 * @program practice
 * @create 2020-06-04  14:19
 */
public class View {


    public static void main(String[] args) {
// 简单工厂实现
//        Cash normal = Factory.createCash("discount");
//        double result = normal.result(100);
        // 策略 + 简单工厂实现
        CashContext context = new CashContext("discount");
        double result = context.result(100);
        System.out.println(result);
    }
}
