//Time O(NLogN)  Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates , int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return res;
    }
    public void helper(int[] c, int remain, int start, List<Integer> ls){
        if(remain < 0 ) return;
        if(remain == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = start;i<c.length;i++){
            ls.add(c[i]);
            helper(c,remain-c[i],i,ls); //Since we can reuse the number
            ls.remove(ls.size()-1);
        }
    }
}
