//Time O(N) Space O(1)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int sum = 0, count = 0, res = Integer.MAX_VALUE;
        for(int i = 0,j = 0; i <nums.length;i++){
            sum+=nums[i];
            count ++;
            while(j <= i && sum >= s){
                res = Math.min(res,count);
                count --;
                sum -= nums[j++];
            }
        }
        return res == Integer.MAX_VALUE? 0:res;
    }
}
