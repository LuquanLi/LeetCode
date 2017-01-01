   //Like 442, 448
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        for(int i = 0; i < nums.length; i ++){
            mark(nums, nums[i]);
        }

        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > Integer.MIN_VALUE) return i + 1;
        }

        return nums.length + 1;
    }

    public void mark(int[] nums, int value){
        if(value - 1 >= 0 && value - 1 < nums.length){
            int temp = nums[value - 1];
            nums[value - 1] = Integer.MIN_VALUE;
            mark(nums, temp);
        }
    }