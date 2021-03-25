package x.godk.dp.factory.simple;

/**
 * 运算 工厂
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:57
 */
public class OperationFactory {

    public static Operation createOperation(char operate) {

        switch (operate) {
            case '+':
                return new AddOperation();
            case '-':
                return new SubOperation();
            default:
                return new AddOperation();
        }

    }
}
