// ()() (())
//Time O(N) Space O(N)
class Solution {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int len = s.length(),max = 0;
        int[] dp = new int[len];
        for(int i = 1; i< s.length();i++){
            if(cs[i] == ')'){
                if(cs[i-1] == '(') dp[i] = 2+(i>1?dp[i-2]:0);
                else if(i >= dp[i-1]+1 && cs[i-dp[i-1]-1] == '(') dp[i] = dp[i-1]+2+(i >= dp[i-1]+2? dp[i-dp[i-1]-2] :0);
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
}
