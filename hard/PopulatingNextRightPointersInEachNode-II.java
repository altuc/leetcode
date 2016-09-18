/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null) {
            TreeLinkNode cur = root;
            TreeLinkNode first = null;
            TreeLinkNode temp = null;
            while(cur != null) {
                if(cur.left != null) {
                    if(temp != null && temp != cur.left) {
                        temp.next = cur.left;
                    }
                    if(first == null) {
                        first = cur.left;
                    }
                    if(cur.right != null) {
                        cur.left.next = cur.right;
                        temp = cur.right;
                    } else {
                        temp = cur.left;
                    }
                } else {
                    if(cur.right != null) {
                        if(temp != null && temp != cur.right) {
                            temp.next = cur.right;
                        }
                        if(first == null) {
                            first = cur.right;
                        }
                        temp = cur.right;
                    }
                }
                cur = cur.next;
            }
            root = first;
        }
    }
}
