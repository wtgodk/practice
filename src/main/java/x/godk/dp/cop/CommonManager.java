package x.godk.dp.cop;

/**
 * 经理
 *
 * @author wt
 * @program practice
 * @create 2020-07-29  15:36
 */
public class CommonManager extends Manager {

    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void execute(int request) {
        if (request < 10) {
            //经理十天一下 假期 可以 审批
            System.out.println(getName() + "：OK");
        } else if (getSuperior() != null) {
            //交给 上级处理
            getSuperior().execute(request);
        }

    }
}
