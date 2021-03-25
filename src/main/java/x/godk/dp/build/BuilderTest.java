package x.godk.dp.build;

/**
 * 建造者模式测试
 * 创建复杂对象的算法应该独立与该对象的组成部分以及他们的装配方式 适用的模式
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  13:30
 */
public class BuilderTest {


    public static void main(String[] args) {

        PersonDirector personDirector = new PersonDirector(new ThinPersonBuilder());

        personDirector.createPerson();


    }
}
