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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        pathSumHelper(res, path, root, sum);
        return res;
    }
    
    public void pathSumHelper(List<List<Integer>> res, List<Integer> path, TreeNode node, int sum) {
        if(node == null) {
            return;
        }
        path.add(node.val);
        sum -= node.val;
        if(node.left == null && node.right == null && sum == 0) {
            List<Integer> list = new ArrayList<Integer>(path);
            res.add(list);
        }
        pathSumHelper(res, path, node.left, sum);
        pathSumHelper(res, path, node.right, sum);
        path.remove(path.size() - 1);
    }
}
