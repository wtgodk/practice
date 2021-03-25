package x.godk.dp.build;

/**
 * 指挥者
 *
 * @author wt
 * @program practice
 * @create 2020-06-09  13:27
 */
public class PersonDirector {


    private PersonBuilder builder;


    public PersonDirector(PersonBuilder pb) {
        this.builder = pb;
    }


    public void createPerson() {
        builder.buildBody();
        builder.buildHead();
        builder.buildLHand();
        builder.buildRHand();
        builder.buildLJio();
        builder.buildRJio();
    }

}
