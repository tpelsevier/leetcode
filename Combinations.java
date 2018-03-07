//Time O(NK) space O(1)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(new ArrayList<>(),n,k,1);
        return res;
    }
    private void helper(List<Integer> ls,int n,int k,int curr){
        if(ls.size() == k){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = curr;i<=n;i++){
            ls.add(i);
            helper(ls,n,k,i+1);
            ls.remove(ls.size()-1);
        }
    }
}
