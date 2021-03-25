package x.godk.dp.decorator;

import lombok.Data;

/**
 * 装饰者 模式  : person嘞的 装饰者
 * 装饰者视为已有功能动态添加功能的一种方式
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:09
 */
@Data
public class Decorator extends Person {

    private Person person;

    @Override
    void cloths() {
        if (person != null) {
            person.cloths();
        }
    }


}
