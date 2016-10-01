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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sumOfLeftLeavesHelper(root, false);
    }
    
    public int sumOfLeftLeavesHelper(TreeNode node, boolean isLeft) {
        int sum = 0;
        if(node.left == null && node.right == null) {
            sum = isLeft ? node.val : 0;
        } else if(node.left != null && node.right == null) {
            sum += sumOfLeftLeavesHelper(node.left, true);
        } else if(node.left == null && node.right != null) {
            sum += sumOfLeftLeavesHelper(node.right, false);
        } else {
            sum += sumOfLeftLeavesHelper(node.left, true);
            sum += sumOfLeftLeavesHelper(node.right, false);
        }
        return sum;
    }
}
