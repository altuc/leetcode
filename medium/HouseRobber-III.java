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
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robHelper(TreeNode node) {
        int[] max = new int[2];
        if(node != null) {
            int[] leftMax = robHelper(node.left);
            int[] rightMax = robHelper(node.right);
            max[0] = node.val + leftMax[1] + rightMax[1];
            max[1] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
        }
        return max;
    }
}
