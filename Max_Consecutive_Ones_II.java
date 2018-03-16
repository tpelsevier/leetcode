//Time O(N) Space O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            int count = 0, zero = 0,zeroIndex = -1;
            inner:while(i < nums.length){
                if(nums[i] == 0){
                    if(zero == 1)break inner; //If we already include one zeros in there breka the while loop
                    else{
                        zero++;
                        zeroIndex = i;
                    }
                }
                count++;
                i++;
            }
            max =Math.max(count,max);
            if(zeroIndex!=-1)i = zeroIndex;

        }
        return max;
    }
}
