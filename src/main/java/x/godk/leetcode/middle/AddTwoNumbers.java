package x.godk.leetcode.middle;

import x.godk.leetcode.util.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author wt
 * @program practice
 * @create 2020-07-09  10:11
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode l2 = new ListNode(5);
        ListNode listNode21 = new ListNode(6);
        l2.next = listNode21;
        ListNode listNode22 = new ListNode(4);
        listNode21.next = listNode22;

        ListNode l1 = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        l1.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;

//        ListNode listNode3 = new ListNode(9);
//        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(9);
//        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(9);
//        listNode4.next = listNode5;
//        ListNode listNode6 = new ListNode(9);
//        listNode5.next = listNode6;
//        ListNode listNode7 = new ListNode(9);
//        listNode6.next =listNode7;
//        ListNode listNode8 = new ListNode(9);
//        listNode7.next = listNode8;
//        listNode8.next = new ListNode(9);


        ListNode listNode = solution1(l2, l1);
        System.out.println();
    }

    public static ListNode solution1(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode listNode = null;
        ListNode tmpNode = null;
        boolean value = false;
        while (tmp1 != null || tmp2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (tmp1 != null) {
                val1 = tmp1.val;
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                val2 = tmp2.val;
                tmp2 = tmp2.next;
            }
            int val = val1 + val2;
            if (value) {
                val++;
            }
            if (val >= 10) {
                val = val - 10;
                value = true;
            } else {
                value = false;
            }
            if (tmpNode == null) {
                listNode = new ListNode(val);
                tmpNode = listNode;
            } else {
                tmpNode.next = new ListNode(val);
                tmpNode = tmpNode.next;
            }
        }
        if (value) {
            tmpNode.next = new ListNode(1);
        }

        return listNode;


    }
}


