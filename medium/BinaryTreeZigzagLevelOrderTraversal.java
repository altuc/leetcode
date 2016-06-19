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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ls = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
                ls.add(n.val);
            }
            if(level % 2 != 0) {
                res.add(ls);
            } else {
                List<Integer> reverseLs = new ArrayList<Integer>();
                for(int i = ls.size() - 1; i >= 0; i--) {
                    reverseLs.add(ls.get(i));
                }
                res.add(reverseLs);
            }
            level++;
        }
        return res;
    }
}
