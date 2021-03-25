package x.godk.dp.strategy;

/**
 * 简单工厂
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  14:07
 */
public class Factory {


    public static Cash createCash(String cash
    ) {
        switch (cash) {
            case "return":
                return new ReturnCash(100, 10);
            case "discount":
                return new Discount(0.1);
            default:
                return new NormalCash();
        }

    }


}
