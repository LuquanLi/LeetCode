    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        
        for(int i = 1; i < nums.length; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
    
    //https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }