package x.godk.dp.decorator;

/**
 * 装饰 1
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:12
 */
public class Shoes extends Decorator {


    public void shoes() {
        System.out.println("shoes");
    }


    @Override
    void cloths() {
        super.cloths();
        shoes();
    }
}
