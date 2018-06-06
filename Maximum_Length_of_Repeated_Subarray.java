/*
1,2,3,2,1
3,2,1,4,7
dp[i][j] = dp[i+1][j+1]+1;
because i and j equals so we need to make sure j + 1 is equals to i +1
0 0 0 0 0 0
0 0 0 0 0 0
3 0 0 0 0 0
0 2 0 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0

*/

//Time O(N^2) Space O(1)
class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int n = A.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(A[i] == B[j]){

                    dp[i][j] = dp[i+1][j+1]+1;
                    ans = Math.max(dp[i][j],ans);
                }
            }
        }
        return ans;
    }
}
