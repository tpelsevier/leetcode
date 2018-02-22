//Time O(M*N) Space O(M * N);

/*
obstacleGrid:
          0 0 0
          0 1 0
          0 0 0
dp:
          0 1 0 0
          0   1 1 1
          0   1 0 1
          0   1 1 2
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int dp[][] = new int[m+1][n+1];
        dp[0][1] = 1; //Or dp[1][0]
        for(int i = 1; i <= m;i++){
            for(int j = 1; j <= n ;j ++){
                //Dp[i][j] correspond to obstacleGrid[i-1][j-1]
                if(obstacleGrid[i-1][j-1] == 0) dp[i][j] =  dp[i-1][j] + dp[i][j-1];
                else dp[i][j] = 0;
            }
        }
        return dp[m][n];
    }
}
