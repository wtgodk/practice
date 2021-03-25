package x.godk.dp.factory;

/**
 * 工厂模式  区别于 简单工厂
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  15:23
 */
public abstract class Factory {

    /**
     * 工厂创建 学生
     *
     * @return
     */
    public abstract Student create();

}
