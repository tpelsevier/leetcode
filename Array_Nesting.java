//Time O(N) Space O(1);
class Solution {
    public int arrayNesting(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == -1 || nums[i] >= nums.length) continue;
            int start = nums[i];
            int c2 = 1;
            while(nums[start] != -1){
                c2++;
                int temp = start;
                start = nums[start];
                nums[temp] = -1;
            }
            count = Math.max(c2,count);
        }
        return count;
    }
}
