/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }
        TreeNode cur = root;
        while(cur.val < Math.min(p.val, q.val) || cur.val > Math.max(p.val, q.val)) {
            if(cur.val < Math.min(p.val, q.val)) {
                cur = cur.right;
            }
            if(cur.val > Math.max(p.val, q.val)) {
                cur = cur.left;
            }
        }
        return cur;
    }
}

public class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root.val < q.val && root.val < p.val) {
            root = lowestCommonAncestor(root.right, p, q);
        }
        if(root.val > q.val && root.val > p.val) {
            root = lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}

public class Solution4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
