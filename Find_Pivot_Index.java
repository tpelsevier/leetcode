//Time O(N) Space O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            sum+=nums[i];
        }
        int sum2 = 0;
        for(int i = 0; i < nums.length;i++){
            sum -= nums[i];
            if(sum == sum2) return i;
            sum2+=nums[i];
        }
        return -1;
    }
}
