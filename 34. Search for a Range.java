    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] result = {-1, -1};

        //search for left
        while (i < j){
            int mid = (i + j) / 2;
            if(nums[mid] < target){
                i = mid + 1;
            }else {
                j = mid;
            }
        }

        if(nums[i] != target){
            return result;
        }else {
            result[0] = i;
        }

        //search for right
        j = nums.length - 1;
        while (i < j){
            int mid = (i + j) / 2 + 1;
            if(nums[mid] > target){
                j = mid - 1;
            }else {
                i = mid;
            }
        }
        
        result[1] = j;
        return result;
    }