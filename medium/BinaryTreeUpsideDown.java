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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode temp = null;
        TreeNode next = null;
        TreeNode pre = null;
        while(cur != null) {
            next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

public class Solution2 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
