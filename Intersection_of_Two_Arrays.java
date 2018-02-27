//Time O(N) Space O(N)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for(int i = 0; i< nums2.length;i++){
            set.add(nums2[i]);
        }
        for(int i = 0;i<nums1.length;i++){
            if(set.contains(nums1[i])) inter.add(nums1[i]);
        }
        int[] res = new int[inter.size()];
        int i =0;
        for(Integer in: inter){
            res[i++] = in;
        }

        return res;
    }
}
