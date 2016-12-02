    //和442一样 翻过来 再过一遍 正数的是没出现过的
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        //Check input validation
        if(nums == null || nums.length < 2) return result;

        for(int i = 0; i < nums.length; i ++){
            int pos = Math.abs(nums[i]) - 1;
            if(nums[pos] > 0) nums[pos] = -nums[pos];
        }

        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > 0) result.add(i + 1);
        }

        return result;
    }