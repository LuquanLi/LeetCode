    public int coinChange1(int[] coins, int amount) {
        if(amount < 1) return 0;
        return coinChangeHelper(coins, amount, new int[amount + 1]);
    }
    
    public int coinChangeHelper(int[] coins, int remain, int[] count){
        if(remain < 0) return -1;
        if(remain == 0) return 0;
        if(count[remain] != 0) return count[remain];
        
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int result = coinChangeHelper(coins, remain - coin, count);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }
        
        count[remain] = (min == Integer.MAX_VALUE) ? - 1 : min;
        return count[remain];
    }
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }