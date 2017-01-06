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
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> sta = new ArrayDeque<TreeNode>();
        sta.push(root);
        TreeNode cur = null;
        while(!sta.isEmpty()) {
            TreeNode n = sta.pop();
            if(n.right != null) {
                sta.push(n.right);
            }
            if(n.left != null) {
                sta.push(n.left);
            }
            if(cur != null) {
                cur.left = null;
                cur.right = n;
            }
            cur = n;
        }
    }
}

public class Solution2 {
    public void flatten(TreeNode root) {
        Deque<TreeNode> sta = new ArrayDeque<TreeNode>();
        TreeNode pre = null;
        while(!sta.isEmpty() || root != null) {
            if(root != null) {
                if(root.left != null) {
                    if(root.right != null) {
                        sta.push(root.right);
                    }
                    root.right = root.left;
                    root.left = null;
                }
                pre = root;
                root = root.right;
            } else {
                TreeNode next = sta.pop();
                pre.right = next;
                root = next;
            }
        }
        
    }
}
