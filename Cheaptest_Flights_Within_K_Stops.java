//Time (M+NlogN) SPace O(N)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        for(int[] flight: flights){
            if(!map.containsKey(flight[0])) map.put(flight[0],new ArrayList<>());
            map.get(flight[0]).add(new int[] {flight[1],flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        pq.offer(new int[]{0,src,K});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int price = curr[0], ori = curr[1], step = curr[2];
            if(ori == dst) return price;
            if(step >= 0 && map.containsKey(ori)){
                for(int[] next: map.get(ori)){
                    pq.offer(new int[]{price+next[1],next[0],step-1});
                }
            }
        }
        return -1;
    }
}
