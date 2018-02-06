//Time O(2^N) Space O(N)
/*
  123
  1,
  1,2
  1,2,3
  1,3
  2
  2,3
  3
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        helper(new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<Integer> ls,int[] nums, int p){
        res.add(new ArrayList<>(ls));
        for(int i = p; i<nums.length;i++){
            ls.add(nums[i]);
            helper(ls,nums,i+1);
            ls.remove(ls.size()-1); //Remove element used in the same posistion
        }
    }
}
