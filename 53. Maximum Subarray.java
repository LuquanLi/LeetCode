    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int result = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(result < 0){
                result = nums[i];
            }else{
                result += nums[i];
            }
            max = Math.max(result, max);
        }

        return max;
    }