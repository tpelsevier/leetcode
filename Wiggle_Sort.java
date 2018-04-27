//Time O(N) Space O(1)
class Solution {
    public void wiggleSort(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            int a = nums[i-1];
            //If i in odd index if last index is greater than current index swap
            //If i in even index if last Index samller than current index swap
            if ((i%2 == 1) == (a > nums[i])) {
                nums[i-1] = nums[i];
                nums[i] = a;
            }
        }
    }
}
