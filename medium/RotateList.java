/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode p1 = head;
        while(p1.next != null) {
            p1 = p1.next;
            len++;
        }
        if(k % len == 0) {
            return head;
        }
        p1.next = head;
        int move = len - k % len;
        while(move > 0) {
            p1 = p1.next;
            move--;
        }
        head = p1.next;
        p1.next = null;
        return head;
    }
}
