//Time O(N) Space O(N)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] c = new int[cost.length];//Record the minium of each step
        c[0] = cost[0]; //Whether start 0 or one
        c[1] = cost[1];
        for(int i = 2;i<c.length;i++){
            c[i] = Math.min(c[i-1],c[i-2]) + cost[i];
        }
        //If the cost  == 2 compare the first two index
        //Otherwise compare last two steps
        return cost.length <=2? Math.min(cost[0],cost[1]):Math.min(c[c.length-1],c[c.length-2]);
    }
}
