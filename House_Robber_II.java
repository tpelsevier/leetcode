/*
  Since all the houses are formed in to a circle
  So if we rob house 0 we can't rob last house
  if we rob house 1 we can rob last house
*/
//Time O(N) Space O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    private int rob(int[] nums, int l, int h){
        int prevN = 0;
        int prevY = 0;
        for(int i = l;i<h;i++){
            int temp = prevY;
            prevY = prevN + nums[i];
            prevN = Math.max(temp,prevN);
        }
        return Math.max(prevN,prevY);
    }
}
