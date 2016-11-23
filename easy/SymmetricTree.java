/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Recursively */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if((left == null && right != null) || (left != null && right == null) || left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}

/* Iteratively */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null || right == null) {
            return left == right;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(left);
        que.add(right);
        while(!que.isEmpty()) {
            left = que.poll();
            right = que.poll();
            if(left.val != right.val) {
                return false;
            }
            if(left.left != null && right.right != null) {
                que.add(left.left);
                que.add(right.right);
            } else {
                if(left.left != right.right) {
                    return false;
                }
            }
            if(left.right != null && right.left != null) {
                que.add(left.right);
                que.add(right.left);
            } else {
                if(left.right != right.left) {
                    return false;
                }
            }
        }
        return true;
    }
}
