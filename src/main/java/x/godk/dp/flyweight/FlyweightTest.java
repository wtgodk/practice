package x.godk.dp.flyweight;

/**
 * @author wt
 * @program practice
 * @create 2020-07-30  10:08
 */
public class FlyweightTest {

    public static void main(String[] args) {
        Flyweight x = FlyweightFactory.getFlyweight("x");
        x.operation("1", "sssss");
        Flyweight y = FlyweightFactory.getFlyweight("y");
        Flyweight z = FlyweightFactory.getFlyweight("z");
        Flyweight x1 = FlyweightFactory.getFlyweight("x");

        y.operation("2", "sssss");
        z.operation("3", "sssss");
        x1.operation("4", "sssss");
    }
}
