package x.godk.dp.strategy;

/**
 * 无折扣 普通收费计算
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  14:12
 */
public class NormalCash extends Cash {
    @Override
    double result(double money) {
        return money;
    }
}
