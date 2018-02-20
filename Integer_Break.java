//Time O(N^2) space O(N) using dp
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1;j<i;j++){
              //Compare current value and max(dp[j]'s result' and j) and max(dp[i-j] and j)
                dp[i] = Math.max(dp[i],Math.max(dp[j],j)*Math.max(dp[i-j],i-j));
            }
        }
        return dp[n];
    }
}
