//Time (M*N) Space O(M*N)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix == null) return 0;
        int n = matrix.length, m = matrix[0].length, max = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1; j <=m;j++){
                if(matrix[i-1][j-1] == '1'){
                    //Find the shortest side
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
