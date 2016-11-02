    //https://leetcode.com/articles/rotate-array/
    //1. brute force
    //2. this one, use another array
    //3. reverse array: {1,2,3,4,5,6,7} -> {7,6,5,4,3,2,1} -> reverse first k -> {5,6,7,4,3,2,1} -> reverse n-k -> {5,6,7,1,2,3,4,}
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        k = k % n;

        for (int i = 0; i < k; i ++){
            result[i] = nums[n - k + i];
        }

        for(int i = k; i < n; i ++){
            result[i] = nums[i - k];
        }

        for(int i = 0; i < n; i ++){
            nums[i] = result[i];
        }
    }