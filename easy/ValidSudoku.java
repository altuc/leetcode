public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            ArrayList<Character> list = new ArrayList<Character>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && list.contains(board[i][j])) {
                    return false;
                } else {
                    list.add(board[i][j]);
                }
            }
        }
        for(int j = 0; j < 9; j++) {
            ArrayList<Character> list = new ArrayList<Character>();
            for(int i = 0; i < 9; i++) {
                if(board[i][j] != '.' && list.contains(board[i][j])) {
                    return false;
                } else {
                    list.add(board[i][j]);
                }
            }
        }
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                ArrayList<Character> list = new ArrayList<Character>();
                for(int m = 0; m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        if(board[m+i][n+j] != '.' && list.contains(board[m+i][n+j])) {
                            return false;
                        } else {
                            list.add(board[m+i][n+j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}