/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (n1, n2) -> n1.val - n2.val);
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        for(ListNode n : lists) {
            if(n != null) {
                pq.add(n);
            }
        }
        while(!pq.isEmpty()) {
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;
            if(n.next != null) {
                pq.add(n.next);
            }
        }
        return sentinel.next;
    }
}
