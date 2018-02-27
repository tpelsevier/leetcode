// Time O(N+M) space O(N)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums1){
            map.put(i,map.getOrDefault(i,0)+1);//count the frequency
        }
        List<Integer> ls = new ArrayList<>();
        for(int i: nums2){
           //if map contains this key and freq in that array is greater than one then add to the list
            if(map.containsKey(i) && map.get(i) > 0){
                ls.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        int[] res = new int[ls.size()];
        int i = 0;
        for(Integer v :ls){
            res[i++] = v;
        }
        return res;
    }
}
