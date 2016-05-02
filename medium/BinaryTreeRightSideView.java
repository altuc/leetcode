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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        rightSideViewHelper(root, res, 0);
        return res;
    }
    
    public void rightSideViewHelper(TreeNode node, List<Integer> res, int level) {
        if(node == null) {
            return;
        }
        if(level == res.size()) {
            res.add(node.val);
        }
        rightSideViewHelper(node.right, res, level + 1);
        rightSideViewHelper(node.left, res, level + 1);
    }
}

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == 0) {
                    res.add(node.val);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return res;
    }
}
