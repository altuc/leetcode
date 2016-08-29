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
            return sum == 0;
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
            return path == sum;
        }
        return hasPathSumHelper(n.left, sum, path) || hasPathSumHelper(n.right, sum, path);
    }
}

public class Solution3 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum);
    }
    
    public boolean hasPathSumHelper(TreeNode node, int sum) {
        if(node.left == null && node.right == null) {
            return node.val == sum;
        } else if(node.left == null && node.right != null) {
            return hasPathSumHelper(node.right, sum - node.val);
        } else if(node.left != null && node.right == null) {
            return hasPathSumHelper(node.left, sum - node.val);
        } else {
            return hasPathSumHelper(node.left, sum - node.val) || hasPathSumHelper(node.right, sum - node.val);
        }
    }
}
