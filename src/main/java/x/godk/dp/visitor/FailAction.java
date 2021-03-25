package x.godk.dp.visitor;

/**
 * @author wt
 * @program practice
 * @create 2020-08-04  09:25
 */
public class FailAction implements Action {
    @Override
    public void manAction(PersonMan personMan) {
        System.out.println("男人失败：" + personMan);

    }

    @Override
    public void womanAction(PersonWoman personWoman) {
        System.out.println("女人失败：" + personWoman);
    }
}
