//check whether this node is at buttom and sum == val, add to result list, maintain a list to track the path
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        pathSumHelper(root, sum, result, list);
        return result;
    }

    private void pathSumHelper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list){
        if(node  == null) return;

        //check whether this node is at bottom
        if(node.left == null && node.right == null){
            if(node.val == sum){
                list.add(node.val);
                result.add(list);
            }
            return;
        }

        //Not at the bottom, move forward
        list.add(node.val);
        sum -= node.val;

        pathSumHelper(node.left, sum, result, new ArrayList<>(list));
        pathSumHelper(node.right, sum, result, new ArrayList<>(list));
    }