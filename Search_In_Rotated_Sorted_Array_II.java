//Time O(LogN) Space O(N)
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(nums[mid] == target|| nums[r] == target || nums[l] == target) return true;
            // Make sure this is a regular sorted order
            if(nums[mid] < nums[r]){
                //if target is greater thahn mid and smaller than r edge
                //then it located between mid and r
                if(target > nums[mid] && target < nums[r]) l = mid+1;
                //Else it will be located between l and mid
                else r = mid -1;
                //This is not regular sorted order
            }else if(nums[mid] > nums[r]){
                //if target greater than l edge and smaller than mid point, then it located between l and mid
                if(target > nums[l] && target < nums[mid]) r = mid -1;
                //else it located between mid and r
                else l = mid +1;
            }
            //else should be move one index to the left
            else r--;
        }
        return false;
    }
}
