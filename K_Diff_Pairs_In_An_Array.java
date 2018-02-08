//Time O(N) Space O(N)
class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){ //Get the frequency of each number
            if(map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(k == 0){ //If the K is zero find elements appears twice
                if(entry.getValue() >= 2) count ++;
            }
            else {
                if(map.containsKey(entry.getKey()+k)) count++;
            }
        }
        return count;
    }
}
