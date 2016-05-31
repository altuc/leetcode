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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return minDepthHelper(root.left, root.right, 1);
    }
    
    public int minDepthHelper(TreeNode l, TreeNode r, int depth) {
        if(l == null && r == null) {
            return depth;
        } else if(l == null && r != null) {
            return minDepthHelper(r.left, r.right, depth + 1);
        } else if(l != null && r == null) {
            return minDepthHelper(l.left, l.right, depth + 1);
        } else {
            return Math.min(minDepthHelper(l.left, l.right, depth + 1), minDepthHelper(r.left, r.right, depth + 1));
        }
    }
}

public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return minDepthHelper(root, 0);
    }
    
    public int minDepthHelper(TreeNode n, int depth) {
        depth++;
        if(n == null) {
            return Integer.MAX_VALUE;
        }
        if(n.left == null && n.right == null) {
            return depth;
        }
        return Math.min(minDepthHelper(n.left, depth), minDepthHelper(n.right, depth));
    }
}

public class Solution3 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return minDepthHelper(root, 1);
    }
    
    public int minDepthHelper(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            return depth;
        } else if(node.left != null && node.right == null) {
            return minDepthHelper(node.left, depth + 1);
        } else if(node.left == null && node.right != null) {
            return minDepthHelper(node.right, depth + 1);
        } else {
            return Math.min(minDepthHelper(node.left, depth + 1), minDepthHelper(node.right, depth + 1));
        }
    }
}
