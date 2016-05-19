/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p1 = new ListNode(0);
        ListNode p2 = p1;
        ListNode p3 = new ListNode(0);
        p3.next = head;
        ListNode p4 = p3;
        while(p3.next != null) {
            if(p3.next.val < x) {
                p2.next = p3.next;
                p2 = p2.next;
                p3.next = p3.next.next;
            } else {
                p3 = p3.next;
            }
        }
        p2.next = p4.next;
        return p1.next;
    }
}
