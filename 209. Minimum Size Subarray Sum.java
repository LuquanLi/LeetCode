    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0 || s <= 0) return 0;

        int i = 0, j = 0, sum = nums[0], result = Integer.MAX_VALUE;

        while (j < nums.length){
            if (sum >= s){
                result = Math.min(result, j - i + 1);
                i ++;
                sum -= nums[i - 1];
            }else{
                j ++;
                if(j < nums.length) sum += nums[j];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }