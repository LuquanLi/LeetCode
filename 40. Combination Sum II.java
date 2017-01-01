    public Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());

        result.addAll(set);
        return result;
    }
    
    private void dfs(int[] nums, int target, int i, List<Integer> list){
        if(target == 0){
            set.add(new ArrayList(list));
            return;
        }

        for(int j = i; j < nums.length; j ++){
            if(nums[j] > target || ( j > i && nums[j] == nums[j - 1])) continue;
            list.add(list.size(), nums[j]);
            dfs(nums, target - nums[j], j + 1, list);
            list.remove(list.size()-1);
        }
    }