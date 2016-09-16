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
        if(root == null) {
            return null;
        }
        if(p.right != null) {
            return findMin(p.right);
        } else {
            TreeNode successor = null;
            while(root != p) {
                if(p.val < root.val) {
                    successor = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return successor;
        }
    }
    
    public TreeNode findMin(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
