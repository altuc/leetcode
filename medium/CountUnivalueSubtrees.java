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
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] res = countUnivalSubtreesHelper(root);
        return res[0];
    }
    
    public int[] countUnivalSubtreesHelper(TreeNode node) {
        int[] res = new int[2];
        if(node.left == null && node.right == null) {
            res[0] = 1;
            res[1] = 1;
            return res;
        }
        boolean uni = true;
        if(node.left != null) {
            int[] left = countUnivalSubtreesHelper(node.left);
            res[0] += left[0];
            res[1] += left[1];
            uni &= (node.val == node.left.val) ;
        }
        if(node.right != null) {
            int[] right = countUnivalSubtreesHelper(node.right);
            res[0] += right[0];
            res[1] += right[1];
            uni &= (node.val == node.right.val);
        }
        if(res[0] == res[1] && uni) {
            res[0] += 1;
        }
        res[1] += 1;
        return res;
    }
}
