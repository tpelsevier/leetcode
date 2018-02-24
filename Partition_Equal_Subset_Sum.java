//Time O(N*L) Space O(L) L = sum(nums)/2
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0 || nums == null) return true;
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum+=num;
        if(sum % 2 == 1) return false;
        sum /=2; //Sum divided by two to see how many combos are there for sum/2
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i = 0;i<n;i++){
            for(int j = sum; j >= nums[i];j--){
                //If j has nums[i] in it, how many combos for dp[j-nums[i]]
                dp[j] += dp[j-nums[i]];
            }
        }
        //dp[sum] == 0 it is false else if combo numbers of sum is even it returns true //because for example
        // 2,1,2,1 the half sum is 3 the combo for this is 4 because first 2,1 and second 2,1 and first 2 plus second 1 and first 1 plus second 1
        //There is a duplicated combo
        return dp[sum] == 0 ? false: dp[sum] %2 == 0;
    }
}
