//Time O(logN) Space O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return new int[]{-1,-1};
        int n = nums.length, s = 0, e = n-1;
        while(s<e){
            int mid = (s+e)/2;
            if(nums[mid] == target){
                while(nums[s] != target) s++;
                while(nums[e] != target) e--;
                break;
            }
            if(nums[mid] > target) e = mid-1;
            else s = mid+1;
        }
        return nums[s] != target?new int[]{-1,-1}:new int[]{s,e}; //If start index is not target return {-1,-1}

    }
}
