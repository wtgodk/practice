package x.godk.dp.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享源工厂
 *
 * @author wt
 * @program practice
 * @create 2020-07-30  10:08
 */
public class FlyweightFactory {


    private static Map<String, Flyweight> flyweightList = new HashMap<>();

    public static Flyweight getFlyweight(String key) {
        return flyweightList.computeIfAbsent(key, x -> new ConcreteFlyweight());
    }
}
