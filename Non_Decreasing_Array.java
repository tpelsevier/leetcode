//Time O(N) Space O(1)
/*Example
  3,4,2,3
  since nums[2] < nums[0] nums[2] = nums[1]
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean found = false;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] < nums[i-1]){
                if(found) return false;
                else{
                    if(i-2 >= 0 && nums[i] < nums[i-2]) nums[i] = nums[i-1];
                    found = true;
                }
            }
        }
        return true;
    }
}
