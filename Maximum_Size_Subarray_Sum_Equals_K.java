//Time O(N) Space O(N)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for(int i = 0; i < nums.length;i++){
            sum+=nums[i];
            if(sum == k) max = i+1;
            //If there is a sum -k, so from the next index of sum-k to i will be the subarray length
            else if (map.containsKey(sum-k)) max = Math.max(max,i-map.get(sum-k));
            //Using the further one to get the longest subarray length
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }
}
