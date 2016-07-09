/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p1 = sentinel;
        ListNode p2 = head;
        while(p2 != null && p2.next != null) {
            ListNode temp = p2.next.next;
            p2.next.next = p1.next;
            p1.next = p2.next;
            p2.next = temp;
            p1 = p2;
            p2 = p1.next;
        }
        return sentinel.next;
    }
}

public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
            pre = cur;
            cur = cur.next;
        }
        return sentinel.next;
    }
}
