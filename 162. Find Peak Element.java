	public int findPeakElement1(int[] nums) {
        if(nums.length == 1) return 0;

        for(int i = 0; i < nums.length; i ++){
            if((i == 0 && nums[i] > nums[i + 1]) ||
               (i == nums.length - 1 && nums[i] > nums[i - 1]) ||
               (i - 1 >= 0 && nums[i] > nums[i - 1] && i + 1 < nums.length && nums[i] > nums[i + 1]))
            return i;
        }

        return 0;
    }
    
    public int findPeakElement2(int[] nums) {
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] < nums[i-1]){
                return i-1;
            }
        }
        return nums.length-1;
    }
    
    public int findPeakElement(int[] nums) {
        return findPeakElementHelper(nums, 0, nums.length - 1);
    }
    
    public int findPeakElementHelper(int[] nums, int low, int high){
        if(low == high){
            return low;
        }else{
            int mid1 = low + (high - low)/2;
            int mid2 = mid1 + 1;
            if(nums[mid1] > nums[mid2]){
                return findPeakElementHelper(nums, low, mid1);
            }else{
                return findPeakElementHelper(nums, mid2, high);
            }
        }   
    }