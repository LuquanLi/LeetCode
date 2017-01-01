    public Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;

        dfs(candidates, target, 0, new ArrayList<>());

        result.addAll(set);
        return result;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> list){
        if(target == 0){
            set.add(list);
            return;
        }

        for(int j = i; j < nums.length; j ++){
            if(nums[j] > target) continue;
            List<Integer> templist = new ArrayList<>(list);
            templist.add(nums[j]);
            dfs(nums, target - nums[j], j, templist);
        }
    }