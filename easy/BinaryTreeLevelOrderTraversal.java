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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> que = new ArrayDeque<TreeNode>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode n = que.poll();
                if(n.left != null) {
                    que.add(n.left);
                }
                if(n.right != null) {
                    que.add(n.right);
                }
                level.add(n.val);
            }
            res.add(level);
        }
        return res;
    }
}
