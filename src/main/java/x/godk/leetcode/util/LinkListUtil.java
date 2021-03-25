package x.godk.leetcode.util;


/**
 * @author wt
 * @program practice
 * @create 2021-02-23  16:07
 */
public class LinkListUtil {
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

}
