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
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(longestConsecutiveHelper(root.left, 1, root.val), longestConsecutiveHelper(root.right, 1, root.val));
    }
    
    public int longestConsecutiveHelper(TreeNode node, int len, int pre) {
        if(node == null) {
            return len;
        }
        if(node.val == pre + 1) {
            len++;
        } else {
            len = 1;
        }
        int left = longestConsecutiveHelper(node.left, len, node.val);
        int right = longestConsecutiveHelper(node.right, len, node.val);
        return Math.max(Math.max(left, right), len);
    }
}
