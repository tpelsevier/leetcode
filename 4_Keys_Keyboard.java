//Time O(N^2) Space O(N)
  class Solution {
      public int maxA(int N) {
          if (N < 6) return N;
          int[] dp = new int[N+1];
          for (int i = 0; i <= N; i++) {
              dp[i] = i;
              for(int j = 1; j <= N-3;j++){
                  dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
              }
          }
          return dp[N];
      }
  }
//Time O(N) Space O(N)
  class Solution {
    public int maxA(int N) {
        if (N < 6) return N;
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; i++) {
          dp[i] = i <= 6?i:Math.max(dp[i-4]*3,dp[i-5] * 4);
        }
        return dp[N];
    }
}
