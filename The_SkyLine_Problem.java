class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int [] b: buildings){
            height.add(new int[]{b[0],-b[2]});
            height.add(new int[]{b[1],b[2]});
        }
        //Sort the list by start point first,then the end point
        Collections.sort(height,(a,b) -> a[0] == b[0]?a[1]-b[1]:a[0]-b[0]);

        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
        p.offer(0);
        int prev = 0;
        for(int[] h: height){
            if(h[1] < 0) p.offer(-h[1]); //Since it's the start point, find the tallest point
            else p.remove(h[1]); //Since it's the end point, find the second tallest point
            int curr = p.peek(); // Peek the tallest point in the priority queue
            //If the tallest point is not equal to previous tallest point
            //If this point is the start point, it addes a new point, it might differ from prvious tallest point
            //If this point is the end point, it removes it's height from the queue,
            //if the height is not equals to the pre tallest height, that means it is the second tallest
            if(curr != prev){
                res.add(new int[]{h[0],curr}); //Put the tallest point
                prev = curr;
            }
        }
        return res;
    }
}
