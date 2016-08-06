public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] dist = new int[grid.length][grid[0].length];
        int[][] num = new int[grid.length][grid[0].length];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int total = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    total++;
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.add(new int[]{i, j});
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int level = 1;
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int k = 0; k < size; k++) {
                            int[] cur = q.poll();
                            for(int l = 0; l < 4; l++) {
                                int x = cur[0] + dir[l][0];
                                int y = cur[1] + dir[l][1];
                                if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] != 0 || visited[x][y]) {
                                    continue;
                                }
                                dist[x][y] += level;
                                num[x][y]++;
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && num[i][j] == total) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
