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
        ListNode cur = head;
        ListNode remain = head;
        while(cur.next != null) {
            if(cur.next.val != cur.val) {
                remain.next = cur.next;
                remain = remain.next;
            } 
            cur = cur.next;
        }
        remain.next = null;
        return head;
    }
}
