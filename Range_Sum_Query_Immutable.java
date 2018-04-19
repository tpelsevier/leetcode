//Time O(N) Space O(N)
class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        if(nums.length == 0 || nums == null) return;
        dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            dp[i] = dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0? dp[j]:dp[j] - dp[i-1];
    }
}
