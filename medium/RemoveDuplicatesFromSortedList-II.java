/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p1 = sentinel;
        while(p1.next != null) {
            ListNode p2 = p1.next;
            while(p2.next != null && p2.val == p2.next.val) {
                p2 = p2.next;
            }
            if(p2 == p1.next) {
                p1 = p1.next;
            } else {
                p1.next = p2.next;
            }
        }
        return sentinel.next;
    }
}
