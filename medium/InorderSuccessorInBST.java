/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }
        if(p.right != null) {
            TreeNode n = p.right;
            while(n.left != null) {
                n = n.left;
            }
            return n;
        } else {
            TreeNode n = null;
            while(root != p) {
                if(root.val > p.val) {
                    n = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return n;
        }
    }
}
