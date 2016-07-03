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
    
    public void serializeHelper(TreeNode node, StringBuilder sb) {
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
        Queue<String> q = new LinkedList<String>();
        q.addAll(Arrays.asList(nodes));
        return deserializeHelper(q);
    }
    
    public TreeNode deserializeHelper(Queue<String> q) {
        String s = q.poll();
        if(("#").equals(s)) {
            return null;
        } else {
            TreeNode n = new TreeNode(Integer.parseInt(s));
            n.left = deserializeHelper(q);
            n.right = deserializeHelper(q);
            return n;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
