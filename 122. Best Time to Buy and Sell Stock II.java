    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int price = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(price < prices[i]){
                //sell
                profit += prices[i] - price;
            }
            //buy
            price = prices[i];
        }

        return profit;
    }