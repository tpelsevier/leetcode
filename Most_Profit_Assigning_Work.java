//Time O(NlogN) Space O(N)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        for(int i =0; i < profit.length;i++){
            pq.offer(new int[]{difficulty[i],profit[i]});
        }
        Arrays.sort(worker);
        int total = 0, max = 0;
        for(int w: worker){
            while(!pq.isEmpty() && pq.peek()[0] <= w){
                max = Math.max(pq.poll()[1],max);
            }
            total += max;
        }
        return total;
    }
}
