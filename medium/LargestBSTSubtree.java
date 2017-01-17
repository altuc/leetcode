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
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(validateBST(root, null, null)) {
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean validateBST(TreeNode node, Integer min, Integer max) {
        if(node == null) {
            return true;
        }
        if((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }
    
    private int countNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
