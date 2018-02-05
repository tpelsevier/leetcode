//Time: O(NLogN) Space O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int val = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 0;i< nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue; //Skip the same value in the position 1
            int s = i+1, e = nums.length-1;
            while(s < e){
                int sum = nums[i]+nums[s]+nums[e];
                if(sum == target) return target;
                else if(sum < target)s++;
                else e--;
                int tempD = Math.abs(target-sum); //Current difference
                if(diff > tempD){
                    diff = tempD;
                    val = sum;
                }
            }
        }
        return val;
    }
}
