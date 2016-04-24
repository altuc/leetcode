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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.empty()) {
            TreeNode n = s.pop();
            res.add(n.val);
            if(n.right != null) {
                s.push(n.right);
            }
            if(n.left != null) {
                s.push(n.left);
            }
        }
        return res;
    }
}

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversalHelper(root.left, res);
        preorderTraversalHelper(root.right, res);
        return res;
    }
    
    public void preorderTraversalHelper(TreeNode n, ArrayList<Integer> list) {
        if(n == null) {
            return;
        } else {
            list.add(n.val);
        }
        preorderTraversalHelper(n.left, list);
        preorderTraversalHelper(n.right, list);
    }
}

public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
