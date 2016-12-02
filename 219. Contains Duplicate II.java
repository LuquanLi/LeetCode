    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Create a set to keep the values in slide window
        Set<Integer> set = new HashSet<>();

        //Loop array
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            
            //in java: public boolean add(E e)
            if(!set.add(nums[i])) return true;
        }

        return false;
    }