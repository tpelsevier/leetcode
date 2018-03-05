//Time O(N) Space O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums){
          // Check the first element of two consecutve numbers
            if(i < 2 || n > nums[i-2]) nums[i++] = n;
        }
        return i;
    }
}
