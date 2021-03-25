package x.godk.dp.factory.simple;

/**
 * @author wt
 * @program practice
 * @create 2020-06-04  14:00
 */
public class SubOperation extends Operation {


    @Override
    public double getResult() {
        return getParamA() - getParamB();
    }
}
