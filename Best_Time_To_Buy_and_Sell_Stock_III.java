//Time O(N) Space O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int buy1= Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int p: prices){
            buy1 = Math.max(buy1,-p); //First buy, we owe money
            sell1 = Math.max(sell1, buy1+p); // First sell we got money, and buy1+p
            buy2 = Math.max(buy2,sell1-p); //Second buy we used the profit we got from sell1 to buy
            sell2 = Math.max(sell2,buy2+p); //Second sell equals to the profit we gain + p
        }
        return sell2;
    }
}
//Time O(N) Space O(N)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)  return 0;
        int[] profit = new int[prices.length];
        for(int k=0; k<2; k++) {
            int maxBuy = -prices[0]; //Always borrow money
            for(int i=1; i<prices.length; i++) {
                int tmp = profit[i]; //Store the current profit in index of I
                //Compare the profit of the privous profit and current profit if sold in this position
                profit[i] = Math.max(profit[i-1], maxBuy + prices[i]);
                //Check for the lower prices
                maxBuy = Math.max(maxBuy, tmp - prices[i]);
            }
        }
        return profit[prices.length - 1];
    }
}
