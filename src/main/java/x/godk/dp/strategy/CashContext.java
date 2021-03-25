package x.godk.dp.strategy;

/**
 * 策略模式 只给 调用方提供一个 CashContext 类 将内部实现 隐藏到 CashContext中。
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  15:08
 */
public class CashContext {


    private Cash cash;

    public CashContext(String type) {
        cash = Factory.createCash(type);
    }


    public double result(double money) {
        return cash.result(money);
    }
}
