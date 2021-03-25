package x.godk.dp.prototype;

import lombok.Data;

/**
 * 原型模式
 *
 * @author wt
 * @program practice
 * @create 2020-06-05  14:57
 */
@Data
public class Prototype implements Cloneable {

    private String name;
    private String sex;


    public Prototype(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    /**
     * jdk clone方法为浅clone 对于对象引用clone的是引用。
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
