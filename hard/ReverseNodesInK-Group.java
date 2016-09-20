/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = head;
        ListNode p1 = sentinel;
        ListNode p2 = head;
        while(true) {
            for(int i = 0; i < k; i++) {
                if(cur == null) {
                    return sentinel.next;
                }
                cur = cur.next;
            }
            int step = k - 1;
            while(step > 0) {
                ListNode tmp = p2.next;
                p2.next = tmp.next;
                tmp.next = p1.next;
                p1.next = tmp;
                step--;
            }
            p1 = p2;
            p2 = p2.next;
        }
    }
}
