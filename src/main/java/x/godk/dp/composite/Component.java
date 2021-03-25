package x.godk.dp.composite;

/**
 * 组合模式
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  15:41
 */
public interface Component {


    void add(Component component);


    void remove(Component component);


    void display();


    String getName();
}
