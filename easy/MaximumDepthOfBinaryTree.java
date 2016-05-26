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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return maxDepthHelper(root.left, root.right, 1);
    }
    
    public int maxDepthHelper(TreeNode l, TreeNode r, int depth) {
        if(l == null && r == null) {
            return depth;
        } else if(l == null && r != null) {
            return maxDepthHelper(r.left, r.right, depth + 1);
        } else if(l != null && r == null) {
            return maxDepthHelper(l.left, l.right, depth + 1);
        } else {
            return Math.max(maxDepthHelper(l.left, l.right, depth + 1), maxDepthHelper(r.left, r.right, depth + 1));
        }
    }
}

public class Solution2 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return maxDepthHelper(root, 0);
    }
    
    public int maxDepthHelper(TreeNode n, int depth) {
        depth++;
        if(n == null) {
            return 0;
        }
        if(n.left == null && n.right == null) {
            return depth;
        }
        return Math.max(maxDepthHelper(n.left, depth), maxDepthHelper(n.right, depth));
    }
}

public class Solution3 {
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }
    
    public int maxDepthHelper(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }
        return Math.max(maxDepthHelper(node.left, depth + 1), maxDepthHelper(node.right, depth + 1));
    }
}
