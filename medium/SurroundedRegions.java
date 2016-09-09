public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    solveHelper(board, i, j);
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void solveHelper(char[][] board, int i, int j) {
        board[i][j] = 'V';
        int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x > 0 && x < board.length && y > 0 && y < board[0].length && board[x][y] == 'O') {
                solveHelper(board, x, y);
            }
        }
    }
}
