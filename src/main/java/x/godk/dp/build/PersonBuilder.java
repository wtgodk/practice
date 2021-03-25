package x.godk.dp.build;

/**
 * 建造者模式 ， 造小人
 * <p>
 * 列出必须的方法，子类必须实现 完成创建
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  13:24
 */
public abstract class PersonBuilder {


    public abstract void buildHead();

    public abstract void buildBody();

    public abstract void buildLHand();

    public abstract void buildRHand();

    public abstract void buildRJio();

    public abstract void buildLJio();


}
