package x.godk.dp.composite;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  15:46
 */
public class ComponentTest {

    public static void main(String[] args) {

        Component root = new Node("根节点");


        Component second = new Node("二级-1");
        Component second2 = new Node("二级-2");
        root.add(second);
        root.add(second2);

        Component third1 = new Node("三级-1");
        Component third2 = new Node("三级-2");
        second.add(third1);
        second.add(third2);
        root.display();
    }
}
