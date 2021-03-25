package x.godk.dp.strategy;

/**
 * 打折 费用计算类
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  14:13
 */
public class Discount extends Cash {

    /**
     * 折扣
     */
    private double discount;

    public Discount(double discount) {
        this.discount = discount;
    }

    @Override
    double result(double money) {
        return money * discount;
    }
}
