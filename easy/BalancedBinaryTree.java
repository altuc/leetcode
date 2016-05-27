/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isBalancedHelper(root) != -1;
    }
    
    public int isBalancedHelper(TreeNode n) {
        if(n == null) {
            return 0;
        }
        int left = isBalancedHelper(n.left);
        int right = isBalancedHelper(n.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root, 0) != -1;
    }
    
    public int isBalancedHelper(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }
        int left = isBalancedHelper(node.left, depth + 1);
        int right = isBalancedHelper(node.right, depth + 1);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
}
