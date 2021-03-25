package x.godk.dp.visitor;

/**
 * 访问者模式
 *
 * @author wt
 * @program practice
 * @create 2020-08-04  09:13
 */
public class VisitorTest {


    public static void main(String[] args) {

        PersonWoman personWoman = new PersonWoman();

        PersonMan personMan = new PersonMan();

        Visitor visitor = new Visitor();
        visitor.add(personMan);
        visitor.add(personWoman);


        visitor.display(new SuccessAction());


    }
}
