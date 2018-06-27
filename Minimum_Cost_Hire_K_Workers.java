//TIme O(NlogN) Space O(N)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = wage.length;
        Worker[] workers = new Worker[n];
        for(int i = 0; i < n; i ++){
            workers[i] = new Worker(quality[i],wage[i]);
        }
        //Sorts the worker by its ratio, first K-1 ratios is never going to used
        Arrays.sort(workers);
        double min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        double sumQ = 0;
        for(Worker worker: workers){
            sumQ += worker.quality; //Get the quality sum of the ratio is greater than current worker
            pq.offer(-worker.quality);
            if(K < pq.size()){
                sumQ += pq.poll(); //Minus the worker that has highest quality in the queue
            }
            if(K == pq.size()){
                min = Math.min(min, worker.ratio * sumQ); //Since the current worker has the highest the quality, just times to the quality
            }
        }
        return min;
    }

    class Worker implements Comparable<Worker> {
        int quality;
        int wage;
        double ratio;
        public Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage/quality;
        }
        public int compareTo(Worker other){
            return Double.compare(this.ratio, other.ratio);
        }

    }
}
