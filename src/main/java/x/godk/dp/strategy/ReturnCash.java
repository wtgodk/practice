package x.godk.dp.strategy;

/**
 * 返利 活动优惠计算
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  14:15
 */
public class ReturnCash extends Cash {
    /**
     * 满 多少
     */
    private double condition;
    /**
     * 返多少
     */
    private double returnMoney;

    public ReturnCash(double condition, double returnMoney) {
        this.condition = condition;
        this.returnMoney = returnMoney;
    }

    @Override
    double result(double money) {
        if (money >= condition) {
            return money - returnMoney;
        }
        return money;
    }
}
