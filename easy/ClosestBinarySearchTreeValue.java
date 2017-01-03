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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null) {
            res = Math.abs(root.val - target) < Math.abs(res - target) ? root.val : res;
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
