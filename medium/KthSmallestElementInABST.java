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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode n = root;
        while(!s.empty() || n != null) {
            if(n != null) {
                s.push(n);
                n = n.left;
            } else {
                n = s.pop();
                res.add(n.val);
                if(res.size() == k) {
                    return res.get(k - 1);
                }
                n = n.right;
            }
        }
        return res.get(k - 1);
    }
}

public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> sta = new Stack<TreeNode>();
        while(!sta.empty() || root != null) {
            if(root != null) {
                sta.push(root);
                root = root.left;
            } else {
                root = sta.pop();
                if(k == 1) {
                    break;
                }
                k--;
                root = root.right;
            }
        }
        return root.val;
    }
}
