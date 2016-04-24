/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
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
