public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                gameOfLifeHelper(board, i, j);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    public void gameOfLifeHelper(int[][] board, int i, int j) {
        int liveN = 0;
        if(i - 1 >= 0 && j - 1 >= 0) {
            if(board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) {
                liveN++;
            }
        }
        if(i - 1 >= 0) {
            if(board[i - 1][j] == 1 || board[i - 1][j] == 2) {
                liveN++;
            }
        }
        if(i - 1 >= 0 && j + 1 < board[0].length) {
            if(board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) {
                liveN++;
            }
        }
        if(j - 1 >= 0) {
            if(board[i][j - 1] == 1 || board[i][j - 1] == 2) {
                liveN++;
            }
        }
        if(j + 1 < board[0].length) {
            if(board[i][j + 1] == 1 || board[i][j + 1] == 2) {
                liveN++;
            }
        }
        if(i + 1 < board.length && j - 1 >= 0) {
            if(board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2) {
                liveN++;
            }
        }
        if(i + 1 < board.length) {
            if(board[i + 1][j] == 1 || board[i + 1][j] == 2) {
                liveN++;
            }
        }
        if(i + 1 < board.length && j + 1 < board[0].length) {
            if(board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2) {
                liveN++;
            }
        }
        if(board[i][j] == 1) {
            if(liveN < 2 || liveN > 3) {
                board[i][j] = 2;
            }
        } else {
            if(liveN == 3) {
                board[i][j] = 3;
            }
        }
    }
}
