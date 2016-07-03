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
        TreeNode n = root;
        int res = n.val;
        while(n != null) {
            res = Math.abs(n.val - target) < Math.abs(res - target) ? n.val : res;
            n = n.val > target ? n.left : n.right;
        }
        return res;
    }
}
