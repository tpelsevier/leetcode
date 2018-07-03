//Time O(N) Space O(N)

class Solution {
    /*
        Try to buy stock from lowest point which is assign to hold
        maximaize cash - curr price
        
        Cash means how much we are earning
    */
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0]; //Money holding in hand
        int cash = 0; //How much earning total
        for(int i = 1; i < prices.length;i++){
            cash = Math.max(cash,hold+prices[i]-fee);
            hold = Math.max(hold,cash-prices[i]);
        }
        return cash;
    }
}
