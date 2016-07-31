public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int[] edge : edges) {
            if(!map.containsKey(edge[0])) {
                map.put(edge[0], new HashSet<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new HashSet<Integer>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        for(int key : map.keySet()) {
            if(map.get(key).size() == 1) {
                res.add(key);
            }
        }
        while(n > 2) {
            n -= res.size();
            List<Integer> leaves = new ArrayList<Integer>();
            for(int leaf : res) {
                int next = map.get(leaf).iterator().next();
                map.get(next).remove(leaf);
                if(map.get(next).size() == 1) {
                    leaves.add(next);
                }
            }
            res = leaves;
        }
        return res;
    }
}
