//Time O(N！) space O(N)
class Solution{
    public List<List<Integer>> permutation(int [] nums){
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> ls, int[] nums){
        if(ls.size() == nums.length) {
          res.add(ls);
          return;
        }
        for(int i = 0;i<nums.length;i++){
          if(ls.contaiins(nums[i])) continue;
          ls.add(nums[i]);
          helper(res,ls,nums); // keep going until the ls size == nums length
          ls.remove(nums[i]); // Remove current number, and put the first number in there
        }
    }
}
class Solution2{
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> permutation(int [] nums){
      permuate(res,0,nums);
      return res;
  }
  private void permuate(int curr, int[] nums){
      if(curr == nums.length) {
        this.res.add(Arrays.asList(nums));
        return;
      }
      for(int i = curr;i<nums.length;i++){
          swap(curr,i,nums); //Swap the number for next step recursion to permuate
          permuate(curr+1,nums);
          swap(curr,i,nums); //Swap back to normal
      }
  }
  private void swap(int i,int j, int[] nums){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }

}
