    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        //Add empty
        result.add(new ArrayList<>());

        for(Integer i: nums){
            List<List<Integer>> tmpresult = new ArrayList<>(result);
            for(List<Integer> list: tmpresult){
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(i);
                result.add(tmp);
            }
        }
        return result;
    }