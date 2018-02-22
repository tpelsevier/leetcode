//Time O(M*N) space O(M*N)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row,1);
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
//Time O(M*N) space O(N);
class Solution{
  public int uniquePaths(int m, int n) {
      int[] dp = new int[n];
      Arrays.fill(dp,1);
      for(int i = 1;i<m;i++){
          for(int j = 1;j<n;j++){
            //Store last row value in an array, and plus the previous col number which has been added up prviously
              dp[j] += dp[j-1];
          }
      }
      return dp[n-1];
  }
}
