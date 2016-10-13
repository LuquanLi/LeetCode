 	public int missingNumber(int[] nums) {
        //0 + 1 + 2 + ... + n: 一个等差数列的和等于其首项与末项的和乘以项数除以2
        long total = (0 + nums.length) * (nums.length + 1) / 2, total2 = 0;
        
        for (int i = 0; i < nums.length; i ++){
            total2 += nums[i];
        }
        
        return (int) (total - total2);
    }