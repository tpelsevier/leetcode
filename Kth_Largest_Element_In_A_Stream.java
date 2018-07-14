//Time O(LogK) Space O(K)
class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums) add(n);
    }

    public int add(int val) {
        int size = pq.size();
        if(size >= k){
            if(val > pq.peek()){
                pq.poll();
                pq.offer(val);
            }
        }else{
            pq.offer(val);
        }

        return pq.peek();
    }
}
