//Time O(NK^2) space O(1)
class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs == null) return 0;
        int m = costs.length, n = costs[0].length;
        for(int i = 1; i < m ;i++){
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE;
                for(int f = 0; f<n;f++){
                    if(f == j) continue;
                    min = Math.min(min, costs[i-1][f]); //FIND THE MINUM OF COST FOR CURRENT POSITION
                }
                costs[i][j] += min;
            }
        }
        int cost = Integer.MAX_VALUE;
        for(int j = 0;j<n;j++){
            cost = Math.min(costs[m-1][j],cost);
        }
        return cost;
    }
}
//Time O(NK) Space O(1)
//The idea of this solution find the min cost and second min of the prev house
//Curr house in i color which has been used previous as min cost plus the second min previous
//Rest of color plus the min cost of the sum up to previous house 
class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs == null) return 0;
        int m = costs.length, n = costs[0].length;
        int preMin = 0, preMin2 = 0, preMinIndex = -1;
        for(int [] cost: costs){
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,minIndex = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                int curr = cost[j];
                if(preMinIndex == j){
                    curr += preMin2;
                }else curr += preMin;

                if(curr < min1){
                    min2 = min1;
                    min1 = curr;
                    minIndex = j;
                }else if(curr < min2) min2 = curr;
            }
            preMin = min1;
            preMin2 = min2;
            preMinIndex = minIndex;
        }

        return preMin;
    }
}
