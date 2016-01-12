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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        } 
        String path = Integer.toString(root.val);
        binaryTreePathsHelper(root.left, root.right, path, res);
        return res;
    }
    
    public void binaryTreePathsHelper(TreeNode left, TreeNode right, String path, ArrayList<String> res) {
        if(left == null && right == null) {
            res.add(path);
        } else if(left == null && right != null) {
            path = path + "->" + Integer.toString(right.val);
            binaryTreePathsHelper(right.left, right.right, path, res);
        } else if(left != null && right == null) {
            path = path + "->" + Integer.toString(left.val);
            binaryTreePathsHelper(left.left, left.right, path, res);
        } else {
            String path1 = path + "->" + Integer.toString(right.val);
            binaryTreePathsHelper(right.left, right.right, path1, res);
            String path2 = path + "->" + Integer.toString(left.val);
            binaryTreePathsHelper(left.left, left.right, path2, res);
        }
    }
}
