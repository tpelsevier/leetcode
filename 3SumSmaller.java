//Time: O(NLogN) Space O(1)
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int s = i+1,e = nums.length-1;
            while(s<e){
                if(nums[i]+nums[s]+nums[e]<target){
                  count += e-s; //Add up how many combos there between the end index and start index
                  s++;
                }else e--;
            }

        }
        return count;
    }
}
