//Time O(N) space O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                int ne = count(board,i,j);
                if(board[i][j] == 1 && (ne == 2 || ne == 3)) board[i][j] +=2;
                else if (ne == 3) board[i][j] += 2;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>=1;
            }
        }
    }
    private int count(int[][] board, int i, int j){
        int co = 0;
        for(int x = -1;x<2;x++){
            for(int y = -1;y < 2; y++){
                int r = i + x;
                int c = j +y;
                if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || (x == 0 && y == 0)) continue;
                if((board[r][c] & 1) == 1) co++;
            }
        }
        return co;
    }
}
