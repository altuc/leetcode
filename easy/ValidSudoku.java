public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            for(int j = 0; j < 9; j++) {
                if((board[i][j] != '.' && !row.add(board[i][j])) || (board[j][i] != '.' && !col.add(board[j][i]))) {
                    return false;
                }
            }
        }
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<Character>();
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                       if(board[i + k][j + l] != '.' && !set.add(board[i + k][j + l])) {
                           return false;
                       } 
                    }
                }
            }
        }
        return true;
    }
}
