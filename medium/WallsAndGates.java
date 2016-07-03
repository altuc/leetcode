public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    wallsAndGatesHelper(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void wallsAndGatesHelper(int[][] rooms, int i, int j, int dist) {
        if(i < 0 || i == rooms.length || j < 0 || j == rooms[0].length || rooms[i][j] < dist) {
            return;
        }
        rooms[i][j] = dist;
        wallsAndGatesHelper(rooms, i - 1, j, dist + 1);
        wallsAndGatesHelper(rooms, i + 1, j, dist + 1);
        wallsAndGatesHelper(rooms, i, j - 1, dist + 1);
        wallsAndGatesHelper(rooms, i, j + 1, dist + 1);
    }
}
