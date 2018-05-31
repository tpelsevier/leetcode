//Time O((R*C)^2) Space O(1)
class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean goNext = false;
        for(int i = 0; i < m-2;i++){
            for(int j = 0;j < n; j++){
                int ori = Math.abs(board[i][j]);
                if(ori != 0 && Math.abs(board[i+1][j]) == ori && Math.abs(board[i+2][j]) == ori){
                    board[i][j] = board[i+1][j] = board[i+2][j] = -ori;
                    goNext = true;
                }
            }
        }
        for(int i = 0; i < m;i++){
            for(int j = 0;j < n-2; j++){
                int ori = Math.abs(board[i][j]);
                if(ori != 0 && Math.abs(board[i][j+1]) == ori && Math.abs(board[i][j+2]) == ori){
                    board[i][j] = board[i][j+1] = board[i][j+2] = -ori;
                    goNext = true;
                }
            }
        }

        for( int i = 0; i < n; i ++){
            int down = m-1;
            for(int j = m-1; j >= 0; j--){
                if(board[j][i] > 0){
                    board[down--][i] = board[j][i];
                }
            }
            while(down >= 0) board[down--][i] = 0;
        }
        return goNext? candyCrush(board):board;
    }
}
