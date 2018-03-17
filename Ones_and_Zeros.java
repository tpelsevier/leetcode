//Time (KL + kmn) space O(MN)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int[] count = count(s);
            for(int i = m ; i >= count[0]; i--){
                for(int j = n; j >= count[1]; j--){
                    //Check how many strings can be formed are there
                    // when used count[0] amount of 0 and count[1] amount 1
                    dp[i][j] = Math.max(1+dp[i-count[0]][j-count[1]],dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    private int[] count(String s){
        int [] res = new int[2];
        for(Character c: s.toCharArray()){
            res[c-'0']++;
        }
        return res;
    }
}
