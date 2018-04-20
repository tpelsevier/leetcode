//Time (N^2) SPACE o(N)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return false;
        if(k == 1) return true;
        int sum = 0;
        for(int n: nums) sum+=n;
        if(sum % k != 0) return false;
        return helper(nums,new int[nums.length],0,0,0,sum/k,k);
    }
    private boolean helper(int[] nums,int[] visted, int start, int curr_num,int curr_sum,int target,int k){
        //Because we never used duplicated value, if there are already k-1 combos which have sum equals to target
        //So the sum remaining values of unvisted element will be the target 
        if(k == 1) return true;
        if(curr_sum == target && curr_num > 0) return helper(nums,visted,0,0,0,target,k-1);
        for(int i = start;i<nums.length;i++){
            if(visted[i] == 0){
                visted[i] = 1;
                if(helper(nums,visted,i+1,curr_num+1,curr_sum+nums[i],target,k))return true;
                visted[i] = 0;
            }
        }

        return false;
    }
}
