    //1. two for loop, O(n^2) time
    //2. total: multiply all, then devide, O(n) time, con: might overflow
    //3. calculate the result of first result: result[2] = result[1] * num[2] / num[1], con: should consider 0 when divide. When num[1] is 0, result[2] also 0
    //4. ex: [a b c d] -> [1 a ab abc] and [bcd cd d 1] -> multiply them, O(n) time
    
    public int[] productExceptSelf(int[] nums) {
        if(nums == null) return null;

        int[] result = new int[nums.length];
        result[0] = 1;

        for(int i = 1; i < nums.length; i ++){
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for(int i = nums.length - 2; i >= 0; i --){
            right *= nums[i + 1];
            result[i] *= right;
        }

        return result;
    }