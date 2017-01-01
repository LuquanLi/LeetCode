  //time out
   public int combinationSum41(int[] candidates, int target) {
        int[] count = {0};
        if(candidates == null || candidates.length == 0) return count[0];

        dfs(candidates, target, new ArrayList<>(), count);
        return count[0];
    }

    private void dfs(int[] nums, int target, List<Integer> list, int[] count){
        if(target == 0){
            count[0] ++;
            return;
        }

        for(int j = 0; j < nums.length; j ++){
            if(nums[j] > target) continue;
            List<Integer> templist = new ArrayList<>(list);
            templist.add(nums[j]);
            dfs(nums, target - nums[j], templist, count);
        }
    }
    
    //time out
    public int combinationSum42(int[] candidates, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                res += combinationSum4(candidates, target - candidates[i]);
            }
        }
        return res;
    }
    
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }
    
    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }