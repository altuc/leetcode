/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        root.right = sortedListToBST(slow.next.next);
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        return sortedListToBSTHelper(head, null);
    }
    
    public TreeNode sortedListToBSTHelper(ListNode start, ListNode end) {
        if(start == end) {
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBSTHelper(start, slow);
        node.right = sortedListToBSTHelper(slow.next, end);
        return node;
    }
}
