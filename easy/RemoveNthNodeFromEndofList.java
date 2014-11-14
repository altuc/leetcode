/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode fp = sentinel;
        ListNode lp = sentinel;
        int step = 0;
        while(step < n) {
            fp = fp.next;
            step++;
        }
        while(fp.next != null) {
            fp = fp.next;
            lp = lp.next;
        }
        lp.next = lp.next.next;
        return sentinel.next;
    }
}