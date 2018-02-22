//Brute Force O(2^N) space O(N) *Not recommend
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        cal(nums,0,0,S);
        return count;
    }
    private void cal(int[] nums, int p, int sum, int target){
        if( p == nums.length){
            if(sum == target) count ++;
        }else{
            cal(nums,p+1,sum-nums[p],target);
            cal(nums,p+1,sum+nums[p],target);
        }
    }
}
//Time O(N*L) space O(N*L)
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        HashMap <Integer,Integer> re = new HashMap<>();
        re.put(-nums[0],1);
        if(re.containsKey(nums[0]))re.put(nums[0],re.get(nums[0])+1);
        else re.put(nums[0],1);
        map.put(0,re);
        for(int i = 1; i < nums.length;i++){
            HashMap<Integer,Integer> last = map.get(i-1);
            HashMap<Integer,Integer> curr = new HashMap<>();
            for(Map.Entry<Integer,Integer> l: last.entrySet()){
                int res = l.getKey();
                int freq = l.getValue();
                curr.put(res+nums[i],curr.getOrDefault(res+nums[i],0)+freq);
                curr.put(res-nums[i],curr.getOrDefault(res-nums[i],0)+freq);
            }
            map.put(i,curr);
        }
        return map.get(nums.length-1).getOrDefault(S,0);
    }
}
//Time O(L*N) Space O(N)
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(-nums[0],1);
        map.put(nums[0],map.getOrDefault(nums[0],0)+1);
        for(int i = 1; i < nums.length;i++){
            HashMap<Integer,Integer> curr = new HashMap<>();
            for(Integer key: map.keySet()){
                int freq = map.get(key);
                curr.put(key+nums[i],curr.getOrDefault(key+nums[i],0)+freq);
                curr.put(key-nums[i],curr.getOrDefault(key-nums[i],0)+freq);
            }
            map = curr;
        }
        return map.getOrDefault(S,0);
    }
}
//Time O(N) space O(sum(L))
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return  sum < S || (sum + S) % 2 != 0 ? 0 : helper(nums, (sum + S) / 2);
    }
    private int helper(int[] nums, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int n: nums){
            for(int i = sum; i >=n;i--){
                dp[i] += dp[i-n];
            }
        }
        return dp[sum];
    }
}
