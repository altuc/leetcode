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
                    return res.get(k-1);
                }
                n = n.right;
            }
        }
        return res.get(k-1);
    }
}
