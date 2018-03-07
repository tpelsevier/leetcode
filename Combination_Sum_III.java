//Time O(N) Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(new ArrayList<>(),n,k,1);
        return res;
    }
    private void helper(List<Integer> ls,int n,int k,int start){
        if(ls.size() == k){
            if(n == 0) {
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        for(int i = start;i<=9;i++){
            ls.add(i);
            helper(ls,n-i,k,i+1);//this value can't be reused
            ls.remove(ls.size()-1);
        }
    }
}
