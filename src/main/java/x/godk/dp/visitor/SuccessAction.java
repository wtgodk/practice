package x.godk.dp.visitor;

/**
 * @author wt
 * @program practice
 * @create 2020-08-04  09:21
 */
public class SuccessAction implements Action {

    @Override
    public void manAction(PersonMan personMan) {
        System.out.println("男人成功：" + personMan.toString());
    }

    @Override
    public void womanAction(PersonWoman personWoman) {
        System.out.println("女人成功：" + personWoman.toString());
    }
}
