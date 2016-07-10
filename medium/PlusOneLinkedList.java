/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(1);
        sentinel.next = head;
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            cur = cur.next;
            len++;
        }
        while(len > 0) {
            ListNode pt = head;
            int move = 1;
            while(move < len) {
                pt = pt.next;
                move++;
            }
            if(pt.val + 1 > 9) {
                pt.val = 0;
            } else {
                pt.val += 1;
                return sentinel.next;
            }
            len--;
        }
        return sentinel;
    }
}
