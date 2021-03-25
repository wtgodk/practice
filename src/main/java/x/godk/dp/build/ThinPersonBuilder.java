package x.godk.dp.build;

/**
 * @author wt
 * @program practice
 * @create 2020-06-09  13:30
 */
public class ThinPersonBuilder extends PersonBuilder {


    @Override
    public void buildHead() {
        System.out.println("head");
    }

    @Override
    public void buildBody() {
        System.out.println("body ");
    }

    @Override
    public void buildLHand() {
        System.out.println("left hand ");
    }

    @Override
    public void buildRHand() {
        System.out.println("right hand ");
    }

    @Override
    public void buildRJio() {
        System.out.println("right leg ");
    }

    @Override
    public void buildLJio() {
        System.out.println("left leg ");
    }
}
