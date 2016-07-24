public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for(int[] edge : edges) {
            int parent1 = find(parents, edge[0]);
            int parent2 = find(parents, edge[1]);
            if(parent1 != parent2) {
                parents[parent1] = parent2;
            }
        }
        int count = 0;
        for(int parent : parents) {
            if(parent == -1) {
                count++;
            }
        }
        return count;
    }
    
    public int find(int[] parents, int node) {
        if(parents[node] == -1) {
            return node;
        } else {
            return find(parents, parents[node]);
        }
    }
}
