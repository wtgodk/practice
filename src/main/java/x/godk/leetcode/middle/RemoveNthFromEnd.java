package x.godk.leetcode.middle;

import x.godk.leetcode.util.ListNode;

import java.util.*;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2021-01-07  10:05
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(listNode);
        ListNode solution = solution4(listNode, 5);
        System.out.println(solution);

    }

    public static ListNode solution(ListNode head, int n) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(head.val);
        ListNode next = head.next;
        while (next != null) {
            queue.add(next.val);
            next = next.next;
        }
        ListNode newLink = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == n) {
                queue.poll();
                continue;
            }
            if (newLink == null) {
                newLink = new ListNode(queue.poll());
                next = newLink;
            } else {
                ListNode tmp = new ListNode(queue.poll());
                next.next = tmp;
                next = tmp;
            }

        }
        return newLink;

    }


    public static ListNode solution2(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode next = head.next;
        if (next == null) {
            return null;
        }
        while (next != null) {
            list.add(next);
            next = next.next;
        }
        if (n == list.size()) {
            return list.get(1);
        }
        int index = list.size() - n - 1;
        ListNode listNode = list.get(index);
        listNode.next = listNode.next.next;
        return head;
    }


    public static ListNode solution3(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();
        stack.add(head);
        ListNode next = head.next;
        while (next != null) {
            stack.add(next);
            next = next.next;
        }
        int size = stack.size();
        if (size == n) {
            return head.next;
        }
        while (true) {
            ListNode pop = stack.pop();
            if (stack.size() == size - n) {
                ListNode pop1 = stack.pop();
                pop1.next = pop.next;
                break;
            }
        }

        return head;

    }

    //TODO  快慢指针 一次遍历解决

    /**
     * 功能描述: <br>
     * <p>
     * 〈〉    1->2->3->4->5
     * <p>
     * n=1
     * <p>
     * slow  = 3
     * fast = 4
     * <p>
     * n=2
     * <p>
     * slow = 2
     * fast = 4
     * <p>
     * n = fast - slow
     * 当fast 到最后那么 slow指针位置刚刚好他的 next即为要删除的
     *
     * @param head
     * @param n
     * @return x.godk.leetcode.middle.ListNode
     * @author weitao
     * @date 2021/1/7 13:19
     */
    public static ListNode solution4(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //间隔
        int step = 0;
        while (fast.next != null) {
            if (step < n) {
                fast = fast.next;
                step++;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        if (step < n) {
            return head.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

