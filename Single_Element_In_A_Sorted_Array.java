//Time O(LogN) Space O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low +(high - low)/2;
            if((mid == 0 || nums[mid] != nums[mid-1])&&(mid == nums.length-1 || nums[mid] != nums[mid+1])){
                return nums[mid];
            }
            if((mid+1 < nums.length && nums[mid+1] == nums[mid] && mid%2 == 0)|| (mid >= 1 && nums[mid] == nums[mid-1] && mid%2 == 1)){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
