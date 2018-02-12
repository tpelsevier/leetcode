//Time O(N^2) space O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] S = new int[nums.length];
        S[0] = 1;
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            S[i] = 1;
            for(int j = 0;j<i;j++){
                 if(nums[i] > nums[j]){
                    S[i] = Math.max(S[i],S[j] +1); //Coapre S[i] steps + 1 with S[i]
                 }
            }
            max = Math.max(S[i],max);//Comapre the S[i] with the current max
        }
        return max;
    }
}
