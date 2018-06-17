class ExamRoom {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int n;
    public ExamRoom(int N) {
        n = N;
    }
    //Time LogN
    public int seat() {
        if(pq.size() == 0) {
            pq.offer(0);
            return 0;
        }
        //New a priority queue so we can loop through by order
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(pq);
        int prev = -1, max = -1,res = 0;
        while(!pq2.isEmpty()){
            Integer next = pq2.poll();
            if(prev != -1) {
                int dis = (next - prev)/2;
                if(max < dis){
                    res = prev + dis;
                    max = dis;
                }
            }else{
                max = next;
            }
            prev = next;
        }
        if(n - prev -1 > max) res = n-1;
        pq.offer(res);
        return res;
    }
    //Time O(N)
    public void leave(int p) {
        pq.removeIf(x -> x == p);
    }
}
