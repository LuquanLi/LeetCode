    //1. Two pointers
    public void moveZeroes1(int[] nums) {
        if(nums == null || nums.length < 2) return;

        int i = 0, j = 1;
        while(i < nums.length && j < nums.length){
            if(nums[i] != 0){
                i ++;
                j = i + 1;
            }

            if(j < nums.length && nums[j] == 0){
                j ++;
            }

            if(i < nums.length && j < nums.length && nums[i] == 0 && nums[j] != 0){
                //swap
                int k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
            }
        }
    }
    
    //2. Shift non-zero value
    public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length < 2) return;
        
        int insert = 0;
        for(int num: nums){
            if(num != 0) nums[insert++] = num;
        }
        
        while(insert < nums.length){
            nums[insert ++] = 0;
        }
    }
    
    //3. Similiar as first
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }