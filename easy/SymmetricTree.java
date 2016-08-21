/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* recursively */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        }
        if(l != null && r == null) {
            return false;
        }
        if(l == null && r != null) {
            return false;
        }
        if(l.val != r.val) {
            return false;
        }
        if(!isSymmetricHelper(l.left, r.right)) {
            return false;
        }
        if(!isSymmetricHelper(l.right, r.left)) {
            return false;
        }
        return true;
    }
}

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if((left == null && right != null) || (left != null && right == null)) {
            return false;
        } else {
            if(left.val != right.val) {
                return false;
            } else {
                return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
            }
        }
    }
}

/* iteratively */
public class Solution3 {
    public boolean isSymmetric(TreeNode root) {
       if(root == null) {
           return true;
       }
       if(root.left == null && root.right == null) {
           return true;
       }
       if(root.left != null && root.right == null) {
           return false;
       }
       if(root.left == null && root.right != null) {
           return false;
       }
       Stack<TreeNode> s1 = new Stack<TreeNode>();
       s1.push(root.left);
       Stack<TreeNode> s2 = new Stack<TreeNode>();
       s2.push(root.right);
       while(!s1.empty() && !s2.empty()) {
           if(s1.peek().val != s2.peek().val) {
               return false;
           }
           TreeNode t1 = s1.pop();
           TreeNode t2 = s2.pop();
           if(t1.left != null && t2.right != null) {
               s1.push(t1.left);
               s2.push(t2.right);
           } else if(t1.left == null && t2.right == null) {
           } else {
               return false;
           }
           if(t1.right != null && t2.left != null) {
               s1.push(t1.right);
               s2.push(t2.left);
           } else if(t1.right == null && t2.left == null) {
           } else {
               return false;
           }
       }
       return true;
    }
}
