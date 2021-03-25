package x.godk.dp.decorator;

/**
 * @author wt
 * @program practice
 * @create 2020-06-04  13:13
 */
public class Hat extends Decorator {


    public void hat() {
        System.out.println("hat");
    }

    @Override
    void cloths() {
        super.cloths();
        hat();
    }


}
