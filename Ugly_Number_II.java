//Time O(N) space O(1)
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int f1 = 2,f2 = 3,f3 = 5;
        int index1 = 0, index2 = 0,index3 =0;
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            int min = Math.min(Math.min(f1,f2),f3);
            dp[i] = min;
            //Times index1 +1  since 1 already took place in the begining.
            //  1 *2 1 * 3 1 * 5 already taken place
            if(min == f1) f1 = 2*dp[++index1];
            if(min == f2) f2 = 3*dp[++index2];
            if(min == f3) f3 = 5*dp[++index3];
        }
        return dp[n-1];
    }
}
