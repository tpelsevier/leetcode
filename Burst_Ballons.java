//Time O(N^3) Space O(N)
class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len+2];
        for(int i = 0;i<len;i++) arr[i+1] = nums[i];
        arr[0] = arr[len+1] = 1;
        int[][] dp = new int[len+2][len+2];
        return helper(dp,arr,1,len);
    }
    private int helper(int[][] dp, int[] arr, int i, int j){
        if(i > j) return 0;
        if(dp[i][j] > 0) return dp[i][j];
        for(int x = i; x <= j;x++){
          //First helper calculate all the ballon before X burst with current ballon not burst
          //Second helper calculate all the ballons after x burst with current ballon not burst
            dp[i][j] = Math.max(dp[i][j],helper(dp,arr,i,x-1) + arr[i-1] * arr[x] * arr[j+1] + helper(dp,arr,x+1,j));
        }
        return dp[i][j];
    }
}
