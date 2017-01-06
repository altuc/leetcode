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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        boolean oddLevel = true;
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
                if(oddLevel) {
                    level.add(n.val);
                } else {
                    level.add(0, n.val);
                }
            }
            oddLevel = !oddLevel;
            res.add(level);
        }
        return res;
    }
}
