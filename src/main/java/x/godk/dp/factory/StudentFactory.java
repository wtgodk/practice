package x.godk.dp.factory;

/**
 * @author wt
 * @program practice
 * @create 2020-06-04  15:25
 */
public class StudentFactory extends Factory {


    @Override
    public Student create() {
        return new UnderGraduate();
    }
}
