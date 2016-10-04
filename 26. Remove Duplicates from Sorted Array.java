    public int removeDuplicate1s(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0 || nums.length == 1) return nums.length;

        int p = 0, q = 1;
        while(q < nums.length){
            if(nums[p] < nums[q]){
                nums[p + 1] = nums[q];
                p ++;
            }
            q ++;
        }

        return p + 1;
    }
    
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }