/*
TreeSet  1 3 7 12
  num: 8
  8 < floor 8 +2
  8-2< ceil < 8
*/

//Time O(NLogN) Space O(K)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<Long>(){{
            add((long)nums[0]);
        }};
        for(int i = 1; i < nums.length; i++){
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] -t);
            if((floor != null && floor >= nums[i])||
               (ceil != null && ceil <= nums[i])) return true;
            set.add((long)nums[i]);
            if(i >= k) set.remove((long)nums[i-k]);
        }
        return false;
    }
}
//Time O(N) Space O(Math.min(N,K))
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        int n = nums.length;
        Map<Long,Long> map = new HashMap<>();
        for(int i = 0; i < n;i++){
            long id = getId((long)nums[i],t+1);
            if(map.containsKey(id)) return true;
            //Check neightbor bucket
            if ((map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < t+1)
                || map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < t+1)
                return true;
            map.put(id,(long)nums[i]);
            if(i>=k)map.remove(getId(nums[i-k],t+1));
        }
        return false;
    }
    private long getId(long x, int w){
        return x < 0? x+1/w-1:x/w;
    }
}
