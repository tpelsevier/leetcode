//Time O(N) Space O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        int first = nums[0], second = nums[0], countOne = 0, countTwo = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(first == nums[i]) countOne++;
            else if (second == nums[i]) countTwo++;
            else if(countOne == 0) {
                first = nums[i];
                countOne = 1;
            }
            else if(countTwo == 0) {
                second = nums[i];
                countTwo = 1;
            }
            else{
                countOne--;
                countTwo--;
            }
        }
        countOne = 0;
        countTwo = 0;
        for(int i = 0; i < n ; i++){
            if(nums[i] == first) countOne ++;
            if(nums[i] == second) countTwo ++;
        }
        if(countOne > n/3){
            res.add(first);
            if(first == second) return res;
        }
        if(countTwo > n/3){
            res.add(second);
        }
        return res;
    }
}
