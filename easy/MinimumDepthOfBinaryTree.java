/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return minDepthHelper(root);
    }
    
    private int minDepthHelper(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 1;
        } else if(node.left == null && node.right != null) {
            return minDepthHelper(node.right) + 1;
        } else if(node.left != null && node.right == null) {
            return minDepthHelper(node.left) + 1;
        } else {
            return Math.min(minDepthHelper(node.left), minDepthHelper(node.right)) + 1;
        }
    }
}

public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if(n.left == null && n.right == null) {
                    return depth;
                }
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
