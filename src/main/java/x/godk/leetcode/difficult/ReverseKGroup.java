package x.godk.leetcode.difficult;

import x.godk.leetcode.util.LinkListUtil;
import x.godk.leetcode.util.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2021-02-24  14:09
 */
public class ReverseKGroup {


    public static void main(String[] args) {

        ListNode convert = reverse(LinkListUtil.array2ListNode(new int[]{1, 2, 3, 4}));
    //    ListNode convert = solution1(LinkListUtil.array2ListNode(new int[]{1, 2, 3, 4}), 3);
        System.out.println(convert);
    }


    public static ListNode solution1(ListNode listNode, int k) {

        // 快慢指针

        int low = 0;
        int fast = low;

        ListNode first = new ListNode();
        ListNode last = first;
        ListNode tmpNode = new ListNode();
        ListNode tmpNode2 = tmpNode;
        while (listNode != null) {
            tmpNode2.next = listNode;
            tmpNode2 = tmpNode2.next;
            listNode = listNode.next;
            if (fast - low == k - 1) {
                // 链表反转
                tmpNode2.next = null;
                last.next = convert(tmpNode.next);
                last = tmpNode.next;
                tmpNode = new ListNode();
                tmpNode2 = tmpNode;
                fast = low;
            } else {
                fast++;
            }
        }
        if (tmpNode.next != null) {
            last.next = tmpNode.next;
        }


        return first.next;

    }


    public static ListNode convert(ListNode head) {
        ListNode first = new ListNode();
        first.next = head;

        while (head != null && head.next != null) {
            ListNode node1 = head.next;
            head.next = node1.next;
            node1.next = head;
            ListNode firstNext = first.next;
            first.next = node1;
            node1.next = firstNext;
        }

        return first.next;
    }
    /**
     * 翻转链表
     * @param head
     */
    public static ListNode reverse(ListNode head){
        ListNode pre=head;
        ListNode next=head.next;
          pre.next = null;

        while (next!=null){
            ListNode tmp=next.next;
            next.next=pre;
            pre=next;
            next=tmp;
        }
        return pre;
    }

    /**
     * 功能描述: <br>
     * 〈〉因此，在翻转子链表的时候，我们不仅需要子链表头节点 head，还需要有 head 的上一个节点 pre，以便翻转完后把子链表再接回 pre。
     *
     * 但是对于第一个子链表，它的头节点 head 前面是没有节点 pre 的。太麻烦了！难道只能特判了吗？答案是否定的。没有条件，我们就创造条件；没有节点，我们就创建一个节点。
     * 我们新建一个节点，把它接到链表的头部，让它作为 pre 的初始值，这样 head 前面就有了一个节点，我们就可以避开链表头部的边界条件。这么做还有一个好处，下面我们会看到。
     *
     * 反复移动指针 head 与 pre，对 head 所指向的子链表进行翻转，直到结尾，我们就得到了答案。下面我们该返回函数值了。
     *
     * 有的同学可能发现这又是一件麻烦事：链表翻转之后，链表的头节点发生了变化，那么应该返回哪个节点呢？照理来说，前 k 个节点翻转之后，链表的头节点应该是第 k 个节点。
     * 那么要在遍历过程中记录第 k 个节点吗？但是如果链表里面没有 k 个节点，答案又还是原来的头节点。我们又多了一大堆循环和判断要写，太崩溃了！
     *
     * 等等！还记得我们创建了节点 pre 吗？这个节点一开始被连接到了头节点的前面，而无论之后链表有没有翻转，它的 next 指针都会指向正确的头节点。
     * 那么我们只要返回它的下一个节点就好了。至此，问题解决。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/k-ge-yi-zu-fan-zhuan-lian-biao-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param listNode
     * @param k
     * @return x.godk.leetcode.util.ListNode
     * @author weitao
     * @date 2021/2/24 14:55
     */
    public static ListNode solution2(ListNode listNode , int k ){


        return null;
    }

}
