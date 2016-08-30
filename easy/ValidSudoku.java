public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> row = new HashSet<Character>();
            for(int j = 0; j < board.length; j++) {
                if((board[i][j] != '.' && !row.add(board[i][j])) || (board[j][i] != '.' && !col.add(board[j][i]))) {
                    return false;
                }
            }
        }
        for(int i = 0; i < board.length; i += 3) {
            for(int j = 0; j < board.length; j += 3) {
                HashSet<Character> set = new HashSet<Character>();
                for(int m = 0; m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        if(board[i + m][j + n] != '.' && !set.add(board[i + m][j + n])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
