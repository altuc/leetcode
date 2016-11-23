/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int sum) {
        if(node.left == null && node.right == null) {
            return sum == node.val;
        } else if(node.left == null && node.right != null) {
            return hasPathSumHelper(node.right, sum - node.val);
        } else if(node.left != null && node.right == null) {
            return hasPathSumHelper(node.left, sum - node.val);
        } else {
            return hasPathSumHelper(node.left, sum - node.val) || hasPathSumHelper(node.right, sum - node.val);
        }
    }
}
