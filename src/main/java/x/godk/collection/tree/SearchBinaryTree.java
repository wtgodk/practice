package x.godk.collection.tree;

/**
 * @author wt
 * @program practice
 * @create 2021-03-05  11:42
 */
public class SearchBinaryTree {

    /**
     *  根节点
     */
     Node root;

    /**
     *  节点个数
     */
     int size;




    public SearchBinaryTree() {
        super();
    }
/**
 * 功能描述: <br>
 * 〈〉  插入方法
 * @param val
 * @return boolean
 * @author weitao
 * @date 2021/3/5 11:44
 */
    public boolean add(int val){

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
        return true;
    }

    public  Node iteration(Node root,int val){
        Node tmp =root;
        Node parent =root;
        int value ;
        while(tmp!=null){
            parent = tmp;
            value = tmp.val -val;
            if(value >0 ){
                tmp = tmp.leftChild;
            }else if(value<0){
                tmp = tmp.rightChild;
            }else{
                // 不考虑相等的情况
            }
        }
        return parent;
    }

/**
 * 功能描述: <br>
 23      * 获取要插入的节点的父节点，该父节点满足以下几种状态之一
 24      *  1、父节点为子节点
 25      *  2、插入节点值比父节点小，但父节点没有左子节点
 26      *  3、插入节点值比父节点大，但父节点没有右子节点
 27      *  4、插入节点值和父节点相等。
 28      *  5、父节点为空
 29      *  如果满足以上5种情况之一，则递归停止。
 * @param root
 * @param val
 * @return x.godk.collection.tree.SearchBinaryTree.Node
 * @author weitao
 * @date 2021/3/5 11:48
 */
    public  Node search(Node root,int val){
        if(root ==null){
            return root;
        }
        if(root.leftChild ==null && root.rightChild ==null){
            return root;
        }
        if(root.val > val && root.leftChild ==null){
            // 挂到左节点上
            return root;
        }
        if(root.val< val && root.rightChild ==null){
            // 插入到有节点上
            return root;
        }
        if(root.val == val ){
            return root;
        }

        if(root.val > val && root.leftChild!=null){
            return search(root.leftChild,val);
        }else if(root.val < val && root.rightChild !=null){
            return search(root.rightChild,val);
        }else{
            return root;
        }
    }




/**
 * 功能描述: <br>

 1、要删除的节点没有左右子节点，如上图的D、E、G节点

 2、要删除的节点只有左子节点，如B节点

 3、要删除的节点只有右子节点，如F节点

 4、要删除的节点既有左子节点，又有右子节点，如 A、C节点

 * @return
 * @author weitao
 * @date 2021/3/5 13:29
 */

public boolean delete(int val){
    // 1 遍历查找 val
    Node tmp = getNode(val);
    // 此时找到val
    if( tmp ==null){
        // 没有找到
        return false;
    }else{
        Node parent =   tmp.parent;
     //   1、要删除的节点没有左右子节点
        if( tmp.leftChild ==null && tmp.rightChild==null){
            if(parent==null){
                root =null;
                size--;
                return true;
            }
          if(parent.val > tmp.val){
              parent.leftChild  = null;
          }else{
              parent.rightChild = null;
          }
        }else if(tmp.leftChild ==null || tmp.rightChild==null){

            Node child;
            // 要删除的节点只有左节点 或右节点
            if(tmp.leftChild!=null){
                child = tmp.leftChild;
            }else{
                child = tmp.rightChild;
            }
            if(parent==null){
                root = child;
                child.parent =null;
            }else{
                if(parent.val > tmp.val){
                    parent.leftChild  = child;
                }else{
                    parent.rightChild = child;
                }
                child.parent = parent;
            }
        }else{
            Node successor = getSuccessor(tmp);
            //要删除的节点既有左子节点，又有右子节点，如 A、C节点
            // 由于此处肯定有左右节点，所以拿出来的是 tmp的右节点的左节点的左节点 一直到最有一个左节点
            int val1 = successor.val;
            boolean delete = delete(val1);
            if(delete){
                //删除成功，将 要删除的节点值改成 刚刚查询出的值
                tmp.val = val1;
            }
            // 应该是垃圾回收吧
            successor =null;

        }
        size--;
        return true;
    }



}

    public void print(){
    // 中序遍历  从小到大
        print(root);

    }
    public void print(Node node){
        if(node==null){
            return;
        }
        print(node.leftChild);
        System.out.println(node.val);
        print(node.rightChild);
    }
    public Node getNode(int val){
        Node tmp = root;
        while(tmp!=null && tmp.val !=val){
            if(tmp.val > val){
                // 往左侧找
                tmp = tmp.leftChild;
            }else {
                tmp = tmp.rightChild;
            }
        }
        return tmp;
    }

/**
 * 功能描述: <br>
 5      * 找到node节点的后继节点
 56      * 1、先判断该节点有没有右子树，如果有，则从右节点的左子树中寻找后继节点，没有则进行下一步
 57      * 2、查找该节点的父节点，若该父节点的右节点等于该节点，则继续寻找父节点，
 58      *   直至父节点为Null或找到不等于该节点的右节点。
 59      * 理由，后继节点一定比该节点大，若存在右子树，则后继节点一定存在右子树中，这是第一步的理由
 60      *      若不存在右子树，则也可能存在该节点的某个祖父节点(即该节点的父节点，或更上层父节点)的右子树中，
 61      *      对其迭代查找，若有，则返回该节点，没有则返回null
 * @param node
 * @return x.godk.collection.tree.SearchBinaryTree.Node
 * @author weitao
 * @date 2021/3/5 14:14
 */
    public Node getSuccessor(Node node){
    // 找到后续子节点
        if(node.rightChild!=null){
            Node left = node.rightChild;
            while(left.leftChild!=null){
                left = left.leftChild;
            }
            return left;
        }
        Node parentNode = node.parent;
        while(parentNode!=null && node == parentNode.rightChild){
            node =parentNode;
            parentNode = parentNode.parent;
        }
        return parentNode;

    }



   static class Node {
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
         *  节点值
         */
        int val;

        public Node(Node parent, Node leftChild, Node rightChild, int val) {
            super();
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.val = val;
        }

        public Node(int val){
            this(null,null,null,val);
        }

        public Node(Node node, int val){
            this(node,null,null,val);
        }
    }
    
    
    
    
}
