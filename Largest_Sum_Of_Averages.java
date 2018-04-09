//Time O(Nk^2) Space O(N^2)
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double [][] dp = new double[N+1][N+1];
        double sum = 0;
        for(int i = 0; i < N; i++){
            sum+=A[i];
            dp[i+1][1] = sum / (i+1);
        }
        return search(N,K,dp,A);
    }
    private double search(int s, int k, double[][] dp, int[] A){
        if(dp[s][k] > 0) return dp[s][k]; //Means we only have one part left, so return the average in this part
        double sum = 0;
        for(int i = s-1;i > 0;i--){
            sum += A[i];
            dp[s][k] = Math.max(dp[s][k],search(i,k-1,dp,A)+ sum/(s-i));//Cut from the last index
        }
        return dp[s][k];
    }
}
