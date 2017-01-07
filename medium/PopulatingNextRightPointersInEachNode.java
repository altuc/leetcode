/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        while(root.left != null) {
            TreeLinkNode cur = root;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            root = root.left;
        }
    }
}

public class Solution2 {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
