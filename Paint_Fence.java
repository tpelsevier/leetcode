//Time O(N) Space O(N)
class Solution {
    public int numWays(int n, int k) {
        if(k == 0 || n == 0) return 0;
        if(n == 1) return k;
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k*k;
        //Since painting the two consecutive is Okay
        /*
          Assume color = 3
          fences 1 2 3
                 3 9 24
          because there are first two here contains two same colors
          so number 3 fence can't have 3 color all together so it needs to minus one
          2 *dp[i -1] means i-1 fence and i-2 fence share the same color
          2*dp[i-2] means i-1 fence and i fence share the same corlor
        */
        for(int i = 3; i<=n;i++){
            dp[i] = (k-1)*(dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}
