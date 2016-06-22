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

public class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        int carry = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                int val = l1.val + l2.val + carry;
                carry = val >= 10 ? 1 : 0;
                cur.next = new ListNode(val % 10);
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null) {
                int val = l1.val + carry;
                carry = val >= 10 ? 1 : 0;
                cur.next = new ListNode(val % 10);
                l1 = l1.next;
            } else {
                int val = l2.val + carry;
                carry = val >= 10 ? 1 : 0;
                cur.next = new ListNode(val % 10);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return sentinel.next;
    }
}
