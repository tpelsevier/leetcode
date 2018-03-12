//Time O(N) Space O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length;i++){
            sum+=nums[i]; // Sum  at current index
            count += map.getOrDefault(sum-k,0); // to see if there any occurence of the current sum minus target
            map.put(sum,map.getOrDefault(sum,0)+1); //Put the sum frequency in the map
        }
        return count;
    }
}
