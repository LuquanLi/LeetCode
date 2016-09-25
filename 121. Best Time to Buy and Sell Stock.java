    //1. min := maintain the current min from prices[0] to prices[i-1], max revenue is from prices[i] - min; update result; update min
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int result = 0, min = prices[0];

        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > min){
                result = Math.max(prices[i] - min, result);
            }else {
                min = prices[i];
            }
        }

        return result;
    }

    //2. Max subarray, find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }