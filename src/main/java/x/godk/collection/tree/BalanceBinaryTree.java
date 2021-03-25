package x.godk.collection.tree;

/**
 *
 *  平衡二叉树
 * @author wt
 * @program practice
 * @create 2021-03-05  15:04
 */
public class BalanceBinaryTree extends  SearchBinaryTree{



    // 主要就是平衡方法

    public BalanceBinaryTree() {
        super();
    }

    @Override
    public boolean add(int val) {
        if(root ==null){
            // 根节点不存在 直接加入
            root = new Node(val);
            size++;
            return true;
        }
        // 查找插入位置
        Node parentNode = iteration(root, val);
        Node child  = new Node(val);
        if(parentNode.val> val){
//  父节点比他大 左边挂
            parentNode.leftChild = child;
        }else if(parentNode.val < val){
            //父节点比他小 右边挂
            parentNode.rightChild= child;
        }else{
            // TODO 相等
        }
        child.parent = parentNode;
        // 节点数目+1
        size++;

        rebuild(parentNode);
        return true;
    }

    @Override
    public Node iteration(Node root, int val) {
        return super.iteration(root, val);
    }

    @Override
    public Node search(Node root, int val) {
        return super.search(root, val);
    }

    @Override
    public boolean delete(int val){
        Node node = getNode(val);
        if(node == null){
            return false;
        }
        boolean flag = false;
        Node p = null;
        Node parent = node.parent;
        Node leftChild = node.leftChild;
        Node rightChild = node.rightChild;
        //以下所有父节点为空的情况，则表明删除的节点是根节点
        if(leftChild == null && rightChild == null){//没有子节点
            if(parent != null){
                if(parent.leftChild == node){
                    parent.leftChild = null;
                }else if(parent.rightChild == node){
                    parent.rightChild = null;
                }
            }else{//不存在父节点，则表明删除节点为根节点
                root = null;
            }
            p = parent;
            node = null;
            flag =  true;
        }else if(leftChild == null && rightChild != null){// 只有右节点
            if(parent != null && parent.val > val){// 存在父节点，且node位置为父节点的左边
                parent.leftChild = rightChild;
            }else if(parent != null && parent.val < val){// 存在父节点，且node位置为父节点的右边
                parent.rightChild = rightChild;
            }else{
                root = rightChild;
            }
            p = parent;
            node = null;
            flag =  true;
        }else if(leftChild != null && rightChild == null){// 只有左节点
            if(parent != null && parent.val > val){// 存在父节点，且node位置为父节点的左边
                parent.leftChild = leftChild;
            }else if(parent != null && parent.val < val){// 存在父节点，且node位置为父节点的右边
                parent.rightChild = leftChild;
            }else{
                root = leftChild;
            }
            p = parent;
            flag =  true;
        }else if(leftChild != null && rightChild != null){// 两个子节点都存在
            Node successor = getSuccessor(node);// 这种情况，一定存在后继节点
            int temp = successor.val;
            boolean delete = delete(temp);
            if(delete){
                node.val = temp;
            }
            p = successor;
            successor = null;
            flag =  true;
        }
        if(flag){
            rebuild(p);
        }
        return flag;
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public void print(Node node) {
        super.print(node);
    }

    @Override
    public Node getNode(int val) {
        return super.getNode(val);
    }

    /**
     * 功能描述: <br>
     * 〈〉 2      * 在这种情况，因为A和B节点均没有右孩子节点，
     *                                                     a                b
     *                                                    b         调整为 c   a
     *                                                   c  d                   d
     *                                                       a > d > b
     *
     *  3      * 所以不用考虑太多
     * @param node   子节点需要调整
     * @return x.godk.collection.tree.SearchBinaryTree.Node
     * @author weitao
     * @date 2021/3/5 15:05
     */
    public Node rightRotation(Node node){
        if(node!=null){
            Node leftChild = node.leftChild; // 左节点 ，旋转后变为A的父节点
            Node parent = node.parent;  //  顶部节点，旋转后变成 b的右节点    a>b
            Node rightChild = leftChild.rightChild;
            node.leftChild = rightChild;
            // 如果存在d 需要旋转后要放到 a的 左节点  因为 a> d> b
            if(rightChild!=null){
                rightChild.parent =node;
            }
            leftChild.parent =  parent;
            if(parent==null){
                // a是根节点
                root = leftChild;
            }else{
                // a不是父节点 , 判断A在 父节点 左侧还是右侧 将a替换成B
                if(node == parent.leftChild){
                    parent.leftChild = leftChild;
                }else{
                    parent.rightChild = leftChild;
                }

            }
            leftChild.rightChild=  node.parent;
            node.parent = leftChild;
            return  leftChild;
        }
      return null;
    }

    /**
     * 功能描述: <br>
     *                                                     a                a
     *                                                    b         调整为 c
     *                                                     c            b
     *                                                    d               d
     *                                                         b < d < c
     *
     * @param node   b节点
     * @return x.godk.collection.tree.SearchBinaryTree.Node
     * @author weitao
     * @date 2021/3/5 15:17
     */
    public  Node leftRotation(Node node){
        // 此处 可以看到 b是肯定包含父节点的 也就是A
        Node rightChild = node.rightChild; // c节点 要变成 a的 左节点 ， b的父节点
        Node parent = node.parent;
        // c的父节点 他调整成 A
        rightChild.parent = parent;
        node.rightChild = rightChild.leftChild;
        if(rightChild.leftChild!=null){
            rightChild.leftChild.parent = node;
        }
         rightChild.leftChild = node;
        if(parent==null){
            root = rightChild;
        }else{

            if(parent.leftChild == node){
                // b节点在 a节点的节点  将A的左节点替换成 c
                parent.leftChild = rightChild;
            }else if(parent.rightChild == node){
                // b节点在 a节点的 右节点上 将 a的右节点替换成 c
                parent.rightChild = rightChild;
            }
        }

        node.parent = rightChild;
        return rightChild;
    }


    private void rebuild(Node p){
        while(p != null){
            if(calcNodeBalanceValue(p) == 2){// 说明左子树高，需要右旋或者 先左旋后右旋
                fixAfterInsertion(p,0);// 调整操作
            }else if(calcNodeBalanceValue(p) == -2){
                fixAfterInsertion(p,1);
            }
            p = p.parent;
        }
    }
    private int calcNodeBalanceValue(Node node){
        if(node != null){
            return getHeightByNode(node);
        }
        return 0;
    }
    // 计算node节点的高度
    public int getChildDepth(Node node){
        if(node == null){
            return 0;
        }
        return 1+Math.max(getChildDepth(node.leftChild),getChildDepth(node.rightChild));
    }
    public int getHeightByNode(Node node){
        if(node == null){
            return 0;
        }
        return getChildDepth(node.leftChild)-getChildDepth(node.rightChild);
    }
    /**
     * 调整树结构
     * @param p
     * @param type
     */
    private void fixAfterInsertion(Node p, int type) {
        if (type == 0) {//需要右旋或者 先左旋后右旋
            final Node leftChild = p.leftChild;
            if (leftChild.rightChild != null) {// 先左旋后右旋
                leftRotation(leftChild);
                rightRotation(p);
            } else if (leftChild.leftChild != null) {//右旋
                rightRotation(p);
            }

        } else {
            final Node rightChild = p.rightChild;
            if (rightChild.leftChild != null) {// 先右旋，后左旋
                rightRotation(p);
                leftRotation(rightChild);
            } else if (rightChild.rightChild != null) {// 左旋
                leftRotation(p);
            }
        }
    }
}
