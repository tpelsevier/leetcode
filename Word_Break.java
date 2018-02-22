//Time O(N^2) Space O(N)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length();i++){
            for(int j = 0; j < i ; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){ dp[i] = true; break;}
            }
        }
        return dp[s.length()];
    }
}
//Time O(NLogN) space O(N)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0; i <n;i++){
            if(dp[n]) return true; //Since it satisified
            if(!dp[i]) continue; // if dp[i] is not true means it either in between chars of a word
            for(int j = i+1;j<=n;j++){
                if(wordDict.contains(s.substring(i,j))){
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
