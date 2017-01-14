/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> sta1 = new ArrayDeque<Integer>();
        Deque<Integer> sta2 = new ArrayDeque<Integer>();
        while(l1 != null) {
            sta1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            sta2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int sum = 0;
        while(!sta1.isEmpty() || !sta2.isEmpty()) {
            if(!sta1.isEmpty()) {
                sum += sta1.pop();
            }
            if(!sta2.isEmpty()) {
                sum += sta2.pop();
            }
            ListNode n = new ListNode(sum % 10);
            n.next = res;
            res = n;
            sum /= 10;
        }
        if(sum == 1) {
            ListNode n = new ListNode(1);
            n.next = res;
            res = n;
        }
        return res;
    }
}
