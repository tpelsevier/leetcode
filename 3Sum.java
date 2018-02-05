//Time O(NLogN) Space 1
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i< nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue; //Skip the same value in the position 1
            int s = i+1, e = nums.length-1;
            while(s < e){
                int sum = nums[i]+nums[s]+nums[e];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[s],nums[e]));
                    s++;
                    e--;
                    while(s<e && nums[s-1] == nums[s]) s++; //Skip same value in the position 2
                    while(s<e && nums[e+1] == nums[e]) e--; //Skip same value in the position 3
                }
                else if(sum < 0) s++;
                else e--;

            }
        }
        return res;
    }
}
