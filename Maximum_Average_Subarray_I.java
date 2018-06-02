//Time O(N) Space O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int total = 0;
        for(int i = 0,j = 0; i < nums.length;i++){
            total += nums[i];
            if(i >= k-1) {
                max = Math.max((double)total/k,max);
                total-=nums[j++];
            }

        }
        return max;
    }
}
