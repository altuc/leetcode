/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
            while(!q.isEmpty()) {
                nodeList.add(q.remove());
            }
            for(TreeNode n : nodeList) {
                level.add(n.val);
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}