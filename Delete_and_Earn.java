//Time O(M+N) M = nums.length n = max number
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int[] count = new int[10001];
        int max = Integer.MIN_VALUE;
        for(int n: nums) {
            count[n] += n;
            max = Math.max(max,n);  //find the max number that array contains
        }
        int[] dp = new int[max+1];
        dp[1] = count[1]; //Set the index 1 of dp to one in case of all the numbers are 1
        for(int i = 2; i <= max;i++)dp[i] = Math.max(dp[i-1],dp[i-2]+count[i]);
        return dp[max];
    }
}
