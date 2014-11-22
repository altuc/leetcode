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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int sum = 0;
        int carry = 0;
        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            sum = 0;
        }
        if(carry == 1) {
            current.next = new ListNode(1);
        }
        return sentinel.next;
    }
}