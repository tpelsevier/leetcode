//Time O(NlogN) space O(N)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target == startFuel) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int dis = startFuel;
        int index = 0, n = stations.length;
        while(index < n && stations[index][0] <= dis) {
            //Offer the stations that are in the distance the start point can reach
            pq.offer(stations[index][1]);
            index++;
        }
        int res = 0;
        while(dis < target && !pq.isEmpty()) {
            dis += pq.poll();
            res++;
            while(index < n && stations[index][0] <= dis) {
                pq.offer(stations[index][1]);
                index++;
            }
        }
        if(dis >= target) return res;
        return -1;

    }
}
