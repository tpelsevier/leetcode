//Time O(N^2) Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(new ArrayList<Integer>(),nums,0);
        return res;
    }
    private void helper(List<Integer> ls, int[] nums,int start){
        res.add(new ArrayList<>(ls));
        for(int i = start; i < nums.length;i++){
            ls.add(nums[i]);
            helper(ls,nums,i+1);
            ls.remove(ls.size()-1);
        }
    }
}
