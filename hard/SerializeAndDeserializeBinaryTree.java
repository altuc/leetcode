/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString().substring(0, sb.length() - 1);
    }
    
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#,");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(("#").equals(data)) {
            return null;
        }
        String[] nodes = data.split(",");
        Deque<String> que = new ArrayDeque<String>();
        que.addAll(Arrays.asList(nodes));
        return deserializeHelper(que);
    }
    
    private TreeNode deserializeHelper(Deque<String> que) {
        String s = que.poll();
        if(("#").equals(s)) {
            return null;
        } else {
            TreeNode n = new TreeNode(Integer.parseInt(s));
            n.left = deserializeHelper(que);
            n.right = deserializeHelper(que);
            return n;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
