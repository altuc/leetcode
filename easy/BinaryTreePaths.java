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
        List<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        binaryTreePathsHelper(root, res, "");
        return res;
    }
    
    private void binaryTreePathsHelper(TreeNode node, List<String> res, String path) {
        if(node.left == null && node.right == null) {
            path += node.val;
            res.add(path);
            return;
        } else if(node.left != null && node.right == null) {
            binaryTreePathsHelper(node.left, res, path + node.val + "->");
        } else if(node.left == null && node.right != null) {
            binaryTreePathsHelper(node.right, res, path + node.val + "->");
        } else {
            binaryTreePathsHelper(node.left, res, path + node.val + "->");
            binaryTreePathsHelper(node.right, res, path + node.val + "->");
        }
    }
}
