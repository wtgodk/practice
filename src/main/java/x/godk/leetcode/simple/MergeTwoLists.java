package x.godk.leetcode.simple;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2021-01-08  13:29
 */
public class MergeTwoLists {

    public static ListNode array2ListNode(int[] arr) {
        ListNode node = null;
        ListNode tmp = null;
        for (int i : arr) {
            if (node == null) {
                node = new ListNode(i);
                tmp = node;
            } else {
                tmp.next = new ListNode(i);
                tmp = tmp.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
//[-10,-9,-6,-4,1,9,9]
//[-5,-3,0,7,8,8]
        ListNode listNode = array2ListNode(new int[]{-10, -9, -6, -4, 1, 9, 9});
        ListNode listNode2 = array2ListNode(new int[]{-5, -3, 0, 7, 8, 8});
//        ListNode listNode = new ListNode(1);
//        listNode.next  = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//
//
//        ListNode listNode2 = new ListNode(1);
//        listNode2.next  = new ListNode(3);
//        listNode2.next.next = new ListNode(3);
//        listNode2.next.next.next = new ListNode(6);
//        listNode2.next.next.next.next = new ListNode(8);
        ListNode listNode1 = solution3(listNode, listNode2);
        System.out.println(listNode1);

    }

    public static x.godk.leetcode.simple.ListNode solution1(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        ListNode l1 = first.val > second.val ? second : first;
        ListNode l2 = first.val <= second.val ? second : first;
        ListNode result = first.val > second.val ? second : first;
        while (l1 != null) {
            while (l2 != null) {
                int l2Val = l2.val;
                if (l1.next == null) {
                    l1.next = l2;
                    return result;
                } else {
                    int nextVal = l1.next.val;
                    if (l2Val >= nextVal) {
                        break;
                    } else {
                        ListNode next = l1.next;
                        l1.next = new ListNode(l2Val, next);
                        l1 = l1.next;
                        l2 = l2.next;
                    }
                }
            }
            l1 = l1.next;
        }

        return result;
    }


    /**
     * 功能描述: <br>
     * 〈〉  创建一个根链表 按顺序 往上添加
     *
     * @param first
     * @param second
     * @return x.godk.leetcode.simple.ListNode
     * @author weitao
     * @date 2021/1/11 9:59
     */
    public static x.godk.leetcode.simple.ListNode solution2(ListNode first, ListNode second) {
        ListNode root = new ListNode(-1);

        ListNode tmp = root;
        while (true) {
            if (first == null) {
                tmp.next = second;
                break;
            } else if (second == null) {
                tmp.next = first;
                break;
            } else if (first.val < second.val) {
                tmp.next = first;
                first = first.next;
            } else {
                tmp.next = second;
                second = second.next;
            }
            tmp = tmp.next;
        }
        return root.next;
    }


    public static ListNode solution3(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        } else if (first.val < second.val) {
            ListNode listNode = solution3(first.next, second);
            first.next = listNode;
            return first;
        } else {
            ListNode listNode = solution3(first, second.next);
            second.next = listNode;
            return second;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}