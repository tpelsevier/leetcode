//Time O(KLogN) Space O(K) 
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]+a[1])-(b[0]+b[1]));
        for(int i = 0; i< nums1.length && i < k;i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }
        while(!pq.isEmpty() && res.size() < k){
            int[] curr = pq.poll();
            res.add(new int[]{curr[0],curr[1]});
            if(curr[2] == nums2.length-1) continue;
            pq.offer(new int[]{curr[0],nums2[curr[2]+1],curr[2]+1});
        }
        return res;
    }
}
