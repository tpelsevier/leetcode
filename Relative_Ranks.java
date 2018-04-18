//Time O(N) Space O(N)
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if(nums.length == 0 || nums == null) return new String[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        String[] res = new String[nums.length];
        for(int i = nums.length-1,j = 1; i >= 0;i--,j++){
            int id = map.get(nums[i]);
            if(j == 1) res[id] = "Gold Medal";
            else if(j == 2) res[id] = "Silver Medal";
            else if(j == 3) res[id] = "Bronze Medal";
            else res[id] = String.valueOf(j);
        }
        return res;

    }
}
