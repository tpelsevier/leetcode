//Time O((m+n)^3) Space O(N)
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[k];
        if(m + n < k) return res;
        for(int i = Math.max(0,k-m); i <= k && i <= n; i++){
           //Get max array for i and k-i respectively for nums1 and nums2
            int[] temp = merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
            if(greater(temp,0,res,0)) res = temp; //Compare the temp to the current res to see if its bigger
        }
        return res;
    }
    //Merge two array into res array
    private int[] merge(int[] nums1, int[] nums2, int k){
        int[] res = new int[k];
        for(int i = 0, j = 0,r = 0;r < k;r++){
            res[r] = greater(nums1,i,nums2,j)?nums1[i++]:nums2[j++];
        }
        return res;
    }
    //Compare two array to see who is bigger
    private boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i<nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i<nums1.length && nums1[i] > nums2[j]);
    }
    //Max array from the
    private int[] maxArray(int[] nums,int k){
        int[] res = new int[k];
        int n = nums.length;
        for(int i = 0, j = 0; i< n;i++){
            //To see if j minus there still have enough nums to fill res array
            while(n-i > k-j && j > 0 && nums[i] > res[j-1]){
                j--;
            }
            if(j < k) res[j++] = nums[i];
        }
        return res;
    }
}
