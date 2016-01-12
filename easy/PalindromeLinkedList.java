/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode left = null;
        ListNode right = null;
        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        int move = len/2;
        while(move > 0) {
            right = head.next;
            head.next = left;
            left = head;
            head = right;
            move--;
        }
        if(len % 2 != 0) {
            right = right.next;
        }
        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
