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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
    
    public boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if(node == null) {
            return true;
        }
        if((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }
}

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isValidBSTHelper(root, null, null);
    }
    
    public boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if(node.left != null && node.left.val >= node.val) {
            return false;
        }
        if(node.right != null && node.right.val <= node.val) {
            return false;
        }
        if(min != null && node.left != null && node.left.val <= min) {
            return false;
        }
        if(max != null && node.right != null && node.right.val >= max) {
            return false;
        }
        if(node.left != null && node.right != null) {
            return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
        } else if(node.left != null) {
            return isValidBSTHelper(node.left, min, node.val);
        } else if(node.right != null) {
            return isValidBSTHelper(node.right, node.val, max);
        } else {
            return true;
        }
    }
}

public class Solution3 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        Integer pre = null;
        while(!s.empty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                if(pre != null && pre >= root.val) {
                    return false;
                } else {
                    pre = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }
}
