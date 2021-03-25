package x.godk.dp.factory.simple;

/**
 * 简单工厂测试类
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  14:01
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        Operation operation = OperationFactory.createOperation('+');

        operation.setParamA(1);
        operation.setParamB(2);
        double result = operation.getResult();
        System.out.println(result);


    }
}
