class Solution {
    public int maxProfit(int[] prices) {
        int min = 0;
        int res = 0;
        for(int max = 1; max < prices.length; max++){
            if(prices[max-1] < prices[min]){
                min = max-1;
            }
            if(res < prices[max] - prices[min]){
                res = prices[max] - prices[min];
            }
        }

        return res;
    }
}