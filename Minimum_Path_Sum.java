//Time O(N*M) space O(1)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for(int i = 1; i < m;i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1; i < n;i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}
//Time O(M*N) space O(1) this solution take O(M + N) away for calculation the sum of first row and sum of first col 
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j ==0) continue;
                else if(i == 0) grid[i][j] += grid[i][j-1];
                else if(j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}
