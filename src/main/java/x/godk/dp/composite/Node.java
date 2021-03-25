package x.godk.dp.composite;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  15:44
 */
public class Node extends AbstractComponent {

    public Node(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        getComponentList().add(component);
    }

    @Override
    public void remove(Component component) {
        getComponentList().remove(component);
    }

    @Override
    public void display() {
        String name = getName();
        System.out.println(name);
        super.display();
    }
}
