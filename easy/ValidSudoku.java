public class Solution1 {
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

public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for(int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for(int j = 0; j < board[0].length; j++) {
                if(!set.add(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
            }
        }
        for(int j = 0; j < board[0].length; j++) {
            HashSet<Character> set = new HashSet<Character>();
            for(int i = 0; i < board.length; i++) {
                if(!set.add(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
            }
        }
        for(int i = 0; i < board.length; i += 3) {
            for(int j = 0; j < board[0].length; j += 3) {
                HashSet<Character> set = new HashSet<Character>();
                for(int m = 0; m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        if(!set.add(board[i + m][j + n]) && board[i + m][j + n] != '.') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
