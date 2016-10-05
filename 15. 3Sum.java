    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        
        Arrays.sort(nums);
        int i = 0;
        
        while(i < nums.length - 2){
            int j = i + 1, k = nums.length - 1, ni = nums[i];
            while(j < k){
                int nj = nums[j], nk = nums[k];
                if(ni + nj + nk == 0){
                    result.add(Arrays.asList(ni, nj, nk));
                    while (j < nums.length - 1 && nums[j] == nj) j ++;
                    while (k > 1 && nums[k] == nk) k --;
                }else if(ni + nj + nk < 0){
                    while (j < nums.length - 1 && nums[j] == nj) j ++;
                }else { // > 0
                    while (k > 1 && nums[k] == nk) k --;
                }
            }
            while (i < nums.length - 2 && nums[i] == ni) i ++;
        }

        return result;
    }