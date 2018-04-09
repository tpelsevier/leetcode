//Time O(N log N) Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(new ArrayList<>(), 0, nums);
        return res;
    }
    private void helper(List<Integer> ls,int start, int[] nums){
        if(ls.size() > 1) res.add(new ArrayList<>(ls));
        Set<Integer> used = new HashSet<>();
        for(int i = start; i < nums.length;i++){
            if(used.contains(nums[i]))continue;
            if(ls.size() == 0 || ls.get(ls.size()-1) <= nums[i]){
                used.add(nums[i]);
                ls.add(nums[i]);
                helper(ls,i+1,nums);
                ls.remove(ls.size()-1);
            }
        }
    }
}
