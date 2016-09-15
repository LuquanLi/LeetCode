    //1. Sort, get the middle one, O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //2. HashMap, <number:count> , O(n) time, O(n) space
    public int majorityElement2(int[] nums) {

    }

    //3. O(n) time, O(1) space
    public int majorityElement3(int[] nums) {

        int major = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                count++;
                major = nums[i];
            }else if(major == nums[i]){
                count++;
            }else{
                count--;
            }

        }
        return major;
    }