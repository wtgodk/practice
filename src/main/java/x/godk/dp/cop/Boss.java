package x.godk.dp.cop;

/**
 * @author wt
 * @program practice
 * @create 2020-07-29  15:38
 */
public class Boss extends Manager {
    public Boss(String name) {
        super(name);
    }

    @Override
    public void execute(int request) {
        if (request < 20) {
            System.out.println(getName() + "：OK");
        } else {
            System.out.println("驳回");
        }


    }
}
