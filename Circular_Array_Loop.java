class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length > 0){
            return nums[0] < 0 ? false: next(nums,0,false);
        }
        return false;
    }
    private boolean next(int[] nums, int index,boolean isLoop){
        if(index < nums.length){
            index += nums[index];
            if(index == nums.length) return true;
            if(index > 0 && index < nums.length) isLoop = next(nums,index,isLoop);
            if(index > nums.length) isLoop = next(nums,index%nums.length,isLoop);
        }
        return isLoop;

    }
}
