package x.godk.leetcode.middle;

import x.godk.leetcode.util.LinkListUtil;
import x.godk.leetcode.util.ListNode;

/**
 *
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *  
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-02-23  15:53
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode listNode1 = LinkListUtil.array2ListNode(new int[]{1,2,3,4});
        ListNode listNode = new ListNode();
        listNode.next = listNode1;
        ListNode solution = solution3(listNode1);
        System.out.println(solution);

    }


    public static ListNode solution(ListNode head){
        if(head ==null || head.next==null){
            return head;
        }
        ListNode pre = new ListNode();
        pre.next =  head;
        ListNode tmp = pre;
        while(true){
            if(tmp.next ==null || tmp.next.next==null){
                break;
            }
            //0
            ListNode node1 = tmp.next;
            //1
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp=  node1;

        }
        return pre.next;

    }

    /**
     * 功能描述: <br>
     * 〈〉  递归解决
     * @param head
     * @return x.godk.leetcode.util.ListNode
     * @author weitao
     * @date 2021/2/23 16:53
     */
    public static ListNode solution2(ListNode head,ListNode first){
        if(head.next ==null || head.next.next ==null){
            return first.next;
        }

        ListNode one = head.next;
        ListNode two = head.next.next;
        head.next =  two;

        one.next = two.next;
        two.next = one;
        head  = one;
        return solution2(head,first);
    }

    public static ListNode solution3(ListNode head){
        if(head ==null || head.next ==null){
            return head;
        }
        //1 head

        //2
        ListNode one = head.next;

        ListNode listNode = solution3(one.next);
        head.next = listNode;
        one.next = head;

        return one;

    }

}
