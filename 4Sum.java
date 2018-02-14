//Time O(N^3) space O(1)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n-3;i++){
            //If the unused smallest combo is bigger than target then return result
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) return res;
            if(nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
            int f = nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1;j<n - 2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int s = nums[j];
                int t = j+1,fo = n-1;
                while(t < fo){
                    int sum = f+s+nums[t] + nums[fo];
                    if(sum == target){
                        res.add(new ArrayList<>(Arrays.asList(f,s,nums[t],nums[fo])));
                        while(t<fo && nums[++t] == nums[t-1]);
                        while(t<fo && nums[--fo] == nums[fo+1]);
                    }else if (sum < target) t++;
                    else fo--;
                }
            }
        }
        return res;
    }
}
