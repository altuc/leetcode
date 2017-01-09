/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Deque<TreeNode> sta = null;

    public BSTIterator(TreeNode root) {
        sta = new ArrayDeque<TreeNode>();
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !sta.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = sta.pop();
        pushAll(n.right);
        return n.val;
    }
    
    // Iterative
    private void pushAll(TreeNode n) {
        while(n != null) {
            sta.push(n);
            n = n.left;
        }
    }
    
    // Recursive
    private void pushAll(TreeNode node) {
        if(node != null) {
            sta.push(node);
            pushAll(node.left);
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
