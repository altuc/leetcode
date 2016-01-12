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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        ListNode sentinel = a;
        while(a != null && b != null) {
            if(a.next == null && b.next != null) {
                if(a.val != b.val) {
                    sentinel = headB;
                }
                a = headB;
                b = b.next;
            } else if(a.next != null && b.next == null) {
                if(a.val != b.val) {
                    sentinel = a.next;
                }
                a = a.next;
                b = headA;
            } else {
                if(a.val != b.val) {
                    sentinel = a.next;
                }
                a = a.next;
                b = b.next;
            }
        }
        return sentinel;
    }
}

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(a != null || b != null) {
            if(a != null) {
                a = a.next;
                lengthA++;
            }
            if(b != null) { 
                b = b.next;
                lengthB++;
            }
        }
        int diff = Math.abs(lengthA - lengthB);
        while(diff > 0) {
            if(lengthA > lengthB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
            diff--;
        }
        while(headA != null) {
            if(headA.val == headB.val) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return headA;
    }
}
