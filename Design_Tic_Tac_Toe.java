//Time O(M) space O(N) m = moves
class TicTacToe {

    /** Initialize your data structure here. */
    int[] rows;
    int[] cols;
    int dia;
    int anti;
    int n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
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
        int add = player==1?1:-1;
        rows[row] += add; //Current row + 1 or -1
        cols[col] += add; //Current col +1 or -1
        if(row == col) dia += add; //dia + 1 or -1
        if(row+col+1 == n) anti += add; //dia +1 or -1;
        return Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(dia) == n || Math.abs(anti) == n?player:0;
    }
}
