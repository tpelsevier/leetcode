//Time O(M+logN) Space O(1)
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0, i = 0;
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss+=nums[i++];
            }else{
                miss *= 2;
                patches++;
            }
        }
        return patches;
    }
}
