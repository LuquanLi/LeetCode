    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        for(int i = 0; i < nums.length; i ++){
            if(i == 0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                result.add(list);
            }else{
                List<List<Integer>> temp = new ArrayList<>(result);
                result = new ArrayList<>();

                for(List<Integer> list: temp){
                    for(int j = 0; j <= list.size(); j ++){
                        list.add(j, nums[i]);
                        result.add(new ArrayList<>(list));
                        list.remove(j);
                    }
                }
            }
        }

        return result;
    }