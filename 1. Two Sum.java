    //1. 2 for loop O(n2)
    //2. a hashmap to maintain index and need number, O(n) time, O(n) space
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }