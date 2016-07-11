public class TicTacToe {
    
    private int[] horizontal = null;
    private int[] vertical = null;
    private int diagonal = 0;
    private int antiDiagonal = 0;
    private int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        horizontal = new int[n];
        vertical = new int[n];
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int fill = player == 1 ? 1 : -1;
        horizontal[row] += fill;
        vertical[col] += fill;
        if(row == col) {
            diagonal += fill;
        }
        if(row == size - col - 1) {
            antiDiagonal += fill;
        }
        if(Math.abs(horizontal[row]) == size || Math.abs(vertical[col]) == size || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
