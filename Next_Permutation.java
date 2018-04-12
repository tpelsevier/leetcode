//Time O(N) Space O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        for(;i>=0 && nums[i]>=nums[i+1];i--); //Find the first index breaking the descending order

        if(i >= 0){
            int j = i + 1;
            for(;j < nums.length && nums[i] <nums[j];j++); //Find the last element that is greater than nums[i] which breaks the descending order
            swap(nums,i,j-1);
        }
        i++;
        int k = nums.length - 1;
        while(i < k){
            swap(nums,i++,k--);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
