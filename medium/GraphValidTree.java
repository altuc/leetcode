public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for(int[] edge : edges) {
            int parent1 = find(parents, edge[0]);
            int parent2 = find(parents, edge[1]);
            if(parent1 == parent2) {
                return false;
            }
            parents[parent1] = parent2;
        }
        return edges.length == n - 1;
    }
    
    public int find(int[] parents, int node) {
        if(parents[node] == -1) {
            return node;
        } else {
            return find(parents, parents[node]);
        }
    }
}
