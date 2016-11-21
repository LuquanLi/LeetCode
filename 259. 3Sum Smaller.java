	//1. three for loop
    //2. three pointer
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;

        //sort
        Arrays.sort(nums);

        int count = 0;

        //three pointers i j k
        for(int i = 0 ; i < nums.length - 2; i ++){
            int j = i + 1, k = nums.length - 1;

            while (j < k){
                if(nums[i] + nums[j] + nums[k] < target){
                    count += k - j;
                    j ++;
                }else {
                    k --;
                }
            }

        }

        return count;
    }