// Time O(NlogN) space O(N)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)) map.put(num,map.get(num) + 1);
            else map.put(num,1);
        }
        //Sort by frequent first, if frequent equals sort in order
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue()?a.getKey() - b.getKey():b.getValue()-a.getValue());
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> en = (Map.Entry<Integer,Integer>)it.next();
            q.add(en);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty() && k-- > 0){
            res.add(q.poll().getKey());
        }
        return res;
    }
}

//Time O(N) Space O(N)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(Map.Entry<Integer,Integer> set: map.entrySet()) {
            int fre = set.getValue();
            if(bucket[fre] == null) bucket[fre] = new ArrayList<>();
            bucket[fre].add(set.getKey());
        }
        List<Integer> ls = new ArrayList<>();
        int n = nums.length+1;
        while(n--> 0 && ls.size() < k){
            if(bucket[n] == null) continue;
            for(int ne: bucket[n]) {
                ls.add(ne);
                if(ls.size() == k) return ls;
            }
        }
        return ls;
    }
}
