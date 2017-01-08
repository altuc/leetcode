public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(existHelper(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean existHelper(char[][] board, String word, boolean[][] visited, int count, int i, int j) {
        if(count == word.length()) {
            return true;
        }
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(count)) {
            return false;
        }
        visited[i][j] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs) {
            if(existHelper(board, word, visited, count + 1, i + dir[0], j + dir[1])) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
