//Time O(N) Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList<>(),new boolean[nums.length],nums);
        return res;
    }
    private void helper(List<Integer> ls, boolean[] used, int[] nums){
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]) continue;
            //nums[i] == nums[i-1] to see if current index has been used same value
            //used [i-1] means that checks descending order
            if((i>0 && nums[i] == nums[i-1])&&used[i-1]) continue;
            ls.add(nums[i]);
            used[i] = true;
            helper(ls,used,nums);
            used[i] = false;
            ls.remove(ls.size()-1);
        }
    }
}
