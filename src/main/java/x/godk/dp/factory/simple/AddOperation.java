package x.godk.dp.factory.simple;

/**
 * @author wt
 * @program practice
 * @create 2020-06-04  13:59
 */
public class AddOperation extends Operation {


    @Override
    public double getResult() {

        return getParamA() + getParamB();
    }
}
