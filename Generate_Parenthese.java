//Time O(2^N) space O(N)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,0,0,n,"");
        return res;
    }
    private void helper(List<String> res, int open,int close, int n,String curr){
        if(curr.length() == n*2){ // N pairs so the string length is twice as much as N
            res.add(curr);
            return;
        }
        if(open < n) helper(res,open+1,close,n,curr+"("); //If ( less than the number keep generating open
        if(close < open) helper(res,open,close+1,n,curr+")"); //If ) less than the ) generating close
    }
}
