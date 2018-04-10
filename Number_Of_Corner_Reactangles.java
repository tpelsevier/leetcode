//Time O(N^2*M) Space O(1)
/*
Fix any two rows first
*/
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length < 2 || grid[0].length <2) {
            return 0;
        }
        int total = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = i+1; j< grid.length; j++){
                int count = 0;
                for(int z = 0; z < grid[0].length;z++){
                    if(grid[i][z] == 1 && grid[j][z] == 1) count ++;
                }
                if(count > 0) total+= count * (count-1)/2;
            }
        }
        return total;
    }
}

//Time O(M*N^2) Space (N^2)
/*
  1 1 1       0 0 0
  1 1 1       0 0 0
  1 0 1       0 0 0
  first start the first rows
res = 0
              0 1 1
              1 0 0
              0 0 0
  second row:
res = 3
              0 2 2
              2 0 0
              0 0 0
  third row
  res = 5
              0 2 3
              2 0 0
              0 0 0
*/

class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length < 2 || grid[0].length <2) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        int total = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1){
                    for(int z = j+1; z < n;z++){
                        if(grid[i][z] == 1) total += dp[j][z]++;
                    }
                }
            }
        }
        return total;
    }
}
