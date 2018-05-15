//Always move the middle point to the middle
//which is the head of both PriorityQueue
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minPQ ;
    PriorityQueue<Integer> maxPQ;
    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minPQ.add(num);
        maxPQ.add(minPQ.poll());
        if(minPQ.size() < maxPQ.size()){
            minPQ.add(maxPQ.poll());
        }
    }

    public double findMedian() {
        if(minPQ.size() == maxPQ.size()) return (minPQ.peek() + maxPQ.peek())/2.0;
        return minPQ.peek();
    }
}
