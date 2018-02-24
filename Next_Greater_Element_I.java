//Time O(N) space O(N)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        out: for(int i = 0; i <n; i++){
            int index = map.get(nums1[i]) +1;
            for(;index<nums2.length;index++){
                if(nums1[i] < nums2[index]){
                    res[i] = nums2[index];
                    continue out;
                }
            }
            res[i] = -1;
        }
        return res;
    }
}
