package x.godk.leetcode.difficult;

import x.godk.leetcode.util.LinkListUtil;
import x.godk.leetcode.util.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2021-02-22  13:50
 */
public class MergeKLists {


    public static void main(String[] args) {


       ListNode listNode1 = LinkListUtil.array2ListNode(new int[]{1,4,5});
       ListNode listNode2 = LinkListUtil.array2ListNode(new int[]{1,3,4});
       ListNode listNode3 =LinkListUtil. array2ListNode(new int[]{2,6});

       ListNode[] arr = new ListNode[]{listNode1,listNode2,listNode3};
        ListNode solution = solution2(arr);
        System.out.println(solution);
    }

    public static ListNode solution(ListNode[] lists)
    {
        if(lists.length==1){
            return lists[0];
        }
        ListNode ans = null;
        for (ListNode list : lists) {
            ans=   mergeTwoList(ans ,list);
        }
        return ans;
    }

    // 两个链表合并

    public static ListNode mergeTwoList(ListNode a , ListNode b){
        if(a ==null ||  b == null){
            return a ==null? b : a;
        }
        ListNode tmpPre = new ListNode();
        ListNode tail = tmpPre;
        ListNode aPtr = a;
        ListNode bPtr = b;
        while(aPtr !=null && bPtr!=null){
            if(aPtr.val < bPtr.val){
                //A的小
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;

            }
            tail =  tail.next;
        }
        tail.next = aPtr==null ? bPtr : aPtr;

        return tmpPre.next;
    }


    public static ListNode solution2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }























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
