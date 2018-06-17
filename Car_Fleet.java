//Time O(LogN) Space O(N)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Sort who is closer to the destiation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int n = position.length;
        for(int i = 0; i < n;i++){
            pq.offer(new int[]{position[i],speed[i]});
        }
        int count = 0;
        while(!pq.isEmpty()){
            count ++; //There is no car can fleet
            int[] car1 = pq.poll();
            while(!pq.isEmpty()){
                int[] car2 = pq.poll();
                //If the speed is less in car2 which is behind car1 at the original position
                if(car2[1] < car1[1]){
                    pq.offer(car2);
                    break;
                }else{
                    double st1 = ((double)target - car1[0])/car1[1];
                    double st2 = ((double)target - car2[0])/ car2[1];
                    //If cars2 (behind) takes more steps than break
                    if(st2 > st1) {
                        pq.offer(car2);
                        break;
                    }
                }
            }
        }
        return count;
    }
}
