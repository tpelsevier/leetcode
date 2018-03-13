//Time O(N) Space O(N)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2,sum2 = 0;
        int[] res = new int[2];
        int[] rep = new int[nums.length+1];
        for(int i = 0; i<n;i++){
            sum2+=nums[i]; //get the sum of total in the nums
            if(rep[nums[i]] == 0) rep[nums[i]]++;
            else res[0] = nums[i];
        }
        res[1] = sum-(sum2-res[0]); //sum2 -minus duplicate to see the diff with the original sum
        return res;
    }
}
