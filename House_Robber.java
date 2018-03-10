//Time O(N) Space O(1)
class Solution {
    public int rob(int[] nums) {
        int prevY = 0;
        int prevN = 0;
        for(int n:nums){
           // Store the value if we did not steal previous house
            int temp = prevN;
            //So we do not steal current house, we can assign prevN to whichever bigger value
            prevN = Math.max(prevN,prevY);
            //Prev value will be equal to the current value plus the value we did not steal the previous house
            prevY = temp+n;
        }

        return Math.max(prevY,prevN);
    }
}
