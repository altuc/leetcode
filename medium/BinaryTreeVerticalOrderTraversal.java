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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map1 = new TreeMap<Integer, List<Integer>>();
        map1.put(0, new ArrayList<Integer>());
        map1.get(0).add(root.val);
        HashMap<TreeNode, Integer> map2 = new HashMap<TreeNode, Integer>();
        map2.put(root, 0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n.left != null) {
                q.add(n.left);
                map2.put(n.left, map2.get(n) - 1);
                if(!map1.containsKey(map2.get(n) - 1)) {
                    map1.put(map2.get(n) - 1, new ArrayList<Integer>());
                }
                map1.get(map2.get(n) - 1).add(n.left.val);
            }
            if(n.right != null) {
                q.add(n.right);
                map2.put(n.right, map2.get(n) + 1);
                if(!map1.containsKey(map2.get(n) + 1)) {
                    map1.put(map2.get(n) + 1, new ArrayList<Integer>());
                }
                map1.get(map2.get(n) + 1).add(n.right.val);
            }
        }
        for(List<Integer> value : map1.values()) {
            res.add(value);
        }
        return res;
    }
}
