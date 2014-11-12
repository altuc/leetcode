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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return hasPathSumHelper(root.left, root.right, sum - root.val);
    }
    
    public boolean hasPathSumHelper(TreeNode l, TreeNode r, int sum) {
        if(l == null && r == null) {
            if(sum == 0) {
                return true;
            } else {
                return false;
            }
        } else if(l == null && r != null) {
            return hasPathSumHelper(r.left, r.right, sum - r.val);
        } else if(l != null && r == null) {
            return hasPathSumHelper(l.left, l.right, sum - l.val);
        } else {
            return hasPathSumHelper(l.left, l.right, sum - l.val) || hasPathSumHelper(r.left, r.right, sum - r.val);
        }
    }
}

public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum, 0);
    }
    
    public boolean hasPathSumHelper(TreeNode n, int sum, int path) {
        if(n == null) {
            return false;
        }
        path = path + n.val;
        if(n.left == null && n.right == null) {
            if(path == sum) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSumHelper(n.left, sum, path) || hasPathSumHelper(n.right, sum, path);
    }
}