//Time O(N) space O(N)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        boolean[] t = new boolean[nums.length];
        for(int i = 0; i < nums.length;i++){
            if(t[nums[i]-1]) res.add(nums[i]);
            t[nums[i] - 1]  = true;
        }
        return res;
    }
}
