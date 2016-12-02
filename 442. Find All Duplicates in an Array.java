    //1. set: O(n) space, O(n) time
    //2. sort: no extra space, O(nlogn) time
    //3. since : 1 ≤ a[i] ≤ n, put the number in right position: nums[i] = i + 1 -> if there is already one in there, list.add
    //4. when find a number i, flip the number at position i-1 to negative. if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        //Check input validation
        if(nums == null || nums.length < 2) return result;
        
        for(int i = 0; i < nums.length; i ++){
            //Get the position the num should be
            int pos = Math.abs(nums[i]) - 1;
            
            //if the position has been visited 
            if(nums[pos] < 0){
                result.add(Math.abs(pos + 1));
            }
            
            nums[pos] = -nums[pos];
        }
        
        return result;
    }