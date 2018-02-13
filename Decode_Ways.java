//Time O(N) space O(N)
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s == null) return 0;
        int[] dp = new int[s.length()+1];
        dp[dp.length-1] = 1;
        dp[dp.length-2] = s.charAt(s.length()-1) == '0'?0:1;
        for(int i = s.length()-2;i>=0;i--){
            //if current char equals to 0 continue
            if(s.charAt(i) !='0') dp[i] = Integer.parseInt(s.substring(i,i+2)) >26? dp[i+1]:dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
}
