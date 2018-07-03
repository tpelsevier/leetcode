//Time O(N) Space O(N)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length < 2) return nums.length;
        int n = nums.length, max = 0, res = 0;
        int[] dp = new int[n]; //Store the length of the longest array
        int[] count = new int[n]; //Store the number of the longest array at current index
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    //check how many index in j has this length;
                    if(dp[i] == dp[j] +1) count[i] += count[j];
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] +1; 
                        /*
                          If previous index length add 1 is greater than current length, 
                          count equals to how many longest increasing array at index j
                        */
                        count[i] = count[j];   
                    }
                }
            }
            /*Check the maximum length, if this dp has the same length as max,
            result adds up the count in current index
            */
            if(max == dp[i]) res += count[i];
            if(max < dp[i]){
                max = dp[i];
                res = count[i];
            }
        }
        
        return res;
    }
}
