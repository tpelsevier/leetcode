//Time O(NLogN) Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(new ArrayList<>(),target,0,candidates);
        return res;
    }
    private void helper(List<Integer> ls, int remain, int start, int[] nums){
        if(remain < 0) return;
        if(remain == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = start;i<nums.length;i++){
            //Since nums[i] in this index has been used , so skip
            if(i > start && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            helper(ls,remain-nums[i],i+1,nums);
            ls.remove(ls.size()-1);
        }
    }
}
