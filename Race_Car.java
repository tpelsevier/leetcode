//0 -> 1 -> 3 -> 7
//     A    R    R    A
//0 -> 1 -> 1 -> 1 -> 2
class Solution {
    int[] dp = new int[10001];
    public int racecar(int t) {
        if(dp[t] > 0) return dp[t];
        int n = (int) (Math.log(t)/Math.log(2))+1;
        if(1 << n == t+1) dp[t] = n;
        else{
            //Since 2^n > target, it is gonna be reverse
            //(1 << n) - 1 means the curr index which is greter than target, since 2^n -1
            // -t means distance from curr index to target
            //+n means n steps has driven +1 means one stop required to do reverse
            dp[t] = racecar((1<<n)-1-t)+n+1;
            //The pos is before the target
            //Take i steps of A to get to target
            //If car need to drive forward again, it needs reverse back to forward mode
            //So we need one more in there
            for(int i = 0; i < n-1;i++) {
                dp[t] = Math.min(dp[t],racecar(t-(1<<(n-1))+(1 << i))+i+n+1);
            }
        }
        return dp[t];
    }
}
