/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = null;
        ListNode tmp = null;
        while(head != null) {
            tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
}

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode cur = reverseList(next);
        next.next = head;
        return cur;
    }
}

public class Solution3 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        while(head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = sentinel.next;
            sentinel.next = temp;
        }
        return sentinel.next;
    }
}
