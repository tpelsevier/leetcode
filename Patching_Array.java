//Time O(M+logN) Space O(1)
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0, i = 0;
        while(miss <= n){
            //See if missing number is at this stage cover the smallest number
            if(i < nums.length && nums[i] <= miss){
                miss+=nums[i++];
            }else{
                miss *= 2; //If no missing number should be add itself
                patches++; //Then we have a patches increase
            }
        }
        return patches;
    }
}
