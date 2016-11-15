    /*
    case1:  0123456789   ->   left < mid < right                        0:left
    case2:  7890123456   ->   left > mid, mid < right, left < right     0:left
    case3:  3456789012   ->   left < mid, mid > right, left > right     0:right

    binary search
    */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;

        int l = 0, r = nums.length - 1;

        while (l < r){
            int m = l + (r - l)/2;
            int left = nums[l], right = nums[r], mid = nums[m];

            if(left <= mid && mid >= right && left >= right){
                l = m + 1;
            }else{
                r = m;
            }
        }
        return nums[l];
    }