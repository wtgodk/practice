package x.godk.dp.decorator;


/**
 * 装饰者 测试
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:15
 */
public class TestDecorator {

    public static void main(String[] args) {

        Person person = new Person();

        Hat hat = new Hat();
        Shoes shoes = new Shoes();
        hat.setPerson(person);
        shoes.setPerson(hat);
        shoes.cloths();
    }
}
