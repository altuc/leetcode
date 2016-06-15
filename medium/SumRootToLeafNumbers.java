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
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    public int sumNumbersHelper(TreeNode n, int sum) {
        if(n == null) {
            return 0;
        }
        if(n.left == null && n.right == null) {
            return sum * 10 + n.val;
        }
        return sumNumbersHelper(n.left, sum * 10 + n.val) + sumNumbersHelper(n.right, sum * 10 + n.val);
    }
}

public class Solution2 {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n.left != null) {
                n.left.val = n.val * 10 + n.left.val;
                q.add(n.left);
            }
            if(n.right != null) {
                n.right.val = n.val * 10 + n.right.val;
                q.add(n.right);
            }
            if(n.left == null && n.right == null) {
                sum += n.val;
            }
        }
        return sum;
    }
}
