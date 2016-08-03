public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }
        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] position : positions) {
            int node = n * position[0] + position[1];
            parents[node] = node;
            count++;
            for(int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                int neighbor = n * x + y;
                if(x < 0 || x == m || y < 0 || y == n || parents[neighbor] == -1) {
                    continue;
                }
                int neighborParent = find(parents, neighbor);
                if(neighborParent != node) {
                    parents[node] = neighborParent;
                    count--;
                    node = neighborParent;
                }
            }
            res.add(count);
        }
        return res;
    }
    
    public int find(int[] parents, int node) {
        if(parents[node] == node) {
            return node;
        } else {
            parents[node] = find(parents, parents[node]);
            return parents[node];
        }
    }
}
