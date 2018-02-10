//Time O(N) space O(1)
class Solution {
    public int dominantIndex(int[] nums) {
        Integer m1=null,m2 = null;//find largest and second largest
        int index = -1;
        for(int i = 0;i<nums.length;i++){
            if(m1 == null || nums[i]>m1) {
                index = i;
                m2 = m1;
                m1 = nums[i];
            }else if(m2 == null || nums[i] > m2) m2 = nums[i];
        }
        /*m2 == null means if the array only contains one element
        If m1 is twice larger than m2, then return the index of largest*/
        return m2 == null||m1 >= m2*2? index:-1;
    }
}
