//Time O(N) Space O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int p = 1;
        int i = 0, j = 0;
        int n = nums.length;
        int total = 0;
        while(i<n){
            p *= nums[i];
            while(i >=j && p >= k){
                p/=nums[j];
                j++;
            }

            total+=(i-j+1);
            i++;
        }
        return total;
    }
}
