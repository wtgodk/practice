package x.godk.dp.factory.simple;

import lombok.Data;

/**
 * 操作 类
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:50
 */
@Data
public class Operation {

    /**
     * 操作符
     */
    private String operation;

    private int paramA;

    private int paramB;


    public double getResult() {
        return 0;
    }

}
