package x.godk.collection.tree;

/**
 * @author wt
 * @program practice
 * @create 2021-03-05  13:17
 */
public class TreeTest {

    public static void main(String[] args) {

        SearchBinaryTree searchBinaryTree = new BalanceBinaryTree();
        searchBinaryTree.add(1);
        searchBinaryTree.add(3);
        searchBinaryTree.add(4);
        searchBinaryTree.add(2);
        searchBinaryTree.add(7);
        searchBinaryTree.add(9);
        searchBinaryTree.add(5);
        searchBinaryTree.add(13);
        searchBinaryTree.add(8);
        System.out.println(searchBinaryTree);


        SearchBinaryTree.Node node = searchBinaryTree.getNode(1);
        SearchBinaryTree.Node node1 = searchBinaryTree.getNode(2);
        SearchBinaryTree.Node node2 = searchBinaryTree.getNode(3);
        SearchBinaryTree.Node node3 = searchBinaryTree.getNode(4);
        SearchBinaryTree.Node node4 = searchBinaryTree.getNode(5);

        searchBinaryTree.print();
        boolean deleteAll = searchBinaryTree.delete(1);
        boolean delete2 = searchBinaryTree.delete(7);
        boolean delete1 = searchBinaryTree.delete(9);

        boolean delete3 = searchBinaryTree.delete(5);
        boolean delete4 = searchBinaryTree.delete(2);
        boolean delete = searchBinaryTree.delete(10);
        boolean delete5 = searchBinaryTree.delete(3);



    }
}
