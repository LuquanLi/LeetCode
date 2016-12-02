public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] resultT = new int[nums.length];
        resultT[0] = resultT[1] = nums[0]; //take 0
        
        int[] resultN = new int[nums.length];
        resultN[0] = 0;
        resultN[1] = nums[1];
        
        for(int i = 2; i < nums.length; i ++){
            resultT[i] = Math.max(resultT[i - 1], resultT[i - 2] + nums[i]);
            resultN[i] = Math.max(resultN[i - 1], resultN[i - 2] + nums[i]);
        }
        
        return Math.max(resultT[nums.length - 2], resultN[nums.length - 1]);
    }