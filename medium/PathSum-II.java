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
            res.add(new ArrayList<Integer>(path));
        }
        pathSumHelper(res, path, node.left, sum);
        pathSumHelper(res, path, node.right, sum);
        path.remove(path.size() - 1);
    }
}

public class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        pathSumHelper(root, sum, res, ls);
        return res;
    }
    
    public void pathSumHelper(TreeNode node, int sum, List<List<Integer>> res, List<Integer> ls) {
        ls.add(node.val);
        if(node.left == null && node.right == null) {
            if(sum == node.val) {
                res.add(new ArrayList<Integer>(ls));
            }
        } else if(node.left != null && node.right == null) {
            pathSumHelper(node.left, sum - node.val, res, ls);
        } else if(node.left == null && node.right != null) {
            pathSumHelper(node.right, sum - node.val, res, ls);
        } else {
            pathSumHelper(node.left, sum - node.val, res, ls);
            pathSumHelper(node.right, sum - node.val, res, ls);
        }
        ls.remove(ls.size() - 1);
    }
}
