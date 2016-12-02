//1. count how many 0 1 and 2, 
    //2. two pointers
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int p = 0, q = nums.length - 1, k = 0;

        while (k <= q){
            if(nums[k] == 0){
                swap(nums, p++, k);
            }else if(nums[k] == 2){
                swap(nums, q--, k--);
            }
            k ++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }