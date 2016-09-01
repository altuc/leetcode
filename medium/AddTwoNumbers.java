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
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while(l1 != null || l2 != null) {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return sentinel.next;
    }
}

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1 == null) {
           return l2;
       }
       if(l2 == null) {
           return l1;
       }
       ListNode sentinel = new ListNode(0);
       ListNode current = sentinel;
       int sum = 0;
       while(l1 != null || l2 != null) {
           if(l1 != null) {
               sum += l1.val;
               l1 = l1.next;
           }
           if(l2 != null) {
               sum += l2.val;
               l2 = l2.next;
           }
           current.next = new ListNode(sum % 10);
           current = current.next;
           sum /= 10;
           if(sum == 1) {
               current.next = new ListNode(1);
           }
       }
       return sentinel.next;
    }
}
