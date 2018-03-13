//Time O(N) Space O(N)
//Formula dp [i] = dp[i-1] * 2 + dp[i-3]
class Solution {
    public int numTilings(int N) {
        if(N<2) return 1;
        int[] dp = new int[N+1];
        int mod = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=N;i++){
            dp[i] = (dp[i-1] * 2 % mod)+ dp[i-3];
            dp[i] %= mod;
        }
        return dp[N];
    }
}

//Time O(N) Space O(1)
class Solution {
    public int numTilings(int N) {
        if(N<2) return 1;
        int mod = 1000000007;
        int a = 1;
        int b = 1;
        int c = 2;
        for(int i = 3; i<=N;i++){
            int temp = b;
            b = c;
            c = (c*2%mod)+a;
            c%=mod;
            a=temp;
        }
        return c;
    }
}
