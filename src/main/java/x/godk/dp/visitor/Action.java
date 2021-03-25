package x.godk.dp.visitor;

/**
 * 动作
 *
 * @author wt
 * @program practice
 * @create 2020-08-04  09:15
 */
public interface Action {

    /**
     * 男人动作
     */
    public void manAction(PersonMan personMan);

    /**
     * 女人动作
     */
    public void womanAction(PersonWoman personWoman);

}
