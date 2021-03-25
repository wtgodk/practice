package x.godk.collection.tree;

/**
 *
 *  树的节点
 * @author wt
 * @program practice
 * @create 2021-03-05  11:36
 */
public class Node {
    /**
     *  父节点
     */
    Node parent;
    /**
     *  左节点
     */
    Node leftChild;

    /**
     *  右节点
     */
    Node rightChild;
    /**
     *  深度把
     */
    int val;

    public Node(Node parent, Node leftChild, Node rightChild,int val) {
        super();
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.val = val;
    }

    public Node(int val){
        this(null,null,null,val);
    }

    public Node(Node node,int val){
        this(node,null,null,val);
    }
}
