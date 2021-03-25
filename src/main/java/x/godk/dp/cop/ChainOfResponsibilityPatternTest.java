package x.godk.dp.cop;

/**
 * 职责链模式
 *
 * @author wt
 * @program practice
 * @create 2020-07-29  15:33
 */
public class ChainOfResponsibilityPatternTest {


    public static void main(String[] args) {
        Manager manager = new CommonManager("经理");
        manager.setSuperior(new Boss("BOSS"));
        manager.execute(1);
        manager.execute(15);
        manager.execute(34);

    }


}
