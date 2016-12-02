    public int minCost1(int[][] costs) {
         //input validation
        if(costs == null || costs.length == 0) return 0;
        
        int len = costs.length;
        int[][] dp = new int[len][3];
        
        //initialize the dp, the house 0 can be color 0,1,2
        for(int i = 0; i < 3; i ++){
            dp[0][i] = costs[0][i];
        }
        
        for(int j = 1; j < len; j ++){
            //house 1 is color 0, house 1 color 0 cost + min cost of house 0 in color 1 or 2
            dp[j][0] = costs[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]); 
            dp[j][1] = costs[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
            dp[j][2] = costs[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
        }
        
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
    }
    
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }