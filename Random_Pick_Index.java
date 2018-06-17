//Time O(N) Space O(1)
class Solution {
    int[] nums;
    int n;
    Random r = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        n = nums.length;
    }

    public int pick(int target) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < n;i++){
            if(nums[i] == target) ls.add(i);
        }
        int index = r.nextInt(ls.size());
        return ls.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
