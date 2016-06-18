public class Solution {
    public boolean exist(char[][] board, String word) {
        if(!word.isEmpty() && (board == null || board.length == 0 || board[0].length == 0)) {
            return false;
        }
        if(board.length * board[0].length < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(existHelper(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean existHelper(char[][] board, String word, int top, int left, int start, boolean[][] visited) {
        if(start == word.length()) {
            return true;
        }
        if(top < 0 || top == board.length || left < 0 || left == board[0].length) {
            return false;
        }
        if(visited[top][left] || board[top][left] != word.charAt(start)) {
            return false;
        }
        visited[top][left] = true;
        boolean res = existHelper(board, word, top + 1, left, start + 1, visited)
                      || existHelper(board, word, top - 1, left, start + 1, visited)
                      || existHelper(board, word, top, left + 1, start + 1, visited)
                      || existHelper(board, word, top, left - 1, start + 1, visited);
        visited[top][left] = false;
        return res;
    }
}
