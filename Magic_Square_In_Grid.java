//Time O(N*M) Space O(1);
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length-2;i++){
            for(int j = 0; j < grid[0].length-2;j++){
                if(valid(i,j,grid)) count ++;
            }
        }
        return count;
    }
    private boolean valid(int i, int j, int[][] grid){
        int sum = 0;
        for(int x = 0;x< 3;x++){
            int col = 0;
            int row = 0;
            for(int y = 0; y < 3;y++){
                if(grid[i+x][j+y] > 9 || grid[i+x][j+y] < 1) return false;
                row += grid[i+x][j+y];
                col += grid[i+y][x+j];
            }
            if(row != col) return false;
            if(sum == 0) sum = row;
            else {
                if(sum != row || sum != col) return false;
            }
        }
        int dia = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
        if(sum != dia) return false;
        int antidia = grid[i+2][j]+ grid[i+1][j+1]+grid[i][j+2];
        if(sum != antidia) return false;
        return true;
    }

}
