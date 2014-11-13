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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        TreeNode n1 = p;
        TreeNode n2 = q;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(n1);
        s.push(n2);
        int t1 = 0, t2 = 0;
        while(!s.empty()) {
            n1 = s.pop();
            n2 = s.pop();
            t1 = n1.val;
            t2 = n2.val;
            if(t1 != t2) {
                return false;
            }
            if(n1.right != null && n2.right != null) {
                s.push(n1.right);
                s.push(n2.right);
            } else {
                if(!(n1.right == null && n2.right == null)) {
                    return false;
                }
            }
            if(n1.left != null && n2.left != null) {
                s.push(n1.left);
                s.push(n2.left);
            } else {
                if(!(n1.left == null && n2.left == null)) {
                    return false;
                }
            }
        }
        return true;
    }
}