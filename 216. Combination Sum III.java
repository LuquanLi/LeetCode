    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k == 0) return result;

        dfs(n, 1, k, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int n, int i, int k, List<Integer> list, List<List<Integer>> result){
        if(n == 0){
            if(k == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for(int j = i; j < 10; j ++){
            if(j > n) continue;
            List<Integer> templist = new ArrayList<>(list);
            templist.add(j);
            dfs(n - j, j + 1, k - 1, templist, result);
        }
    }