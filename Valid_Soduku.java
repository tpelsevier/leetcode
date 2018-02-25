//Time O(N*M) Space O(N*M)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<board.length;i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] !='.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                /*
                3 *(i/3)
              row 0 1 2 3 4 5 6 7 8
              row 0 0 0 3 3 3 6 6 6   start from this row
              col 0 3 6 0 3 6 0 3 6   start from this col
                */
                int rowIndex = 3 * (i/3) + (j /3);
                int colIndex = 3 * (i%3) + (j %3);
                if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) return false;
            }
        }

        return true;
    }
}
