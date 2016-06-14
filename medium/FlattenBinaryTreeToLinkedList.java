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
        Stack<TreeNode> sta = new Stack<TreeNode>();
        sta.push(root);
        while(!sta.empty()) {
            TreeNode n = sta.pop();
            if(n.right != null) {
                sta.push(n.right);
            }
            if(n.left != null) {
                sta.push(n.left);
            }
            n.left = null;
            if(!sta.empty()) {
                n.right = sta.peek();
            }
        }
    }
}

public class Solution2 {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> sta = new Stack<TreeNode>();
        sta.push(root);
        TreeNode cur = null;
        while(!sta.empty()) {
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
